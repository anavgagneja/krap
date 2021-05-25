package modules

import DataMuseClient
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.features.json.JsonFeature
import io.ktor.http.ContentType
import org.koin.dsl.module

val rhymeModule = module {
    single {
        HttpClient(CIO) {
            install(JsonFeature) {
                accept(ContentType.Application.Json)
            }
        }
    }
    single {
        DataMuseClient(get())
    }
}