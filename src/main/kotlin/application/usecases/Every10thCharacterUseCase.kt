package application.usecases

import org.springframework.stereotype.Component

@Component
class Every10thCharacterUseCase {

    fun execute(text: String): List<Char> {
        return text.filterIndexed { index, _ -> (index + 1) % 10 == 0 }.toList()
    }
}