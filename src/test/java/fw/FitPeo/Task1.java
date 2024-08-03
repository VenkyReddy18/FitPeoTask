package fw.FitPeo;


	import java.time.Duration;

	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	public class Task1 {

		public static void main(String[] args) throws InterruptedException {

	     WebDriver driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
	     driver.get("https://www.fitpeo.com/");
	     
	     WebElement calculator = driver.findElement(By.xpath("//div[text()='Revenue Calculator']"));
	     calculator.click();
	     
	     Thread.sleep(3000);
	     
	     JavascriptExecutor jse = (JavascriptExecutor)driver;
	     jse.executeScript("window.scrollTo(0,350)");
		 
	     
		 Actions actions = new Actions(driver);
		 
		 WebElement sliderButton = driver.findElement(By.xpath("//span[@class='MuiSlider-track css-10opxo5']//following::span[1]"));
		
		  actions.dragAndDropBy(sliderButton, 93, 0).perform();
		  Thread.sleep(3000);
		  WebElement textField = driver.findElement(By.xpath("//input[@aria-invalid='false']"));
		  
		  jse.executeScript("arguments[0].value= '560'",textField);
		  textField.clear();
		  Thread.sleep(3000);
		  actions.dragAndDropBy(sliderButton, 0, 0).perform();
		 
		   driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
		   driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		   driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
		   driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();
		   
		   Thread.sleep(3000);
		   
		   WebElement actualElement = driver.findElement(By.xpath("(//p[@class='MuiTypography-root MuiTypography-body1 inter css-hocx5c'])[4]"));
		   String actualRecurringReimbursement1=actualElement.getText();
		   Thread.sleep(3000);
		   
		    String actualRecurringReimbursement =  actualRecurringReimbursement1;
		    String ExpectedRecurringReimbursement = "110700";
		    
		    if(actualRecurringReimbursement.equals(ExpectedRecurringReimbursement)) {
		    	System.out.println("Total Recurring Reimbursement for all Patients Per Month:110700 is matched");
		    }else {
		    	System.out.println("Total Recurring Reimbursement for all Patients Per Month:110700 is not matched");
		    }
		    
		    driver.quit();
		 
		}

	


	}


