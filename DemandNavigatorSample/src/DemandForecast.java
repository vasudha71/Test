
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class DemandForecast {


	public static void main(String[] args) throws Exception {

		WebDriver driver;
		   System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		//driver =new FirefoxDriver();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://qaapp.forecastera.com/");
		driver.findElement(By.xpath("(.//*[@class='mat-input-element mat-form-field-autofill-control cdk-text-field-autofill-monitored ng-untouched ng-pristine ng-invalid'])[1]")).sendKeys("vasudha.katragunta@forecastera.com");
		   driver.findElement(By.xpath(".//*[@ng-reflect-placeholder='Password']")).sendKeys("Vasudha@123");
		   Thread.sleep(1000);
		   driver.findElement(By.xpath(".//*[text()='Login']")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath(".//*[text()='Workbench']")).click();
		   Thread.sleep(2000);
		   driver.findElement(By.xpath("(.//*[text()='Show More'])[1]")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath(".//*[@class='mat-checkbox-inner-container']")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath(".//*[text()='view_agenda']")).click();
		   Thread.sleep(1000);
		   driver.findElement(By.xpath(".//*[text()=' Quarterly Data']")).click();
		  /* List<WebElement> columnNames = driver.findElements(
		By.xpath(".//*[@class='summary ng-star-inserted']"));
		   ArrayList<String> columns=new ArrayList<String>();
		   for (WebElement ele : columnNames)
		columns.add(ele.getText());
		   System.out.println(columns);
		  
		}*/
		   WebElement demandFCST = driver.findElement(By.xpath(".//*[@id='demandFCST']"));
		   
		   System.out.println("demandFCST :: "+demandFCST);
		   
		   List<WebElement> rowElements = demandFCST.findElements(By.xpath(".//*[@role='row']"));
		   System.out.println("rowElements :: "+rowElements.size());
		   //By.cssSelector("a[href='mysite.com']");
		   
		   
		   HashMap<String,AccountDetails> informationMap = new HashMap<String,AccountDetails>();		   
		   for(WebElement webElement : rowElements){
			   
			   AccountDetails eachAccountDetail =  null;
			   
			   String rowId = webElement.getAttribute("row-id");
			   
			   System.out.println("Row_id :: "+rowId);
			   if(rowId!=null && informationMap.containsKey("rowId")){
				   eachAccountDetail = informationMap.get(rowId);
			   }else if(rowId!=null && !informationMap.containsKey("rowId")){
				   eachAccountDetail = new AccountDetails();
			   }else{
				   rowId = "header";
				   eachAccountDetail = new AccountDetails();
			   }
			   List<WebElement> divTagList =webElement.findElements(By.tagName("div"));
			   System.out.println("DivTagListSize" +divTagList.size());
			   eachAccountDetail = getAccounDetailObject(divTagList, eachAccountDetail);
			   informationMap.put(rowId, eachAccountDetail);
		   }
		System.out.println("Table Data  :: "+informationMap);   
		  
	}
	
	public static AccountDetails getAccounDetailObject(List<WebElement> divTagList, AccountDetails accountDetailObject){
		
		for(WebElement divWebElement : divTagList){
			String colId = divWebElement.getAttribute("col-id");
			
			System.out.println("colId :: "+colId);
			if(colId!=null){
				switch(colId){
				case "m1": accountDetailObject.setM1(divWebElement.getText());
							break;
				case "m2": accountDetailObject.setM2(divWebElement.getText());
							break;
				case "m3": accountDetailObject.setM3(divWebElement.getText());
							break;
				case "m4": accountDetailObject.setM4(divWebElement.getText());
							break;
				case "m5": accountDetailObject.setM5(divWebElement.getText());
							break;
				case "m6": accountDetailObject.setM6(divWebElement.getText());
							break;
				case "m7": accountDetailObject.setM7(divWebElement.getText());
							break;
				case "m8": accountDetailObject.setM8(divWebElement.getText());
							break;
				case "m9": accountDetailObject.setM9(divWebElement.getText());
							break;
				case "m10": accountDetailObject.setM10(divWebElement.getText());
							break;
				case "m11": accountDetailObject.setM11(divWebElement.getText());
							break;
				case "m12": accountDetailObject.setM12(divWebElement.getText());
							break;
				case "q1": accountDetailObject.setQuarter1(divWebElement.getText());
							break;
				case "q2": accountDetailObject.setQuarter2(divWebElement.getText());
							break;
				case "q3": accountDetailObject.setQuarter3(divWebElement.getText());
							break;
				case "q4": accountDetailObject.setQuarter4(divWebElement.getText());
							break;
				case "sno": accountDetailObject.setRowName(divWebElement.getText());
							break;
				default:
						System.out.println("Didnt foun colId :: "+colId);
							break;
			}
			}
			
			
		}
		
		
		return accountDetailObject;
	}

}
