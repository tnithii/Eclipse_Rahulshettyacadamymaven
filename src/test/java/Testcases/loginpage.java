package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import Objectrepository.Addtocartpom;
import Objectrepository.Checkoutpom;
import Objectrepository.Loginpagepom;
import Objectrepository.Purchasepom;
import io.github.bonigarcia.wdm.WebDriverManager;
import Utility.Browsernames;

public class loginpage {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		File f = new File("C:\\Users\\Home\\Selenium_Starts\\Rahulshettyacadamy_maven\\config2.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);

		driver = Browsernames.Browser_initialization(p.getProperty("Browsername"));
		Loginpagepom login = new Loginpagepom(driver);
		Addtocartpom addtocartpage = new Addtocartpom(driver);
		Checkoutpom checkoutpage = new Checkoutpom(driver);
		Purchasepom purchasepage = new Purchasepom(driver);

		// WebDriverManager.chromedriver().setup();

		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();
		// username
		login.setusername(p.getProperty("Username_value"));
		login.setpassword(p.getProperty("Password_value"));
		Thread.sleep(2000);
		//click on add button
		login.clickradiobutton();
		Thread.sleep(2000);
		login.dropdown("Student");
		login.clicktermscheckbox();
		login.clicksigninbutton();
		Thread.sleep(2000);
		addtocartpage.clickonaddbutton();
		addtocartpage.clickonfirstcheckoutbutton();
		checkoutpage.clickonsecondcheckout();
		purchasepage.clickontextbox(p.getProperty("text_value"));
		purchasepage.clickonsecondcheckbox();
		purchasepage.clickonpurchasebutton();

		// Success message
		String ele1 = driver.findElement(By.xpath(p.getProperty("Successmessage_locator"))).getText();
		System.out.println(ele1);
		if (ele1.contains("Success! Thank you! Your order will be delivered in next few weeks :-)."))

		{
			System.out.println("valid");
		}

	}

}
