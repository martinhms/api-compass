package application.usecases

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class Every10thCharacterUseCase {
    private val logger = LoggerFactory.getLogger(Every10thCharacterUseCase::class.java)

    fun execute(text: String): List<Char> {
        logger.info("Every10thCharacterUseCase: test = $text")
        return text.filterIndexed { index, _ -> (index + 1) % 10 == 0 }.toList()
    }
}