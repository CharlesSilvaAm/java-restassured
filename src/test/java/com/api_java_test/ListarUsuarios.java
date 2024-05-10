package com.api_java_test;

import com.api_java_test.baseteste.BaseTest;
import com.api_java_test.clients.ApiClient;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


public class ListarUsuarios extends BaseTest {

    ApiClient apiClient = new ApiClient();

    @Test
    public void ListarUsuarioComSucesso() {
        apiClient.getList()
                .assertThat()
                .statusCode(200)
                .body("data", is(notNullValue()));
    }
}
