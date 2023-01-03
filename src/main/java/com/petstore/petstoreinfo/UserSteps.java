package com.petstore.petstoreinfo;

import com.petstore.constants.EndPoints;
import com.petstore.model.UserPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UserSteps {

    @Step("Creating user with id : {0}, username : {1}, firstName : {2}, lastName : {3}, email : {4}, " +
            "password : {5}, phone {6}, userStatus {7}")
    public ValidatableResponse createUser(int id, String username, String firstName, String lastName, String email,
                                          String password, String phone, int userStatus) {

        UserPojo userPojo = new UserPojo();

        userPojo.setId(id);
        userPojo.setUsername(username);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);


        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .post(EndPoints.CREATE_USER)
                .then().log().all().statusCode(200);

    }

    @Step("Getting the user detail with userID : {0}")
    public HashMap<String, Object> getUserInfoByUserId(Object userID) {
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("userID", userID)
                .get(EndPoints.GET_USER_BY_ID)
                .then().log().all().statusCode(200)
                .extract()
                .path("");

    }

    @Step("Creating user with id : {0}, username : {1}, firstName : {2}, lastName : {3}, email : {4}, " +
            "password : {5}, phone {6}, userStatus {}")
    public ValidatableResponse updateUser(int id, String userID, String firstName, String lastName, String email,
                                          String password, String phone, int userStatus) {

        UserPojo userPojo = new UserPojo();

        userPojo.setId(id);
        userPojo.setUsername(userID);
        userPojo.setFirstName(firstName);
        userPojo.setLastName(lastName);
        userPojo.setEmail(email);
        userPojo.setPassword(password);
        userPojo.setPhone(phone);
        userPojo.setUserStatus(userStatus);


        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(userPojo)
                .when()
                .pathParam("userID", userID)
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then().log().all().statusCode(200);

    }

    @Step("Deleting user by userID")
    public ValidatableResponse deleteUser(String userID){

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("userID", userID)
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then().log().all().statusCode(200);
    }

    @Step("Verifying user is deleted")
    public ValidatableResponse getUserInfoAfterDeletion(Object userID) {
        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("userID", userID)
                .get(EndPoints.GET_USER_BY_ID)
                .then().log().all().statusCode(404);

    }



}
