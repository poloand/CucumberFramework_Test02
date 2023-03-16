package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;


public class APISteps {
    private String var;

    public String getVar() {
        return var;
    }

    @Given("^user sends \"([^\"]*)\" request to URL \"([^\"]*)\"$")
    public void SendRequestToUrl(String request, String url) {
        var = String.valueOf(given()
                .get(url)
                .getStatusCode());
    }

    @Then("check status code is \"([^\"]*)\"$")
    public void checkStatusCodeIs(String code) {
        Assertions.assertEquals(code, getVar());
    }
}