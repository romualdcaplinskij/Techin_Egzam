package lt.techin.calculator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoggedUserPage extends BasePage{
    public LoggedUserPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//nav[@class='navbar navbar-default']//ul[@class='nav navbar-nav navbar-right']/a")
    private WebElement displayedUserName;

    public String getDisplayedUserName(){
        return displayedUserName.getText().replace("Logout, ","");
    }

    public void clickLogout(){
        displayedUserName.click();
    }
}
