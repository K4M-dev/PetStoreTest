package tests

import api.ApiConfig
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.BeforeAll

abstract class BaseTest {

    companion object {
        @JvmStatic
        @BeforeAll
        @Epic("Pet API")
        @Feature("CRUD operations")
        @Story("Pet lifecycle")
        fun beforeAll() {
            ApiConfig.setup()
        }
    }
}