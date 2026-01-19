package data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("en-AU"));

    public String tagName = faker.name().firstName();
}
