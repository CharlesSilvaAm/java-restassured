package com.api_java_test.dataprovider;

import com.api_java_test.dto.LoginDTO;
import org.testng.annotations.DataProvider;

public class LoginProvider {
    @DataProvider(name = "loginSucesso")
    public static Object[][] loginSucesso() {
        LoginDTO login = new LoginDTO("eve.holt@reqres.in", "cityslicka");
        return new Object[][]{
                {login}
        };
    }
    @DataProvider(name = "loginEmailInvalido")
    public static Object[][] loginEmailInvalido() {
        LoginDTO login = new LoginDTO("fulano@qa.com", "teste");
        return new Object[][]{
                {login}
        };
    }
}
