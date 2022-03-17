package com.paysera.test;

import com.paysera.steps.CalcSteps;
import org.testng.annotations.Test;


public class CurrencyConversionCalculatorTest extends CalcSteps{

    @Test
    public void checkSellFieldEmptyAfterFillFieldBuy() {
        waitValueInSellField();
        inputSellValue("123");
        checkFieldIsEmpty("Buy");
        inputBuyValue("456");
        checkFieldIsEmpty("Sell");
        inputSellValue("789");
        checkFieldIsEmpty("Buy");
    }

    @Test
    public void checkCurrencyAfterCountryChanges() {
        waitValueInSellField();
        selectCountryInFooter("Ukraine");
        waitValueInSellField();
        checkCurrency("Ukraine");
        selectCountryInFooter("Bulgaria");
        waitValueInSellField();
        checkCurrency("Bulgaria");
    }

    @Test
    public void checkDifferentBetweenValuesSwedBankAndPaysera() {
        waitValueInSellField();
        selectCountryInFooter("Lithuania");
        countDif();
    }
}
