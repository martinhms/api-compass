package application.usecases

import application.adapter.controller.dto.TextRequest
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Component
class WordCounterUseCase {
    private val logger = LoggerFactory.getLogger(WordCounterUseCase::class.java)

    fun execute(text: TextRequest): Map<String, Int> {
        logger.info("WordCounterUseCase: text = $text")

        return text.text.lowercase(Locale.getDefault())
            .split("\\s+".toRegex())
            .filter { it.isNotBlank() }
            .groupingBy { it }
            .eachCount()
    }
}