package Objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
public class Loginpagepom {
	WebDriver driver;
	By Username_locator=By.id("username"); 
	By Password_locator =By.id("password");
	By Admin_locator=By.xpath("//*[@id='login-form']/div[4]/div/label[1]/span[2]");
	By StudentDropdown_locator=By.xpath("//*[@id='login-form']/div[5]/select");
	By terms_locator=By.id("terms");
	By Signin_locator=By.id("signInBtn");
	
	public Loginpagepom(WebDriver driver){
		this.driver=driver;
	}
	
	public void setusername(String username)
	{
		driver.findElement(Username_locator).sendKeys(username);
	}
	public void setpassword(String password)
	{
		driver.findElement(Password_locator).sendKeys(password);
		
	}
	public void clickradiobutton()
	{
		driver.findElement(Admin_locator).click();
		
	}
	public void clicktermscheckbox()
	{
		driver.findElement(terms_locator).click();
		
	}
	public void clicksigninbutton()
	{
		driver.findElement(Signin_locator).click();
		
	}
	public void dropdown(String text)
	{
		WebElement ele=driver.findElement(StudentDropdown_locator);
		Select s=new Select(ele);
		s.selectByVisibleText(text);
		
	}
	
}
