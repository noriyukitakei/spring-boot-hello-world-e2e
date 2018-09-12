package com.sios.test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class E2ETest {
	
	@Test
	public void test() throws InterruptedException {
		// ChromeDriverまでのパスを設定する
		System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/chromedriver");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		// Chromeドライバーインスタンスを作成する
		WebDriver driver = new ChromeDriver(chromeOptions);

		driver.get("https://ntakeidevops.azurewebsites.net/helloworld/hello");

		WebElement searchElement = driver.findElement(By.id("hello"));
		String title = searchElement.getText();
		
		// ブラウザーを閉じる
		driver.quit();
		
		assertEquals(title, "Hello World!!");
	}

}
