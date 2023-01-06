package com.qa.libraries;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.utilities.TestBase;

public class WaitForElement extends TestBase{
	public static WebElement shortWait(By element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.presenceOfElementLocated(element));
	}

	public static WebElement waitForClickable(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static Boolean textPresent(WebElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static WebElement waitForVisibility(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}

	@SuppressWarnings("deprecation")
	public static WebElement longFluentWait(WebElement element, int max, int polling) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(max))
				.pollingEvery(Duration.ofSeconds(polling))
				.ignoring(NoSuchElementException.class);

		return wait.until(ExpectedConditions.visibilityOf(element));
	}
}
