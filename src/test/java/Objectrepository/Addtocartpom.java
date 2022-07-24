package Objectrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Addtocartpom {
WebDriver driver;

	By Add_locator=By.xpath("/html/body/app-root/app-shop/div/div/div[2]/app-card-list/app-card[1]/div/div[2]/button");
	By Checkout_locator=By.className("btn-primary");
	
	public Addtocartpom(WebDriver driver)
	{
			this.driver=driver;
	}
	public void clickonaddbutton()
	{
		driver.findElement(Add_locator).click();
	}
	public void clickonfirstcheckoutbutton()
	{
		driver.findElement(Checkout_locator).click();
	}
			
			
}
