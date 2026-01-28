package tests

import api.ApiConfig
import org.junit.jupiter.api.BeforeAll

abstract class BaseTest {

    companion object {
        @JvmStatic
        @BeforeAll
        fun beforeAll() {
            ApiConfig.setup()
        }
    }
}