package com.paysera.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AcceptCookieFilePage extends BasePage {

    public AcceptCookieFilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='panel-body']")
    private List<WebElement> cookiesAcceptPanel;

    @FindBy(xpath = "//*[@class='close-button glyphicon glyphicon-remove']")
    private WebElement closeCookiesAcceptPanelButton;

    public List<WebElement> getCookiesAcceptPanel() {
        return cookiesAcceptPanel;
    }

    public WebElement getCloseCookiesAcceptPanelButton() {
        return closeCookiesAcceptPanelButton;
    }
}
