package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class LoginStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("login user with valid email and password with json {string}")
    public void loginUserWithValidEmailAndPasswordWithJson(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.PostloginUser(jsonFile);
    }

    @When("send request post login")
    public void sendRequestPostLogin() {

        SerenityRest.when().post(ReqresAPI.LOGIN_USER);
    }

    @Given("login user without input email and password with json {string}")
    public void loginUserWithoutInputEmailAndPasswordWithJson(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.PostloginUser(jsonFile);
    }


    @Given("login username without password with json {string}")
    public void loginUsernameWithoutPasswordWithJson(String json) {
        File jsonFile = new File (Constants.REQ_BODY+json);
        reqresAPI.PostloginUser(jsonFile);
    }




}
