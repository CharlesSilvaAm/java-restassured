package com.api_java_test.contrato;

import com.api_java_test.baseteste.BaseTest;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ListTest extends BaseTest {
    @Test()
    public void validarContratoListarUsuario() {
        given()
                .contentType(ContentType.JSON)
                .relaxedHTTPSValidation()
                .when()
                .get("users?page=2")
                .then()
                .body(matchesJsonSchemaInClasspath("json_schemas/GET_LIST_USERS.json"));
    }
}


