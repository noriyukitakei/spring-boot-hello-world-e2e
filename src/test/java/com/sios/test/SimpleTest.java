package com.sios.test;
import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SimpleTest {

	
	@Test
	public void test() throws InterruptedException {
		// ChromeDriverまでのパスを設定する
		System.setProperty("webdriver.chrome.driver", "/var/lib/jenkins/chromedriver");

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		// Chromeドライバーインスタンスを作成する
		WebDriver driver = new ChromeDriver(chromeOptions);

		// Google.comにアクセスする
		driver.get("https://www.google.com");

		// 表示しているページのTitleを出力する
		System.out.println("Page title is: " + driver.getTitle());

		String title = driver.getTitle();
		Thread.sleep(1000);

		// 検索ワード入力エレメントに、検索ワードを渡して、submitする
		WebElement searchElement = driver.findElement(By.name("q"));
		searchElement.sendKeys("Cheese!");

		Thread.sleep(1000);

		searchElement.submit();

		// ページが更新するまで待つ（Timeoutは10秒)
		new WebDriverWait(driver, 10).until(
				(ExpectedCondition<Boolean>) webDriver -> webDriver.getTitle().toLowerCase().startsWith("cheese!"));

		// ページ更新後のTitleを出力する
		System.out.println("Page title is: " + driver.getTitle());

		Thread.sleep(1000);

		// ブラウザーを閉じる
		driver.quit();
		
		assertEquals(title, "Google");
	}

}
