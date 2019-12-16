package stepDefs;

import io.cucumber.java.en.Given;

public class WeatherStepDefs {
    @Given("Print welcome message")
    public void print_message() {
        System.out.println("Our first step!");
    }

}
