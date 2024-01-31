package org.window;

import java.awt.List;
import java.util.LinkedList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrderMobile {
	
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Deepanraj\\eclipse-workspace\\WindowsHandeling\\library\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox.sendKeys("iphone 14 promax", Keys.ENTER);

		WebElement iphonePurple = driver.findElement(By.xpath("//span[contains(text(),'Apple iPhone 14 Pro Max (256 GB) - Deep Purple')]"));
		iphonePurple.click();

		String parentWindowId = driver.getWindowHandle();
		System.out.println("parent window ID" + parentWindowId);

		Set<String> allWindowID = driver.getWindowHandles();
		System.out.println("All Windos ID" + allWindowID);

		for (String x : allWindowID) {

			if (!parentWindowId.equals(x));
			System.out.println("first child window ID" + x);
			driver.switchTo().window(x);
		}
		
		
		WebElement addToCart = driver.findElement(By.name("submit.add-to-cart"));
		addToCart.click();
		
		//switch back to parent window
		
		driver.switchTo().window(parentWindowId);
		
		WebElement searchBox2 = driver.findElement(By.id("twotabsearchtextbox"));
		searchBox2.clear();
		searchBox2.sendKeys("samsung s23", Keys.ENTER);
		
		WebElement samsungS23 = driver.findElement(By.xpath("//span[contains(text(),'Samsung Galaxy S23 Ultra 5G (Phantom Black, 12GB, 256GB Storage)')][1]"));
		samsungS23.click();
		
	//to find all windows ID again
		
		Set<String> allWindowsID2 = driver.getWindowHandles();
		li = new LinkedList<String>();

		
		
	}
}
