package lt.techin.calculator;

import org.testng.annotations.Test;

public class CalculatorTests extends TestSetup{

    @Test (dataProvider = "randomLoginData", dataProviderClass = CsvDataProvider.class)
    public void addTwoPositiveIntegers(String username, String password){
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        String firstNumber = generateUserData.getRandomDigit();
        String secondNumber = generateUserData.getRandomDigit();
        calculatorMainPage.enterFirstNumber(firstNumber);
        calculatorMainPage.enterSecondNumber(secondNumber);
        calculatorMainPage.selectAddition();
        calculatorMainPage.clickCalculate();
        String result = calculatorMainPage.getCalculationResult().replaceAll("[0-9]+ \\+/-\\* [0-9]+ = \\d", "");
        System.out.println(result);
    }
}
