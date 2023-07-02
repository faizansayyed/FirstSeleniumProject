package com.example;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {
// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C://htdocs//Java Selenium/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.className(".fsw_inputBox.dates")));
		driver.findElement(By.className("fsw_inputBox.dates")).click();
		
		new WebDriverWait(driver, Duration.ofSeconds(10))
				.until(ExpectedConditions.visibilityOfElementLocated(By.className("div.datePickerContainer")));

		Boolean isSelected = false;
		while (!isSelected) {
			List<WebElement> dayPickerMonths = driver.findElements(By.className("DayPicker-Month"));
			for (WebElement dayPickerMonth : dayPickerMonths) {
				System.out.println(
						"Each Month    " + dayPickerMonth.findElement(By.className("DayPicker-Caption")).getText());
				if (dayPickerMonth.findElement(By.className("DayPicker-Caption")).getText().contains("May")) {
					isSelected = true;
					break;
				}
			}
			driver.findElement(By.className("DayPicker-NavButton--next")).click();
		}

//		List<WebElement> dates = driver.findElements(By.className("flatpickr-day"));
////Grab common attribute//Put into list and iterate
//		int count = driver.findElements(By.className("flatpickr-day")).size();
//
//		for (int i = 0; i < count; i++) {
//			String text = driver.findElements(By.className("flatpickr-day")).get(i).getText();
//			if (text.equalsIgnoreCase("21")) {
//				driver.findElements(By.className("flatpickr-day")).get(i).click();
//				break;
//			}
//
//		}
	}

}
