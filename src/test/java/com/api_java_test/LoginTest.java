package com.api_java_test;
import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.clients.ApiClient;
import com.api_java_test.dataprovider.LoginProvider;
import com.api_java_test.dto.LoginDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class LoginTest extends BaseTest {

    ApiClient apiClient = new ApiClient();

    @Test(dataProvider = "loginSucesso", dataProviderClass = LoginProvider.class)
    public void RealizarLoginSucesso(LoginDTO login) {
        apiClient.postLogin(login)
                .statusCode(200);

    }
    @Test(dataProvider = "loginSucessoValidarToken", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginSucessoValidarToken(LoginDTO login) {
        apiClient.postLogin(login)
                .statusCode(200)
                .body("token", is(notNullValue()));

    }
    @Test(dataProvider = "loginSucessoComAssertToken", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginSucessoComAssertToken(LoginDTO login) {
        ValidatableResponse response =
                apiClient.postLogin(login)
                       .statusCode(200);

        String token = response.extract().path("token");
        System.out.println(token);

    }
    @Test(dataProvider = "loginSomenteComEmailValido", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginSomenteComEmail(LoginDTO login) {
         apiClient.postLogin(login)
                .statusCode(400)
                .body("error", notNullValue());

    }
    @Test(dataProvider = "loginSomenteComPasswordValido", dataProviderClass = LoginProvider.class)
    public void  RealizarLoginSomenteComPassword(LoginDTO login) {
        apiClient.postLogin(login)
                .statusCode(400)
                .body("error", notNullValue());

    }
//    @Test
//    public void  RealizarLoginEmailEPasswordInvalidos() {
//
//        login.setEmail("eve.holt@reqres.com");
//        login.setPassword("citysli");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(login)
//                .when()
//                .post("/login")
//                .then()
//                .assertThat()
//                .statusCode(400)
//                .body("error", notNullValue());
//    }
//    @Test
//    public void  RealizarLoginEmailInvalido() {
//
//        login.setEmail("evee.holt@reqres.in");
//        login.setPassword("cityslicka");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(login)
//                .when()
//                .post("/login")
//                .then()
//                .assertThat()
//                .statusCode(400)
//                .body("error", notNullValue());
//    }
//    @Test
//    public void  RealizarLoginEmailEPasswordVazios() {
//
//        login.setEmail("");
//        login.setPassword("");
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(login)
//                .when()
//                .post("/login")
//                .then()
//                .assertThat()
//                .statusCode(400)
//                .body("error", notNullValue());
//    }
}
