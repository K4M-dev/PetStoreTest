package api

import io.restassured.RestAssured.given
import io.restassured.http.ContentType
import io.restassured.response.Response
import model.Pet

class PetApi {

    fun createPet(pet: Pet): Response =
        given()
            .contentType(ContentType.JSON)
            .body(pet)
            .`when`()
            .post("/pet")

    fun getPet(id: Long): Response =
        given()
            .`when`()
            .get("/pet/{id}", id)

    fun updatePet(pet: Pet): Response =
        given()
            .contentType(ContentType.JSON)
            .body(pet)
            .`when`()
            .put("/pet")

    fun deletePet(id: Long): Response =
        given()
            .`when`()
            .delete("/pet/{id}", id)
}