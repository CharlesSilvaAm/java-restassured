package com.api_java_test;

import org.testng.annotations.BeforeClass;
import static io.restassured.RestAssured.*;

public abstract class BaseTest {
    @BeforeClass
    public void setup() {
        baseURI = "https://reqres.in/api/";
    }
}
