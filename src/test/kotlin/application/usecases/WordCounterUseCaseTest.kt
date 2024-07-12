package application.usecases

import application.adapter.controller.dto.TextRequest
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class WordCounterUseCaseTest {

    private val wordCounterUseCase = WordCounterUseCase()

    @Test
    fun `Test WordCounterUseCaseTest, should count words in a text`() {
        val text = TextRequest("Hola mundo Hola mundo Hola mundo!!")
        val expected = mapOf(
            "hola" to 3,
            "mundo" to 2,
            "mundo!!" to 1
        )
        val result = wordCounterUseCase.execute(text)
        assertEquals(expected, result)
    }

    @Test
    fun `Test WordCounterUseCaseTest, should return an empty map for an empty string`() {
        val text = TextRequest("")
        val expected = emptyMap<String, Int>()
        val result = wordCounterUseCase.execute(text)
        assertEquals(expected, result)
    }

    @Test
    fun `Test WordCounterUseCaseTest, should ignore punctuation when counting words`() {
        val text = TextRequest("<p> Compass Hello World </p>")
        val expected = mapOf(
            "<p>" to 1,
            "compass" to 1,
            "hello" to 1,
            "world" to 1,
            "</p>" to 1,
        )
        val result = wordCounterUseCase.execute(text)
        assertEquals(expected, result)
    }
}