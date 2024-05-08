package com.api_java_test;

import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.dto.EditarDTO;
import com.api_java_test.dto.LoginDTO;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class EditarUsuario extends BaseTest {

    LoginDTO login = new LoginDTO();
    EditarDTO editar = new EditarDTO();

    @Test
    public void EditarUsuarioCadastrado() {

        login.setEmail("eve.holt@reqres.in");
        login.setPassword("cityslicka");

        editar.setName("morpheus");
        editar.setJob("zion resident");

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

        given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body(editar)
                .when()
                .post("users/2")
                .then()
                .statusCode(201);

    }
}
