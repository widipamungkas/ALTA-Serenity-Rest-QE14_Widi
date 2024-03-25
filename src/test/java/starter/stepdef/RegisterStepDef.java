package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;
import starter.utils.Constants;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("User register with valid email and password {string}")
    public void userRegisterWithValidEmailAndPassword(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.RegisterUser(jsonFile);
    }

    @When("Send request post register")
    public void sendRequestPostRegister() {
        SerenityRest.when().post(ReqresAPI.REGISTER);
    }

    //register negative
    @Given("User register with invalid email and valid password {string}")
    public void userRegisterWithInvalidEmail(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.RegisterUser(jsonFile);
    }

    @And("Response body should shown an error message {string}")
    public void responseBodyShouldShownAnErrorMessage(String error) {
        SerenityRest.and().body(ReqresResponses.ERROR,equalTo(error));
    }


    @Given("User register without input password {string}")
    public void userRegisterWithoutInputPassword(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.RegisterUser(jsonFile);
    }




}
