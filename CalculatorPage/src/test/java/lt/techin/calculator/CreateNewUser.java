package lt.techin.calculator;

import org.testng.annotations.Test;

public class CreateNewUser extends TestSetup{

    @Test
    public void createNewValidUser(){
        loginPage = new LoginPage(driver);
        loginPage.clickCreateAccount();
    }
}
