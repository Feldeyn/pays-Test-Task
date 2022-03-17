package com.paysera.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FooterCurrencyCalulatorPage extends BasePage {

    public FooterCurrencyCalulatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//span[@class='js-localization-popover']")
    private WebElement changeCountryButton;

    @FindBy(id = "countries-dropdown")
    private WebElement countryDropDown;

    @FindBy(xpath = "//*[@id='countries-dropdown']/following-sibling::ul/li")
    private List<WebElement> country;

    public WebElement getChangeCountryButton() {
        return changeCountryButton;
    }

    public WebElement getCountryDropDown() {
        return countryDropDown;
    }

    public List<WebElement> getCountry() {
        return country;
    }

    public void selectCountry(String countryForSelect) {
        for (WebElement a: country){
            String country = a.findElement(By.xpath(".//a")).getText();
            if (country.equals(countryForSelect)) {
                a.click();
                break;
            }
        }
    }
}
