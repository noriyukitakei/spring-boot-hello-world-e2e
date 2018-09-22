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
		
		// テストを実施したいアプリケーションのURLを環境変数から取得する。
		String url = System.getenv("HELLOWORLD_URL");
		
		// ChromeDriverまでのパスを環境変数から取得する。
		String webdriverPath = System.getenv("WEBDRIVER_PATH");
		
		// ChromeDriverまでのパスを設定する
		System.setProperty("webdriver.chrome.driver", webdriverPath);

		// Chromeをheadlessモードで起動する。
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		
		// Chromeドライバーインスタンスを作成する。
		WebDriver driver = new ChromeDriver(chromeOptions);

		// テストを実施したいアプリケーションのURLを設定する。
		driver.get(url);
		
		// idがhelloという要素を取得する。
		// 実際には<h1 id='hello'>Hello World!!</h1>というHTMLの
		// Hello World!!という部分を取得する処理である。
		WebElement searchElement = driver.findElement(By.id("hello"));
		String title = searchElement.getText();
		
		// ブラウザーを閉じる
		driver.quit();
		
		// 画面に表示されている文字列がHello World!!かどうかをチェックする。
		assertEquals(title, "Hello World!!");
	}

}