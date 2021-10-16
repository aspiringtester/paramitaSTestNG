package pages;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utility.BaseTest;
import utility.ExcelReading;

public class Contact extends BaseTest{

	By firstname=By.xpath("//*[@id=\"fname\"]");
	By lastname=By.xpath("//*[@id=\"lname\"]");
	
	By fgender = By.xpath("//input[@value='female']");
	By mgender = By.xpath("//input[@value='male']");
	By ogender = By.xpath("//input[@value='other']");
	By wemail = By.xpath("//input[@id='email']");
	By subject = By.xpath("//textarea[@id='subject']");
	
	By submit =By.xpath("//input[@type='submit']");
	
	By nav = By.cssSelector("div.topnav");
	
	
	public static Logger log = (Logger) LogManager.getLogger(Contact.class);
	
	
	public WebDriver driver;
	@BeforeTest
	public void firstOpen() throws IOException, InterruptedException {
		driver = getDriver();
		driver.get(getWebpage());
		
		log.info("driver initialized");
		
	}
	
	@AfterTest
	public void endofTest() {
		driver.close();	
		log.info("driver closed");
	}
	
	@Test
	public void validateTitle() throws IOException, InterruptedException {
		
	String title = 	driver.getTitle();
	
	
	// This is set to fail to test the framework is working.The title given here, is wrong.
	Assert.assertEquals(title, "contact");
	
		log.info("title validated");
		}
	
	
	@Test
	public void presenceOfNavbar() throws IOException, InterruptedException {
		Assert.assertTrue(driver.findElement(nav).isDisplayed());
		
		log.info("navBar is displayed");
		
	
		
		
	}
	
	
	
	@DataProvider(name="aformData")
	public Object[][] aformData() throws IOException{
		
		ExcelReading excel = new ExcelReading("C:\\Users\\61468\\eclipse-workspace\\listeners\\AspiringTestingFramework\\src\\main\\java\\resources\\testData.xlsx", "td1");	
		
		int rows = excel.getRowCount();
		int cols = excel.getColumnCount();
		
		
		
		Object[][] data = new Object[rows][cols];
		
		for (int r=1; r<rows; r++) {
			
			for (int c=0; c<cols; c++) {
				
				data[r][c] = excel.getCellData(r, c);
				
				//System.out.println(data[r][c]);
				//System.out.println();
			}//cols ended
			
			
			
			
		}//rows end
				
				return data;
			
		}
	
	
	@Test(dataProvider="aformData")

	public void formTesting(String fname, String lname, String country1, String g, String email, String msg) throws IOException, InterruptedException {
		
		//driver = getDriver();
		
		//driver.get(getWebpage());
		//first and last name
		
		if(fname!=null) {
		driver.findElement(firstname).sendKeys(fname);
		
		
	driver.findElement(lastname).sendKeys(lname);
		
	//select country
	
	Select select = new Select(driver.findElement(By.xpath("//select[@id='country']")));
	
	
	select.selectByValue(country1);
	
		//select gender
	
	if (g=="Female") {
		
		
		driver.findElement(fgender).click();	
		
		}else if (g=="Male")
            {
	
		driver.findElement(mgender).click();
		
                }else
                	
                	
                {driver.findElement(ogender).click();}
                	
        //email
	driver.findElement(wemail).sendKeys(email);
	//subject
	driver.findElement(subject).sendKeys(msg);
		     
		driver.findElement(submit).click();
		
		log.info("successfully submitted");
		
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
