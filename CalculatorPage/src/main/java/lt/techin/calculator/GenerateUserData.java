package lt.techin.calculator;

import com.github.javafaker.Faker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GenerateUserData {

    protected Faker faker;

    public GenerateUserData(){
        this.faker = new Faker();
    }

    public String getUsername(){
        return faker.name().username();
    }

    public String getPassword(){
        return faker.internet().password(6,10,true,true,true);
    }

    public Map<String, String> generateUserDataToMap() {
        Map<String, String> userData = new HashMap<>();
        userData.put("username", getUsername());
        userData.put("password", getPassword());
        return userData;
    }

    public void saveUserDataToCSV(Map<String, String> userData, String filePath) throws IOException {
        boolean fileExists = new java.io.File(filePath).exists();
        //append: true allows to add new lines to the file
        try (FileWriter fileWriter = new FileWriter(filePath, true)) {
            if (!fileExists) {
                //creates header if file does not exist
                fileWriter.append("username,password\n");
            }
            // Write data
            fileWriter.append(String.join(",",
                    userData.get("username"),
                    userData.get("password")
            ));
            //appends new data to the new line
            fileWriter.append("\n");
        }
    }

}
