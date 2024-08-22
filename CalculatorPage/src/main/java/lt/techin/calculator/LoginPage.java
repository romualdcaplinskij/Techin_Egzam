package lt.techin.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "/html//form[@action='/prisijungti']//input[@name='username']")
    private WebElement userNameField;

    @FindBy (xpath = "/html//form[@action='/prisijungti']//input[@name='password']")
    private  WebElement passwordField;

    @FindBy (xpath = "/html//form[@action='/prisijungti']//button[@type='submit']")
    private WebElement loginButton;

    @FindBy (xpath = "/html//div[@class='container']/form[@action='/prisijungti']//a[@href='/registruoti']")
    private WebElement createAccountButton;

    public void clickCreateAccount(){
        createAccountButton.click();
    }

    public void enterUserName(String username){
        userNameField.sendKeys(username);
    }

    public void enterPassword(String password){
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        loginButton.click();
    }
}
