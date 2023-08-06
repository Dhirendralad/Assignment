package Api_Automation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetStoreAutomationPet {

    @Test
    public void uploadImage() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","multipart/form-data")
                .multiPart("additionalMetadata", "New Pet In Store")
                .multiPart("file", new File("C:\\Users\\HP\\Downloads\\Pet 1.jpg"), "image/jpeg")
                .when()
                .post("https://petstore.swagger.io/v2/pet/99/uploadImage");

        response.prettyPrint();
    }

    @Test
    public void addNewPetToThePetStore() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 1,\n" +
                        "    \"category\": {\n" +
                        "      \"id\": 101,\n" +
                        "      \"name\": \"Labrador\"\n" +
                        "    },\n" +
                        "    \"name\": \"Tiger\",\n" +
                        "    \"photoUrls\": [\n" +
                        "      \"C:\\\\Users\\\\HP\\\\Downloads\\\\Pet 1.jpg\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "      {\n" +
                        "        \"id\": 210,\n" +
                        "        \"name\": \"Tiger\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"status\": \"Last one\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"category\": {\n" +
                        "      \"id\": 102,\n" +
                        "      \"name\": \"Golden Retriever\"\n" +
                        "    },\n" +
                        "    \"name\": \"Max\",\n" +
                        "    \"photoUrls\": [\n" +
                        "      \"C:\\\\Users\\\\HP\\\\Downloads\\\\Pet 2.jpg\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "      {\n" +
                        "        \"id\": 211,\n" +
                        "        \"name\": \"Max\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"status\": \"Available\"\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 3,\n" +
                        "    \"category\": {\n" +
                        "      \"id\": 103,\n" +
                        "      \"name\": \"Bulldog\"\n" +
                        "    },\n" +
                        "    \"name\": \"Rocky\",\n" +
                        "    \"photoUrls\": [\n" +
                        "      \"C:\\\\Users\\\\HP\\\\Downloads\\\\Pet 3.jpg\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "      {\n" +
                        "        \"id\": 212,\n" +
                        "        \"name\": \"Rocky\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"status\": \"Sold\"\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();
    }

    @Test
    public void updateExistingPet() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"category\": {\n" +
                        "      \"id\": 101,\n" +
                        "      \"name\": \"Labrador\"\n" +
                        "    },\n" +
                        "    \"name\": \"Tiger\",\n" +
                        "    \"photoUrls\": [\n" +
                        "      \"C:\\\\Users\\\\HP\\\\Downloads\\\\Pet 1.jpg\"\n" +
                        "    ],\n" +
                        "    \"tags\": [\n" +
                        "      {\n" +
                        "        \"id\": 210,\n" +
                        "        \"name\": \"Tiger\"\n" +
                        "      }\n" +
                        "    ],\n" +
                        "    \"status\": \"Sold\"\n" +
                        "  }")
                .when()
                .put("https://petstore.swagger.io/v2/pet");

        response.prettyPrint();
    }

    @Test
    public void getPetsByStatusAvailable() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        response.prettyPrint();
    }
    @Test
    public void getPetsByStatusAvailableUsingQueryParam() {
        Response response = given()
                .header("Accept","application/json")
                .queryParam("status", "available") // Adding query parameter
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
        response.prettyPrint();
    }


    @Test
    public void getPetsByStatusPending() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=pending");
        response.prettyPrint();
    }

    @Test
    public void getPetsByStatusPendingUsingQueryParam() {
        Response response = given()
                .header("Accept","application/json")
                .queryParam("status", "pending") // Using query parameter
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
        response.prettyPrint();
    }


    @Test
    public void getPetsByStatusSold() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus?status=sold");
        response.prettyPrint();
    }

    @Test
    public void getPetsByStatusSoldUsingQueryParam() {
        Response response = given()
                .header("Accept","application/json")
                .queryParam("status", "sold") // Adding query parameter
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByStatus");
        response.prettyPrint();
    }

    @Test
    public void getPetsByTags() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByTags?tags=cute");
        response.prettyPrint();
    }

    @Test
    public void getPetsByTagsUsingQueryParam() {
        Response response = given()
                .header("Accept","application/json")
                .queryParam("tags", "cute") // Adding query parameter
                .when()
                .get("https://petstore.swagger.io/v2/pet/findByTags");
        response.prettyPrint();
    }

    @Test
    public void getPetsById() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/pet/1234321");
        response.prettyPrint();
    }

    @Test
    public void getPetsByIdUsingPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .pathParam("petId", 1234321) // Adding path parameter
                .when()
                .get("https://petstore.swagger.io/v2/pet/{petId}");
        response.prettyPrint();
    }

    @Test
    public void updatePetInPetStoreUsingFormData() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/x-www-form-urlencoded")
                .body("name=Tommy&status=Sold")
                .when()
                .post("https://petstore.swagger.io/v2/pet/9222968140497183000");

        response.prettyPrint();
    }

    @Test
    public void updatePetInPetStoreUsingFormDataAndPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/x-www-form-urlencoded")
                .pathParam("petId", 9222968140497183000L) // Updating path parameter
                .body("name=Tommy&status=Sold")
                .when()
                .post("https://petstore.swagger.io/v2/pet/{petId}");
        response.prettyPrint();
    }

    @Test
    public void deleteAPet() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/pet/9222968140497183000");
        response.prettyPrint();
    }

    @Test
    public void deleteAPetUsingPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .pathParam("petId", "9222968140497183000") // Adding path parameter
                .when()
                .delete("https://petstore.swagger.io/v2/pet/{petId}");
        response.prettyPrint();
    }
}
