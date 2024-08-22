package lt.techin.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CalculatorMainPage extends BasePage{
    public CalculatorMainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//nav[@class='navbar navbar-default']//ul[@class='nav navbar-nav navbar-right']/a")
    protected WebElement displayedUserName;

    @FindBy(xpath = "//form[@id='number']/input[@name='sk1']")
    private WebElement firstNumberField;

    @FindBy (xpath = "//form[@id='number']/input[@name='sk2']")
    private WebElement secondNumberField;

    @FindBy (xpath = "//form[@id='number']/select[@name='zenklas']")
    private WebElement mathOptionDropdown;

    @FindBy (xpath = "//form[@id='number']/input[@value='skaičiuoti']")
    private WebElement calculateButton;

    @FindBy (xpath = "//body[@class='container']/h4")
    private WebElement calculationResult;

    public String getCalculationResult(){
        return calculationResult.getText();
    }

    public void enterFirstNumber(String  input){
        firstNumberField.clear();
        firstNumberField.sendKeys(input);
    }
    public void enterSecondNumber(String input){
        secondNumberField.clear();
        secondNumberField.sendKeys(input);
    }

    public void selectAddition(){
        Select select = new Select(mathOptionDropdown);
        select.selectByVisibleText("Sudėtis");
    }

    public void selectSubtraction(){
        Select select = new Select(mathOptionDropdown);
        select.selectByVisibleText("Atimtis");
    }

    public void selectMultiplication(){
        Select select = new Select(mathOptionDropdown);
        select.selectByVisibleText("Daugyba");
    }

    public void selectDivision(){
        Select select = new Select(mathOptionDropdown);
        select.selectByVisibleText("Dalyba");
    }

    public void clickCalculate(){
        calculateButton.click();
    }

    public String getDisplayedUserName(){
        return displayedUserName.getText().replace("Logout, ","");
    }

    public void clickLogout(){
        displayedUserName.click();
    }
}
