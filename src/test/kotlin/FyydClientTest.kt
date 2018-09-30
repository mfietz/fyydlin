
import com.github.tomakehurst.wiremock.junit.WireMockRule
import de.mfietz.fyydlin.FyydClient
import org.junit.Rule
import org.junit.Test

class FyydClientTest {

    @Rule @JvmField
    val wireMockRule = WireMockRule(8081)

    val client = FyydClient(baseUrl = "http://localhost:8081")

    @Test
    fun searchForPodcastWrint() {
        val observer = client.searchPodcasts("wrint").test()
        observer.assertNoErrors()
    }

    @Test
    fun searchForPodcastWrintWithLimit() {
        val observer = client.searchPodcasts("wrint", limit = 5).test()
        observer.assertNoErrors()
    }

}