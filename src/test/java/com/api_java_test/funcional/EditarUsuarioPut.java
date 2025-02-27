package com.api_java_test.funcional;

import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.clients.ApiClient;
import com.api_java_test.dataprovider.EditarProvider;
import com.api_java_test.dto.EditarDTO;
import com.api_java_test.dto.LoginDTO;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class EditarUsuarioPut extends BaseTest {

    ApiClient apiClient = new ApiClient();

    @Test(dataProvider = "editarUsuarioComSucesso", dataProviderClass = EditarProvider.class)
    public void EditarUsuarioCadastrado(EditarDTO editar, LoginDTO login) {
        ValidatableResponse responseLogin = apiClient.postLogin(login)
                .statusCode(200);
        String token = responseLogin.extract().path("token");
        apiClient.putUser(editar, token)
                .assertThat()
                .statusCode(201)
                .body("name", is(notNullValue()))
                .body("job", is(notNullValue()));
    }
}
