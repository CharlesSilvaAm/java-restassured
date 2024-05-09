package com.api_java_test;

import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.clients.ApiClient;
import com.api_java_test.dataprovider.EditarProvider;
import com.api_java_test.dto.EditarDTO;
import com.api_java_test.dto.LoginDTO;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

public class EditarUsuarioPatch extends BaseTest {

    ApiClient apiClient = new ApiClient();

    @Test(dataProvider = "dadosParaEdicaoComSucessoUsuario", dataProviderClass = EditarProvider.class)
    public void EditarDadosDeUsuarioComSucesso(EditarDTO patch, LoginDTO login) {
        ValidatableResponse responseLogin = apiClient.postLogin(login)
                .statusCode(200);
        String token = responseLogin.extract().path("token");
        apiClient.putUser(patch, token)
                .statusCode(201);
    }
}
