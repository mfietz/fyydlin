
import com.github.tomakehurst.wiremock.junit.WireMockRule
import de.mfietz.fyydlin.FyydClient
import de.mfietz.fyydlin.FyydResponse
import org.awaitility.Awaitility
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class FyydClientTest {

    @Rule @JvmField
    val wireMockRule = WireMockRule(8081)

    val client = FyydClient(baseUrl = "http://localhost:8081")

    @Test
    fun searchForPodcastWrint() {
        var fyydResponse: FyydResponse? = null
        client.searchPodcasts("wrint")
        .subscribe { resp -> fyydResponse = resp}
        Awaitility.await().until { fyydResponse != null }

        val hit = fyydResponse!!.data[0]
        assertEquals("WRINT: Wer redet ist nicht tot", hit.title)
        assertEquals("https:\\/\\/www.wrint.de\\/feed\\/podcast", hit.xmlUrl)
    }

    @Test
    fun searchForPodcastWrintWithLimit() {
        val observer = client.searchPodcasts("wrint", limit = 5).test()
        observer.assertNoErrors()
    }

}