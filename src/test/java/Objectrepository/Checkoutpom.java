package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Checkoutpom {
	WebDriver driver;
	
	
	By nextCheckout_locator=By.className("btn-success");
	 
	public Checkoutpom(WebDriver driver) {
		this.driver=driver;
		
	}
	public void clickonsecondcheckout()
	{
		driver.findElement(nextCheckout_locator).click();
	}

}
