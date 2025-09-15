package apitests;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class PetStoreAPITests {

    private final String BASE_URL = "https://petstore.swagger.io/";

    @Test
    void createPet_Positive() {
        String body = """
    {
      "id": 1001,
      "category": { "id": 1, "name": "animals" },
      "name": "doggie",
      "photoUrls": ["image"],
      "tags": [ { "id": 1, "name": "dog-tag" } ],
      "status": "available"
    }""";

        RestAssured.given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(body)
                .log().all()
                .when()
                .post("v2/pet")
                .then()
                .log().all()
                .statusCode(200)
                .body("name", equalTo("doggie"))
                .body("status", equalTo("available"))
                .body("id", equalTo(1234));
    }
    @Test
    void createPet_MissingName_Negative() {
        String invalidBody = """
    {
      "id": 1002,
      "category": { "id": 1, "name": "animals" },
      "photoUrls": ["image"],
      "tags": []
    }""";

        RestAssured.given()
                .baseUri(BASE_URL)
                .contentType("application/json")
                .body(invalidBody)
                .log().all()
                .when()
                .post("v2/pet")
                .then()
                .log().all()
                .statusCode(anyOf(is(400), is(200)));
    }



    @Test
    public void getPetPositiveTest() {
        RestAssured.given()
                .when()
                .get(BASE_URL + "v2/pet/1001")
                .then()
                .log().all()
                .statusCode(200)
                .body("id", equalTo(1001));
    }

    @Test
    public void getPetNegativeTest() {
        RestAssured.given()
                .when()
                .get(BASE_URL + "v2/pet/9")
                .then()
                .log().all()
                .statusCode(404);
    }

    @Test
    public void deletePetPositiveTest() {
        RestAssured.given()
                .when()
                .delete(BASE_URL + "v2/pet/1001")
                .then()
                .log().all()
                .statusCode(200);
    }
    @Test
    void deletePet_NonExistingId_Negative() {
        RestAssured.given()
                .baseUri(BASE_URL)
                .when()
                .delete("v2/pet/1001")
                .then()
                .log().all()
                .statusCode(404);
    }
}
