package application.usecases

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Every10thCharacterUseCaseTest {

    private val every10thCharacterUseCase = Every10thCharacterUseCase()

    @Test
    fun `should extract every 10th character from a string`() {
        val text = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val expected = listOf('9', 'J', 'T')
        val result = every10thCharacterUseCase.execute(text)
        assertEquals(expected, result)
    }

    @Test
    fun `should return an empty list for an empty string`() {
        val text = ""
        val expected = emptyList<Char>()
        val result = every10thCharacterUseCase.execute(text)
        assertEquals(expected, result)
    }
}