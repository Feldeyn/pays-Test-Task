package com.paysera.steps;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

public class CalcSteps extends BaseGUI {

    private static Map<String, String> currency = Map.of(
            "Lithuania", "EUR",
            "Ukraine", "UAH",
            "Bulgaria", "BGN"
    );

    public void waitValueInSellField() {
        wait.until(ExpectedConditions.visibilityOf(calc.getFieldSell()));
        if (cookies1.getCookiesAcceptPanel().size()!=0) {
            cookies1.getCloseCookiesAcceptPanelButton().click();
        }
        calc.getFieldSell().click();
        wait.until(ExpectedConditions.attributeToBe(calc.getFieldSell(), "value", "100"));
    }

    public void inputSellValue(String value) {
        calc.setFieldSell(value);
    }

    public void inputBuyValue(String value) {
        calc.setFieldBuy(value);
    }

    public void checkFieldIsEmpty(String type) {
        switch (type) {
            case ("Buy"):
                Assert.assertTrue(calc.getFieldBuy().getAttribute("value").equals(""));
                break;
            case ("Sell"):
                Assert.assertTrue(calc.getFieldSell().getAttribute("value").equals(""));
                break;
            default:
                System.out.println("Wrong input parameter");
                Assert.assertTrue(false);
        }
    }

    public void selectCountryInFooter(String country) {
        action.moveToElement(fotCur.getChangeCountryButton());
        fotCur.getChangeCountryButton().click();
        fotCur.getCountryDropDown().click();
        fotCur.selectCountry(country);
    }

    public void checkCurrency(String country) {
        if (country.equals("") || country.equals(null)) {
            Assert.assertEquals(calc.getCurrencySell().getText(), "All");
        } else {
            Assert.assertEquals(calc.getCurrencySell().getText(), currency.get(country), "Wrong currency for this country");
        }
    }

    public void countDif() {
        wait.until(ExpectedConditions.visibilityOfAllElements(calc.getDifSwedBankAmountAndPayseraAmount()));
        double payseraAmount = Double.parseDouble(calc.getPayseraAmount().get(0).getText());
        double swedBankAmount = Double.parseDouble(calc.getSwedBankAmount().get(0).getText());
        double diffExpected = swedBankAmount - payseraAmount;
        diffExpected = roundDecimals(diffExpected,2);
        double diffUI = Double.parseDouble(calc.getDifSwedBankAmountAndPayseraAmount().get(0).getText().replaceAll("[\\(\\)\\s]", ""));
        Assert.assertEquals(diffUI, diffExpected);

    }

    public double roundDecimals(double value, int decim) {
        BigDecimal newValue = new BigDecimal(Double.toString(value));
        newValue=newValue.setScale(decim, RoundingMode.HALF_UP);
        return newValue.doubleValue();
    }
}
