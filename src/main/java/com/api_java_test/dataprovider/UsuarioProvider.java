package com.api_java_test.dataprovider;

import com.api_java_test.dto.LoginDTO;
import com.api_java_test.dto.UsuarioDTO;
import org.testng.annotations.DataProvider;

public class UsuarioProvider {
    @DataProvider(name = "criarUsuarioComSucesso")
    public static Object[][] criarUsuarioComSucesso() {
        UsuarioDTO user = new UsuarioDTO("morpheus", "leader");
        LoginDTO login = new LoginDTO("eve.holt@reqres.in", "cityslicka");
        return new Object[][]{
                {user, login}
        };
    }
    @DataProvider(name = "criarUsuario")
    public static Object[][] criarUsuario() {
        UsuarioDTO user = new UsuarioDTO("morpheus", "leader");
        return new Object[][]{
                {user}
        };
    }
}
