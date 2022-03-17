package com.pays.steps;

import com.pays.pages.AcceptCookieFilePage;
import com.pays.pages.CurrencyConversionCalculatorPage;
import com.pays.pages.FooterCurrencyCalulatorPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseGUI {

    private WebDriver driver;
    protected WebDriverWait wait;
    protected CurrencyConversionCalculatorPage calc;
    protected FooterCurrencyCalulatorPage fotCur;
    protected AcceptCookieFilePage cookies1;
    protected Actions action;

    @BeforeTest
    public void open() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver99_0_4844");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.paysera.lt/v2/en-LT/fees/currency-conversion-calculator#/");
        action = new Actions(driver);
        calc = new CurrencyConversionCalculatorPage(driver);
        fotCur = new FooterCurrencyCalulatorPage(driver);
        cookies1 = new AcceptCookieFilePage(driver);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
