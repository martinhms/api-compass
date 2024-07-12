package application.usecases

import application.adapter.controller.dto.TextRequest
import org.springframework.stereotype.Component
import java.util.*

@Component
class WordCounterUseCase {

    fun execute(text: TextRequest): Map<String, Int> {
        return text.text.lowercase(Locale.getDefault())
            .split("\\s+".toRegex())
            .filter { it.isNotBlank() }
            .groupingBy { it }
            .eachCount()
    }
}