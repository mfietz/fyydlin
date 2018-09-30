
import com.github.tomakehurst.wiremock.junit.WireMockRule
import de.mfietz.fyydlin.FyydClient
import de.mfietz.fyydlin.FyydResponse
import org.junit.Rule
import org.junit.Test
import rx.observers.TestSubscriber

class FyydClientTest {

    @Rule @JvmField
    val wireMockRule = WireMockRule(8081)

    val client = FyydClient(baseUrl = "http://localhost:8081")
    val testSubscriber = TestSubscriber<FyydResponse>()

    @Test
    fun searchForPodcastWrint() {
        client.searchPodcasts("wrint").subscribe(testSubscriber)
        testSubscriber.assertNoErrors()
    }

    @Test
    fun searchForPodcastWrintWithLimit() {
        client.searchPodcasts("wrint", limit = 5).subscribe(testSubscriber)
        testSubscriber.assertNoErrors()
    }

}