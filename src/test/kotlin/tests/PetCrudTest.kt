package tests

import api.PetApi
import io.qameta.allure.Epic
import io.qameta.allure.Feature
import io.qameta.allure.Story
import model.Pet
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.UUID
import kotlin.jvm.java

@Epic("Pet Api")
@Feature("CRUD operations")
class PetCrudTest : BaseTest() {

    private val petApi = PetApi()

    @Test
    @DisplayName("Full pet CRUD lifecycle")
    @Story("Pet lifecycle")
    fun petCRUDLifecycle() {

        val petId = UUID.randomUUID().mostSignificantBits and Long.MAX_VALUE
        val initPet = Pet(
            id = petId,
            name = "Argus",
            status = "available",
        )

        //CREATE
        val createResponse = petApi.createPet(initPet)

        assertEquals(200, createResponse.statusCode)

        //GET
        val getResponse = petApi.getPet(petId)
        val createdPet = getResponse.`as`(Pet::class.java)

        assertEquals(200, getResponse.statusCode)
        assertEquals(initPet.id, createdPet.id)
        assertEquals(initPet.name, createdPet.name)
        assertEquals(initPet.status, createdPet.status)

        //UPDATE
        val updatedPet = initPet.copy(
            name = "Barsik",
            status = "sold",
        )

        val updateResponse = petApi.updatePet(updatedPet)

        assertEquals(200, updateResponse.statusCode)

        val updatedFromApi = petApi.getPet(petId).`as`(Pet::class.java)
        assertEquals(updatedPet.name, updatedFromApi.name)
        assertEquals(updatedPet.status, updatedFromApi.status)

        //DELETE
        val deleteResponse = petApi.deletePet(petId)

        assertEquals(200, deleteResponse.statusCode)
    }
}