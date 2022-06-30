package com.hitema.sakila;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {


	@Test
	void openBrowser(){
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Developpeur\\Documents\\Formations\\Ecoles\\HITEMA\\2021-2022\\M1 - IoT\\JAVA\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		ChromeOptions options = new ChromeOptions();
		var driver = new ChromeDriver(options);

		driver.quit();

	}

	@Test
	void contextLoads() {
	}

}
