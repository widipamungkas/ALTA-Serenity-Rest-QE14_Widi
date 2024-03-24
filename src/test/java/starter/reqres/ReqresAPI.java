package starter.reqres;

import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.checkerframework.checker.units.qual.C;
import starter.utils.Constants;

import java.io.File;

public class ReqresAPI {


    public static String LIST_USERS = Constants.BASE_URL + "/api/users?page={page}";

    public static String LIST_RESOURCE = Constants.BASE_URL+"/api/unknown";

    public static String LIST_SINGLE = Constants.BASE_URL+"/api/users/2";

    public static String SINGLE_NOT_FOUND = Constants.BASE_URL+"/api/users/23";

    public static String CREATE_USER = Constants.BASE_URL + "/api/users";

    public static String UPDATE_USER = Constants.BASE_URL + "/api/users/{id}";

    public static String DELETE_USER = Constants.BASE_URL + "/api/users/";

    public static String LOGIN_USER = Constants.BASE_URL + "/api/login";

    public static String REGISTER = Constants.BASE_URL + "/api/register";

    @Step("Get list user with valid parameter page")
    public void getListUsers(int page) {

        SerenityRest.given().pathParam("page", page);
    }

    @Step("Post create user with valid json")
    public void postCreateUser(File json) {
        SerenityRest.given()
                .contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Update user with valid json and user id")
    public void putUpdateUser(int id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);

    }

    @Step("Delete user with valid user id")
    public void deleteUser(int id) {
        SerenityRest.given().baseUri(this.DELETE_USER.concat(String.valueOf(id)));
    }

    @Step("Delete user with invalid user id")
    public void deleteInvalidUser(String id) {
        SerenityRest.given().baseUri(DELETE_USER.concat(id));
    }


    @Step("Create User With Valid Json")
    public void PostloginUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);


    }

    @Step("Register User With Valid Json")
    public void RegisterUser(File json) {
        SerenityRest.given().contentType(ContentType.JSON)
                .body(json);
    }

    @Step("Patch user with valid json and user id")
    public void patchUpdateUser(int id, File json) {
        SerenityRest.given().pathParam("id", id)
                .contentType(ContentType.JSON)
                .body(json);

    }
}