package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Purchasepom {
	WebDriver driver;
	By Textbox_locator=By.id("country");
	By secondcheckbox_locator=By.xpath("/html/body/app-root/app-shop/div/app-checkout/div/div[2]/label");
	By Purchase_locator=By.className("btn-lg");
		
	public Purchasepom(WebDriver driver)
	{
		this.driver=driver;
	}
	public void clickontextbox(String text)
	{
		driver.findElement(Textbox_locator).sendKeys(text);
	}
	
public void clickonsecondcheckbox() 
{
	driver.findElement(secondcheckbox_locator).click();
}
public void clickonpurchasebutton()
{
	driver.findElement(Purchase_locator).click();
}
}
