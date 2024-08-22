package lt.techin.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "/html//input[@id='username']")
    private WebElement userNameField;

    @FindBy (xpath = "/html//input[@id='password']")
    private WebElement passwordField;

    @FindBy (xpath = "/html//input[@id='passwordConfirm']")
    private WebElement passwordConfirmationField;

    @FindBy (xpath = "//form[@id='userForm']/button[@type='submit']")
    private WebElement createUserButton;

    public void enterUserName(String username){
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void confirmPassword(String password){
        passwordConfirmationField.sendKeys(password);
    }

    public void clickCreateUserButton(){
        createUserButton.click();
    }
}
