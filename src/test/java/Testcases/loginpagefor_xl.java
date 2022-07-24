package Testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Objectrepository.Addtocartpom;
import Objectrepository.Checkoutpom;
import Objectrepository.Loginpagepom;
import Objectrepository.Purchasepom;
import Utility.Browsernames;

public class loginpagefor_xl {
	static WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		File f = new File("C:\\Users\\Home\\Selenium_Starts\\Rahulshettyacadamy_maven\\config2.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);

		// Mention xl file path in double quotes and need to save xl with the extension
		// as xlsx
		File f1 = new File("");
		FileInputStream fis1 = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis1);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Row r = sheet.getRow(1);
		Cell c = r.getCell(0);
		String username = c.getStringCellValue();
		System.out.println(username);

		Cell c1 = r.getCell(1);
		String password = c1.getStringCellValue();
		System.out.println(password);

		driver = Browsernames.Browser_initialization(p.getProperty("Browsername"));
		Loginpagepom login = new Loginpagepom(driver);
		Addtocartpom addtocartpage = new Addtocartpom(driver);
		Checkoutpom checkoutpage = new Checkoutpom(driver);
		Purchasepom purchasepage = new Purchasepom(driver);

		// WebDriverManager.chromedriver().setup();

		driver.get(p.getProperty("Url"));
		driver.manage().window().maximize();
		// username
		login.setusername(username);
		login.setpassword(password);
		fis.close();
		Thread.sleep(2000);
		// click on add button
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
			String message = "pass";
			Cell c2 = r.createCell(2);
			c2.setCellValue(message);
		}

		FileOutputStream fos = new FileOutputStream(f1);
		workbook.write(fos);
		fos.close();

	}

}
