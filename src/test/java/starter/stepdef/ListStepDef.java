package starter.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.ReqresResponses;

import static org.hamcrest.Matchers.equalTo;

public class ListStepDef {

    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list resource correctly")
    public void getListResourceCorrectly() {
        SerenityRest.given().get(ReqresAPI.LIST_RESOURCE);

    }

    @When("Send request get list resources")
    public void sendRequestGetListResources() {
        SerenityRest.when().get(ReqresAPI.LIST_RESOURCE);
    }

    @Given("Get list single user")
    public void getListSingleUser() {
        SerenityRest.given().get(ReqresAPI.LIST_SINGLE);
    }

    @When("Send request get list single user")
    public void sendRequestGetListSingleUser() {
        SerenityRest.given().get(ReqresAPI.LIST_SINGLE);
    }

    @And("Response body should be data id {int}")
    public void responseBodyShouldBeData(int id) {
        SerenityRest.and().body(ReqresResponses.DATA_ID, equalTo(id));
    }



    @Given("Get list single user with invalid page")
    public void getListSingleUserWithInvalidPage() {
        SerenityRest.given().get(ReqresAPI.SINGLE_NOT_FOUND);
    }


    @When("Send request get list single user invalid page")
    public void sendRequestGetListSingleUserInvalidPage() {
        SerenityRest.given().get(ReqresAPI.SINGLE_NOT_FOUND);
    }


}
