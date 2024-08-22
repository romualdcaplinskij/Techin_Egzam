package lt.techin.calculator;

import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Map;

public class UserRegistrationTests extends TestSetup{
    GenerateUserData userDataGenerator = new GenerateUserData();
    private static final String CSV_FILE_PATH = "src/test/resources/validUserData.csv";

    private final String emptyNameFieldErrorMsg = "Šį laukelį būtina užpildyti\n" +
            "Privaloma įvesti nuo 3 iki 32 simbolių";

    @Test
    public void createNewValidUser() throws IOException, InterruptedException {
        /*takes user data from FakerUserDataGenerator class, maps it. Runs registration test and saves valid
        user credentials to CSV file, that can be used for login tests.*/
        Map<String, String> userData = userDataGenerator.generateUserDataToMap();
        userDataGenerator.saveUserDataToCSV(userData, CSV_FILE_PATH);

        loginPage.clickCreateAccount();
        registerPage.enterUserName(userData.get("username"));
        registerPage.enterPassword(userData.get("password"));
        registerPage.confirmPassword(userData.get("password"));
        System.out.println("Testing with: \n===============================================");
        System.out.println("Firstname: " + userData.get("username"));
        System.out.println("Lastname: " + userData.get("password"));
        registerPage.clickCreateUserButton();
        String displayedUserName = calculatorMainPage.getDisplayedUserName();
        //If registration is successful username should be displayed.
        Assert.assertEquals(displayedUserName, userData.get("username"),
                "Registration was unsuccessful or username is not displayed");
        calculatorMainPage.clickLogout();
    }

    @Test
    public void failingRegistrationTest(){
        loginPage.clickCreateAccount();
        registerPage.enterUserName("user");
        registerPage.enterPassword("password");
        registerPage.confirmPassword("");
        registerPage.clickCreateUserButton();
        String displayedUserName = calculatorMainPage.getDisplayedUserName();
        Assert.assertEquals(displayedUserName, "user",
                "Registration was unsuccessful or username is not displayed");
    }

    @Test
    public void emptyUserNameTest(){
        loginPage.clickCreateAccount();
        registerPage.enterUserName("");
        registerPage.enterPassword("password");
        registerPage.confirmPassword("password");
        registerPage.clickCreateUserButton();
        softAssert.assertFalse(registerPage.getUserNameFieldErrorMessage().isEmpty());
        softAssert.assertEquals(emptyNameFieldErrorMsg, registerPage.getUserNameFieldErrorMessage(),
                "Error message is displayed, but not that expected");
    }
}
