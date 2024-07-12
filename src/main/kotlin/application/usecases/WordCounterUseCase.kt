package application.usecases

import application.adapter.controller.dto.TextRequest
import org.springframework.stereotype.Component

@Component
class WordCounterUseCase {

    fun execute(text: TextRequest): Map<String, Int> {
        return text.text.toLowerCase()
            .split("\\s+".toRegex())
            .groupingBy { it }
            .eachCount()
    }
}