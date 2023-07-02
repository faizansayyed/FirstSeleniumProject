package com.example; // Specify the desired package name

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FirstTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C://htdocs//Java Selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(500)).ignoring(Exception.class);

		driver.get("https://www.amazon.in");

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("jeans for men");

		// Find the element with class "left-pane-results-container"
		wait.until(tempDriver -> tempDriver.findElement(By.className("left-pane-results-container")));
		// Get the text of the first result
//		WebElement firstResult = resultsContainer.findElement(By.xpath(".//div[@class='s-suggestion']/div"));
		WebElement firstResult = wait
				.until(tempDriver -> tempDriver.findElement(By.className("s-suggestion-ellipsis-direction")));

		String firstResultText = firstResult.getText();
		System.out.println("First result exists.   " + firstResultText);
		firstResult.click();

		// Wait for the presence of the element with the specified xpath
		WebElement element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Results')]")));

		// Check if the text result exists
		if (element.isDisplayed()) {
			System.out.println("Text result exists.");

			// Proceed with your test logic here
		} else {
			System.out.println("Text result does not exist.");
			// Handle the case when the text result is not found
		}

	}
}
