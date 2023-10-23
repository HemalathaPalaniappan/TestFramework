package com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.step.Hooks;

public class Utilities extends BaseClass {

public static void mouseOver(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}
	public static void LaunchUrl(String url) {
		
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	public static void enterText(WebElement element, String value) {
		element.sendKeys(value);
	}
	
	public static void click(WebElement element) {
		element.click();
	}
	
	public static void selectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public static void selectByText(WebElement element, String text) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	public static void selectByIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public static WebElement locateById(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}
	public static WebElement locateByName(String name) {
		WebElement findElement = driver.findElement(By.name(name));
		return findElement;
	}
	public static WebElement locateByClass(String className) {
		WebElement findElement = driver.findElement(By.className(className));
		return findElement;
	}
	public static WebElement locateByXpath(String xpathExp) {
		WebElement findElement = driver.findElement(By.id(xpathExp));
		return findElement;
	}
	
	public static  String propertyFile(String value) throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\Config\\config.properties");
		FileInputStream fileInputStream = new FileInputStream(file);
		Properties properties = new Properties();
		properties.load(fileInputStream);
		String property = properties.getProperty(value);
		return property;
	}
	
	public static String getValueAttribute(WebElement element, String value) {
		return element.getAttribute(value);
	}
	
	public static boolean elementDisplayed(WebElement element) {
		
		return element.isDisplayed();
		
	}
	
	public static WebElement getElement(WebElement element) {
		return element;
		
	}
	
	public static String getElementText(WebElement element) {
		return element.getText();
	}
}