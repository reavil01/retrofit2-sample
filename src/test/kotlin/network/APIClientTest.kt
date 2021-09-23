package network

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class APIClientTest {
    @Test
    fun buildTest() {
        val api = APIClient("", "https://pokeapi.co/api/v2/").instance
        val apiClient = api.create(APIInterface::class.java)

        val call = apiClient.doGetPoketmonList(1, 1)
        val body = call.execute().body()

        assertThat(body!!).isNotNull
        assertThat(body.count).isEqualTo(1118)
        assertThat(body.previous).isEqualTo("https://pokeapi.co/api/v2/pokemon?offset=0&limit=1")
        assertThat(body.next).isEqualTo("https://pokeapi.co/api/v2/pokemon?offset=2&limit=1")
        assertThat(body.results.size).isEqualTo(1)
        body.results.forEach { println(it) }
    }

}