package com.petstore.testsuite;

import com.petstore.petstoreinfo.PetSteps;
import com.petstore.testbase.TestBase;
import com.petstore.utils.TestUtils;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.hasValue;


@RunWith(SerenityRunner.class)
public class PetCRUDTest extends TestBase {

    static int id = TestUtils.getRandomNum();
    static String name = "Gauri";
    static String status = "Loved";

    static int petID;

    @Steps
    PetSteps petSteps;

    @Title("This will add a new pet information")
    @Test
    public void test001() {

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("name", "Cow");
        newCategory.put("id", 5);

        List<Object> photoUrl = new ArrayList<>();
        photoUrl.add("https://www.google.com/search?q=gauri+cow&sxsrf=ALiCzsZH2s1LZ6Di5FMt6jRiglgPTqsQBw:1672785928566&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiztbqYvaz8AhWQg_0HHaiNCcgQ_AUoAXoECAEQAw&biw=1536&bih=714&dpr=1.25#imgrc=H25aCsij2OlULM");


        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("id", 1);
        tagHash.put("name", "Devoted");
        tagList.add(tagHash);


        ValidatableResponse response = petSteps.createDataForNewPet(id, newCategory, name, photoUrl, tagList, status);
        response.log().all().statusCode(200);
    }

    @Title("This will find newly added pet information by petID")
    @Test
    public void test002() {

        HashMap<String, Object> petMap = petSteps.findPetById(id);
        Assert.assertThat(petMap, hasValue(id));
        petID = (int) petMap.get("id");

    }

    @Title("This will update newly added pet information")
    @Test
    public void test003() {

        name = name + "_updated";

        HashMap<Object, Object> newCategory = new HashMap<>();
        newCategory.put("id", 5);
        newCategory.put("name", "Cow");

        List<Object> photoUrl = new ArrayList<>();
        photoUrl.add("https://www.google.com/search?q=gauri+cow&sxsrf=ALiCzsZH2s1LZ6Di5FMt6jRiglgPTqsQBw:1672785928566&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiztbqYvaz8AhWQg_0HHaiNCcgQ_AUoAXoECAEQAw&biw=1536&bih=714&dpr=1.25#imgrc=H25aCsij2OlULM");


        List<HashMap<Object, Object>> tagList = new ArrayList<>();
        HashMap<Object, Object> tagHash = new HashMap<>();
        tagHash.put("name", "Devoted");
        tagHash.put("id", 1);
        tagList.add(tagHash);


        ValidatableResponse response = petSteps.updateDataForPet(petID, newCategory, name, photoUrl, tagList, status);
        response.log().all().statusCode(200);

    }
    @Title("Deleting pet info and verifying pet info is delted")
    @Test
    public void test004(){
        petSteps.deletePet(petID).statusCode(200);
        petSteps.findPetByIdAfterDeletion(petID).statusCode(404);

    }

}
