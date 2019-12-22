package stepDefs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import model.Response;
import org.junit.jupiter.api.Assertions;
import requesters.WeatherRequester;

public class WeatherStepDefs {

    private String city;
    private Response response;

    @Given("city is: (.*)")        //  (.*) - эквивалент любой строки; (.) - эквивалент любого символа
    public void set_city(String city) {
        this.city = city;
    }

    /*
    1) send request
    2) receive response
    3) map response */

    @When("we are requesting weather")
    public void request_weather() throws JsonProcessingException {
        WeatherRequester requester = new WeatherRequester();
        response = requester.requestWeather(city);

    }

    @Then("lon is (.*)")
    public void check_lon(Double lon) {
        Assertions.assertEquals(lon, response.getCoord().getLon(), "Wrong lon");
    }

    @Then("lat is (.*)")
    public void check_lat(Double lat) {
        Assertions.assertEquals(lat, response.getCoord().getLat(), "Wrong lat");

    }

}
