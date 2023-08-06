package Api_Automation;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PetStoreAutomationStore {

    @Test
    public void getPetInventory() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
    }

    @Test
    public void getPetInventoryUsingQueryParam() {
        Response response = given()
                .header("Accept","application/json")
                .queryParam("status", "available") // Adding query parameter
                .when()
                .get("https://petstore.swagger.io/v2/store/inventory");
        response.prettyPrint();
    }

    @Test
    public void placeOrder() {
        Response response = given()
                .header("Accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 1,\n" +
                        "  \"petId\": 101,\n" +
                        "  \"quantity\": 1,\n" +
                        "  \"shipDate\": \"2023-07-26T16:08:30.830Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .when()
                .post("https://petstore.swagger.io/v2/store/order");

        response.prettyPrint();
    }

    @Test
    public void getOrderDetailsByOrderId() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .get("https://petstore.swagger.io/v2/store/order/1");
        response.prettyPrint();
    }

    @Test
    public void getOrderDetailsByOrderIdUsingPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .pathParam("orderId", 1) // Adding path parameter
                .when()
                .get("https://petstore.swagger.io/v2/store/order/{orderId}");
        response.prettyPrint();
    }

    @Test
    public void deletePurchaseIdByOrderId() {
        Response response = given()
                .header("Accept","application/json")
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/1");
        response.prettyPrint();
    }

    @Test
    public void deletePurchaseIdByOrderIdUsingPathParam() {
        Response response = given()
                .header("Accept","application/json")
                .pathParam("orderId", 1) // Updating path parameter
                .when()
                .delete("https://petstore.swagger.io/v2/store/order/{orderId}");
        response.prettyPrint();
    }
}
