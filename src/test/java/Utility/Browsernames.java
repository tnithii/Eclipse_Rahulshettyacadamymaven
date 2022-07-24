package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browsernames {
	static WebDriver driver;

	public static WebDriver Browser_initialization(String Browsername) {
		switch (Browsername) {
		case "chrome": {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.get(p.getProperty("Url"));

			break;
		}
		case "edge": {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			//driver.get("https://www.google.com/");

			break;
		}
		}

		return driver;

	}

}
