package starter.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.utils.Constants;

import java.io.File;

public class PatchStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Patch user with valid json {string} and user id {int}")
    public void PatchUserWithValidJsonAndUserId(String json, int id) {
        File jsonFile = new File(Constants.REQ_BODY+json);
        reqresAPI.patchUpdateUser(id, jsonFile);
    }


    @When("Send request patch user")
    public void sendRequestPatchUser() {
        SerenityRest.when().patch(ReqresAPI.UPDATE_USER);
    }


}
