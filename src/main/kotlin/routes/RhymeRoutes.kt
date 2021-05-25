package routes

import DataMuseClient
import models.RhymeResponse
import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.routing

fun Application.registerRhymeRoutes(dataMuseClient: DataMuseClient) {
    routing {
        rhymeRoutes(dataMuseClient)
    }
}

private fun Route.rhymeRoutes(dataMuseClient: DataMuseClient) {
    get("/rhyme") {
        val word = call.request.queryParameters["word"] ?: error("Invalid rhyme request")
        val resultLimit: Int? = try {
            call.request.queryParameters["limit"]?.toInt()
        } catch (e: NumberFormatException) {
            null
        }
        val rhymes = if (resultLimit == null) dataMuseClient.fetchRhyme(word)
                     else dataMuseClient.fetchRhyme(word, resultLimit)
        call.respond(RhymeResponse(word, rhymes))
    }
}
