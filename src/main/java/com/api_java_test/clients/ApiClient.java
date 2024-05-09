package com.api_java_test.clients;

import com.api_java_test.dto.EditarDTO;
import com.api_java_test.dto.LoginDTO;
import com.api_java_test.dto.UsuarioDTO;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public ValidatableResponse postLogin(LoginDTO login) {

        return given()
                    .contentType(ContentType.JSON)
                    .body(login)
                    .when()
                    .post("/login")
                    .then()
                    .assertThat();
    }
    public ValidatableResponse postCreateUser(UsuarioDTO user, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body(user)
                .when()
                .post("/users")
                .then();
    }
    public ValidatableResponse putUser(EditarDTO editar, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body(editar)
                .when()
                .post("users/2")
                .then();
    }
    public ValidatableResponse patchUser(EditarDTO patch, String token) {
        return given()
                .contentType(ContentType.JSON)
                .header("token", token)
                .body(patch)
                .when()
                .post("users/2")
                .then();
    }

}
