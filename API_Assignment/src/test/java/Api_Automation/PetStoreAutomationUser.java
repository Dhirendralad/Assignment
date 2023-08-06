package Api_Automation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class PetStoreAutomationUser {
    @Test
    public void createUser() {
        Response response = given()
            .header("Accept","application/json")
            .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"username\": \"dhlad\",\n" +
                        "    \"firstName\": \"Dhirendra\",\n" +
                        "    \"lastName\": \"Lad\",\n" +
                        "    \"email\": \"dhlad@xyz.co.in\",\n" +
                        "    \"password\": \"hashstar\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 1\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/user");

        response.prettyPrint();
    }
    @Test
    public void createUserUsingPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"username\": \"dhlad\",\n" +
                        "    \"firstName\": \"Dhirendra\",\n" +
                        "    \"lastName\": \"Lad\",\n" +
                        "    \"email\": \"dhlad@xyz.co.in\",\n" +
                        "    \"password\": \"hashstar\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 1\n" +
                        "}")
                .pathParam("username", "dhlad") // Use path parameter
                .when()
                .post("https://petstore.swagger.io/v2/user/{username}"); // Update the URL with the path parameter

        response.prettyPrint();
    }


    @Test
    public void getUserByUserName() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/dhlad");
        response.prettyPrint();
    }

    @Test
    public void getUserByUserNameUsingPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .pathParam("username", "dhlad") // Adding path parameter
                .when()
                .get("https://petstore.swagger.io/v2/user/{username}");
        response.prettyPrint();
    }

    @Test
    public void createUserWithArray() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .body("[\n" +
                        "  {\n" +
                        "    \"id\": 2,\n" +
                        "    \"username\": \"sansingh\",\n" +
                        "    \"firstName\": \"Santosh\",\n" +
                        "    \"lastName\": \"Singh\",\n" +
                        "    \"email\": \"sansingh@xyz.com\",\n" +
                        "    \"password\": \"123456\",\n" +
                        "    \"phone\": \"1234567891\",\n" +
                        "    \"userStatus\": 2\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 3,\n" +
                        "    \"username\": \"rissingh\",\n" +
                        "    \"firstName\": \"Rihabh\",\n" +
                        "    \"lastName\": \"Singh\",\n" +
                        "    \"email\": \"rissingh@xyz.com\",\n" +
                        "    \"password\": \"12345678\",\n" +
                        "    \"phone\": \"1472583690\",\n" +
                        "    \"userStatus\": 3\n" +
                        "  },\n" +
                        "  {\n" +
                        "    \"id\": 4,\n" +
                        "    \"username\": \"TBC\",\n" +
                        "    \"firstName\": \"Mohan\",\n" +
                        "    \"lastName\": \"Barot\",\n" +
                        "    \"email\": \"mobarot@xyz.com\",\n" +
                        "    \"password\": \"123456789\",\n" +
                        "    \"phone\": \"1472583691\",\n" +
                        "    \"userStatus\": 4\n" +
                        "  }\n" +
                        "]")
                .when()
                .post("https://petstore.swagger.io/v2/user/createWithArray");

        response.prettyPrint();
    }

    @Test
    public void getUserLogin() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/login?username=dhlad&password=hashstar");
        response.prettyPrint();
    }

    @Test
    public void getUserLoginUsingQueryParam() {
        Response response = given()
                .header("Accept","application/json")
                .queryParam("username", "dhlad") // Adding query parameter
                .queryParam("password", "hashstar") // Adding query parameter
                .when()
                .get("https://petstore.swagger.io/v2/user/login");
        response.prettyPrint();
    }

    @Test
    public void getUserLogout() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/user/logout");
        response.prettyPrint();
    }

    @Test
    public void updateUserName() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"username\": \"dhilad\",\n" +
                        "    \"firstName\": \"Dhirendra\",\n" +
                        "    \"lastName\": \"Lad\",\n" +
                        "    \"email\": \"dhlad@xyz.co.in\",\n" +
                        "    \"password\": \"hashstar\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 1\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/dhilad");

        response.prettyPrint();
    }

    @Test
    public void updateUserNameUsingPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .pathParam("username", "dhilad") // Updating path parameter
                .body("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"username\": \"dhilad\",\n" +
                        "    \"firstName\": \"Dhirendra\",\n" +
                        "    \"lastName\": \"Lad\",\n" +
                        "    \"email\": \"dhlad@xyz.co.in\",\n" +
                        "    \"password\": \"hashstar\",\n" +
                        "    \"phone\": \"1234567890\",\n" +
                        "    \"userStatus\": 1\n" +
                        "}")
                .when()
                .put("https://petstore.swagger.io/v2/user/{username}");
        response.prettyPrint();
    }

    @Test
    public void deleteUser() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/user/dhlad");
        response.prettyPrint();
    }

    @Test
    public void deleteUserUsingPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .pathParam("username", "dhlad") // Use path parameter
                .when()
                .delete("https://petstore.swagger.io/v2/user/{username}"); // Update the URL with the path parameter

        response.prettyPrint();
    }

}
