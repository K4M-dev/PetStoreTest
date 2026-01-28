package api

import io.restassured.RestAssured

object ApiConfig {

    fun setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2"
    }
}