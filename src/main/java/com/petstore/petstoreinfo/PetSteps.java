package com.petstore.petstoreinfo;

import com.petstore.constants.EndPoints;
import com.petstore.model.PetPojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;
import java.util.List;

public class PetSteps {

    @Step("Thiw will create new Pet detail with id : {0}, category : {1}, name : {2}, photoUrls : {3}, tags : {4}, status : {5}")
    public ValidatableResponse createDataForNewPet(int id, HashMap<Object, Object> category, String name, List<Object> photoUrls,
                                                   List<HashMap<Object, Object>> tags, String status) {

        PetPojo petPojo = new PetPojo();

        petPojo.setId(id);
        petPojo.setCategory(category);

        petPojo.setName(name);
        petPojo.setPhotoUrls(photoUrls);

        petPojo.setTags(tags);

        petPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .post(EndPoints.CREATE_PET)
                .then().log().all().statusCode(200);

    }

    @Step("Verifying that pet information added with petId : {0}")
    public HashMap<String, Object> findPetById(Object petID) {

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("petID", petID)
                .get(EndPoints.GET_PET_BY_ID)
                .then().log().all().statusCode(200)
                .extract()
                .path("");

    }

    @Step("Thiw will update Pet detail with id : {0}, category : {1}, name : {2}, photoUrls : {3}, tags : {4}, status : {5}")
    public ValidatableResponse updateDataForPet(int petID, HashMap<Object, Object> category, String name, List<Object> photoUrls,
                                                   List<HashMap<Object, Object>> tags, String status) {

        PetPojo petPojo = new PetPojo();

        petPojo.setId(petID);
        petPojo.setCategory(category);

        petPojo.setName(name);
        petPojo.setPhotoUrls(photoUrls);

        petPojo.setTags(tags);

        petPojo.setStatus(status);

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .body(petPojo)
                .when()
                .put(EndPoints.UPDATE_PET_BY_ID)
                .then().log().all().statusCode(200);
    }


    @Step("This will delete pet info by petID : {0}" )
    public ValidatableResponse deletePet(int petID){

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("petID", petID)
                .delete(EndPoints.DELETE_PET_BY_ID)
                .then().statusCode(200);
    }
    @Step("Verifying that pet information after deletion with petId : {0}")
    public ValidatableResponse findPetByIdAfterDeletion(Object petID) {

        return SerenityRest.given().log().all()
                .header("Content-Type", "application/json")
                .when()
                .pathParam("petID", petID)
                .get(EndPoints.GET_PET_BY_ID)
                .then().log().all().statusCode(404);

    }
}