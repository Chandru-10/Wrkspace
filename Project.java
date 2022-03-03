package com.chandru;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Project {

	public static void main(String[] args) throws Throwable {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\PC\\eclipse-workspace\\Selenium\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		WebElement signin = driver.findElement(By.linkText("Sign in"));
		Actions actions = new Actions(driver);
		actions.moveToElement(signin).click().perform();
	
		//Thread.sleep(3000);
		
		
		WebElement log = driver.findElement(By.id("email"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",log);
		log.sendKeys("neymar123@gmail.com");
		actions.sendKeys(Keys.TAB).perform();
		driver.findElement(By.id("passwd")).sendKeys("123456");
		actions.sendKeys(Keys.TAB).perform();
		actions.sendKeys(Keys.TAB).sendKeys(Keys.ENTER).build().perform();
		
		//Thread.sleep(2000);
		
		WebElement tshirt = driver.findElement(By.xpath("(//a[@title='T-shirts'][normalize-space()='T-shirts'])[2]"));
		actions.moveToElement(tshirt).perform();
		actions.keyDown(Keys.CONTROL).click(tshirt).keyUp(Keys.CONTROL).build().perform();
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		String parentWindow = itr.next();
		String childWindow = itr.next();
		driver.switchTo().window(childWindow);
		
		//Thread.sleep(2000);
		
		WebElement img = driver.findElement(By.xpath("//img[@title='Faded Short Sleeve T-shirts']"));
		js.executeScript("arguments[0].scrollIntoView()",img);
		img.click();
		WebElement frame = driver.findElement(By.xpath("//iframe"));
		driver.switchTo().frame(frame);
		driver.findElement(By.cssSelector("button[name='Submit'] span")).click();
		
		Thread.sleep(2000);
			
		driver.navigate().refresh();
		
				
		WebElement contact = driver.findElement(By.cssSelector("a[title='Contact Us']"));
		actions.moveToElement(contact).perform();
		js.executeScript("arguments[0].scrollIntoView", contact);
		
		WebElement cart = driver.findElement(By.cssSelector("a[title='View my shopping cart']"));
		actions.moveToElement(cart).perform();
		
		driver.findElement(By.xpath("(//span[normalize-space()='Check out'])[1]")).click();
		
				
		WebElement proceed = driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']"));
	    actions.moveToElement(proceed).perform();
	    js.executeScript("arguments[0].scrollIntoView()",proceed);
	    proceed.click();
	    
	    Thread.sleep(2000);
	    
	    WebElement proceed1 = driver.findElement(By.xpath("(//button[@name='processAddress'])[1]"));
	    actions.moveToElement(proceed1).perform();
	    js.executeScript("arguments[0].scrollIntoView()",proceed1);
	    proceed1.click();
	    
	    	    
	    WebElement proceed2 = driver.findElement(By.xpath("(//span[contains(text(),'Proceed to checkout')])[2]"));
	    actions.moveToElement(proceed2).perform();
	    js.executeScript("arguments[0].scrollIntoView()",proceed2);
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    proceed2.click();
		
	    WebElement cheque = driver.findElement(By.xpath("//a[@class='cheque']"));
		actions.moveToElement(cheque).build().perform();
		js.executeScript("arguments[0].scrollIntoView",cheque);
		cheque.click();
		
		WebElement confirm = driver.findElement(By.xpath("(//span[normalize-space()='I confirm my order'])[1]"));
		actions.moveToElement(confirm).build().perform();
		js.executeScript("arguments[0].scrollIntoView",confirm);
		confirm.click();
		
		TakesScreenshot pic = (TakesScreenshot) driver;
		File src = pic.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snaps/img.png");
		org.openqa.selenium.io.FileHandler.copy(src, dest);
		
 		
				
		driver.quit();
	}

}
