package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.TimeoutException;

import java.time.Duration;
import java.util.function.Function;

public class Locators {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C://htdocs//Java Selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();

		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		driver.findElement(By.linkText("Forgot your password?")).click();

		// FluentWait
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(100)).ignoring(TimeoutException.class);

		WebDriverWait nativeWait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for the input field with placeholder 'Name' to be visible or timeout
		// occurs
		WebElement nameInput = wait.until(d -> d.findElement(By.xpath("//input[@placeholder='Name']")));
		nameInput.sendKeys("John");

		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

		// Explicit wait for reset-pwd-btn to be clickable
		WebElement resetPwdBtn = nativeWait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".reset-pwd-btn")));

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.className("go-to-login-btn")).click();
		// Continue with the rest of your code
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");

		// Explicit wait for chkboxOne to be clickable

		WebElement chkboxOne = nativeWait.until(ExpectedConditions.elementToBeClickable(By.id("chkboxOne")));
		chkboxOne.click();

		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();

		// Close the browser
//		driver.quit();
	}
}
