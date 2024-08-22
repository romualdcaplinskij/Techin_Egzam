package lt.techin.calculator;

import com.github.javafaker.Faker;

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

}
