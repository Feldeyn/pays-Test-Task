package com.paysera.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CurrencyConversionCalculatorPage extends BasePage {


    public CurrencyConversionCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Sell']/../input")
    private WebElement fieldInputSell;

    @FindBy(xpath = "//*[text()='Buy']/../input")
    private WebElement fieldInputBuy;

    @FindBy(xpath = "//*[text()='Sell']/..//span[@class='ng-binding ng-scope']")
    private WebElement currencySell;

    @FindBy(xpath = "//*[text()='Buy']/..//span[@class='ng-binding ng-scope']")
    private WebElement currencyBuy;

    @FindBy(xpath = "//*[@data-title='Paysera rate']//*[@class='ng-binding']")
    private List<WebElement> payseraAmount;

    @FindBy(xpath = "//*[@data-title='Swedbank amount']//*[@class='ng-binding']")
    private List<WebElement> swedBankAmount;

    @FindBy(xpath = "//*[@data-title='Swedbank amount']//*[@class='other-bank-loss ng-binding ng-scope']")
    private List<WebElement> difSwedBankAmountAndPayseraAmount;

    public void setFieldSell(String value) {
        fieldInputSell.clear();
        fieldInputSell.sendKeys(value);
    }

    public WebElement getFieldSell() {
        return fieldInputSell;
    }

    public void setFieldBuy(String value) {
        fieldInputBuy.clear();
        fieldInputBuy.sendKeys(value);
    }

    public WebElement getFieldBuy() {
        return fieldInputBuy;
    }

    public WebElement getCurrencySell() {
        return currencySell;
    }

    public WebElement getCurrencyBuy() {
        return currencyBuy;
    }

    public List<WebElement> getPayseraAmount() {
        return payseraAmount;
    }

    public List<WebElement> getSwedBankAmount() {
        return swedBankAmount;
    }

    public List<WebElement> getDifSwedBankAmountAndPayseraAmount() {
        return difSwedBankAmountAndPayseraAmount;
    }
}
