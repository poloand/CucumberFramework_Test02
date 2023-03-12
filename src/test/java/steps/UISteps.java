package steps;

//import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.open;

public class UISteps {

    @Given("^user opens the next URL \"([^\"]*)\"$")
    public void openUrl(String url){
        Configuration.browserSize = "1920x1080";
        open(url);
    }

    @Given("^user enters \"([^\"]*)\" as \"([^\"]*)\"$")
    public void userEnteredIntoField(String fieldName, String fieldValue){
        String name;
        if(fieldName.equals("Login")){
            name = "uid";
        } else {
            if(fieldName.equals("Password")) {
                name = "password";
            } else {
                name = "ERROR";
                System.out.println("UserID or Password field is WRONG");
            }
        }
        WebDriverRunner.getWebDriver().findElement(By.name(name)).sendKeys(fieldValue);
    }

    @Given("^user clicked the button \"([^\"]*)\"$")
    public void clickTheButton(String buttonName){
        WebDriverRunner.getWebDriver().findElement(By.name(buttonName)).click();
    }

    @Given("^URL is \"([^\"]*)\"$")
    public void checkURL(String url){
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(currentUrl, url);
    }

    @And("^field \"([^\"]*)\" is empty")
    public void fieldIsEmpty(String fieldName) {
        String name;
        if(fieldName.equals("Login")){
            name = "uid";
        } else {
            if(fieldName.equals("Password")) {
                name = "password";
            } else {
                name = "ERROR";
                System.out.println("Neither UserID nor Password field is taken");
            }
        }
        String value = WebDriverRunner.getWebDriver().findElement(By.name(name)).getText();
        Assertions.assertEquals("", value);
    }

    @And("check login and password fields are empty")
    public void checkLoginAndPasswordFieldsAreEmpty() {
        String login = WebDriverRunner.getWebDriver().findElement(By.name("uid")).getText();
        String password = WebDriverRunner.getWebDriver().findElement(By.name("password")).getText();
        Assertions.assertEquals("", login);
        Assertions.assertEquals("", password);
    }
}
