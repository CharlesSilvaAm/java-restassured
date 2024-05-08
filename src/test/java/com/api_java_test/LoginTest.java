package com.api_java_test;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class LoginTest extends BaseTest{

    @Test
    public void  RealizarLoginSucesso() {

        String login = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void  RealizarLoginSucessoValidarToken() {

        String login = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(200)
                .body("token", is(notNullValue()));

    }
    @Test
    public void  RealizarLoginSucessoValidarToken2() {

        String login = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        String token = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .path("token");

        System.out.println(token);

    }
    @Test
    public void  RealizarLoginSucessoComAssertToken() {

        String login = "{\n" +
                "    \"email\": \"eve.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(200);

        String token = response.extract().path("token");
        System.out.println(token);


    }
    @Test
    public void  RealizarLoginSomenteComEmail() {

        String login = "{\n" +
                "    \"email\": \"peter@klaven\",\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", notNullValue());
    }
    @Test
    public void  RealizarLoginSomenteComPassword() {

        String login = "{\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", notNullValue());
    }
    @Test
    public void  RealizarLogineEmailEPasswordInvalidos() {

        String login = "{\n" +
                "    \"email\": \"eve.holt@reqres.com\",\n" +
                "    \"password\": \"citysli\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", notNullValue());
    }
    @Test
    public void  RealizarLogineEmailInvalido() {

        String login = "{\n" +
                "    \"email\": \"evee.holt@reqres.in\",\n" +
                "    \"password\": \"cityslicka\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", notNullValue());
    }
    @Test
    public void  RealizarLogineEmailEPasswordVazios() {

        String login = "{\n" +
                "    \"email\": \"\",\n" +
                "    \"password\": \"\"\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .body(login)
                .when()
                .post("/login")
                .then()
                .assertThat()
                .statusCode(400)
                .body("error", notNullValue());
    }
}
