package lt.techin.calculator;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class CsvDataProvider {

    @DataProvider(name = "randomLoginData")
    //Provides valid user data for LoginTests class login and validation
    public Object[][] randomLoginData() throws IOException, CsvException {
        String path = "src/test/resources/validUserData.csv";

        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            List<String[]> allData = csvReader.readAll();
            // Skip the header row
            allData.removeFirst();

            // Generate a random index within the list
            Random random = new Random();
            int randomIndex = random.nextInt(allData.size());

            // Get the random row
            String[] randomUserData = allData.get(randomIndex);
            String userName = randomUserData[0];
            String password = randomUserData[1];

            // Return the selected username and password
            return new Object[][]{{userName, password}};
        }
    }
}
