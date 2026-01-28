package api

import io.restassured.RestAssured
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter

object ApiConfig {

    fun setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2"
        RestAssured.filters(
            RequestLoggingFilter(),
            ResponseLoggingFilter()
        )
    }

}