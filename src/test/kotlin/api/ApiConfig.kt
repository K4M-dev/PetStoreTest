package api

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import io.restassured.RestAssured
import io.restassured.config.ObjectMapperConfig
import io.restassured.config.RestAssuredConfig
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter

object ApiConfig {

    fun setup() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2"
        RestAssured.filters(
            RequestLoggingFilter(),
            ResponseLoggingFilter()
        )

        val objectMapper: ObjectMapper = jacksonObjectMapper()
            .registerModule(KotlinModule.Builder().build())
        
        RestAssured.config = RestAssuredConfig.config()
            .objectMapperConfig(
                ObjectMapperConfig.objectMapperConfig()
                    .jackson2ObjectMapperFactory { _, _ -> objectMapper }
            )
    }

}