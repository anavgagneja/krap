import io.ktor.client.HttpClient
import io.ktor.client.request.get
import models.Rhyme

private const val API_ENDPOINT = "https://api.datamuse.com"
private const val RHYME_ENDPOINT = "$API_ENDPOINT/words?rel_rhy="

class DataMuseClient(private val httpClient: HttpClient) {

    suspend fun fetchRhyme(word: String): List<Rhyme> {
        return httpClient.get("$RHYME_ENDPOINT$word")
    }

    suspend fun fetchRhyme(word: String, limit: Int) : List<Rhyme> {
        return fetchRhyme(word).take(limit)
    }
}