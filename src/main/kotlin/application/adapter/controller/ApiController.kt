package application.adapter.controller

import application.adapter.controller.dto.Every10thCharacterRequest
import application.adapter.controller.dto.ExtractResponse
import application.usecases.Every10thCharacterUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api")
class ApiController(
    private val every10thCharacterUseCase: Every10thCharacterUseCase,
) {

    @PostMapping("/every10thCharacter")
    suspend fun every10thCharacter(@RequestBody request: Every10thCharacterRequest): ExtractResponse = withContext(Dispatchers.IO) {
        val result = every10thCharacterUseCase.execute(request.text)
        ExtractResponse(result)
    }
}