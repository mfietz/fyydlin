
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

    @Test
    fun searchForPodcastsWrintAndFreakshow() {
        client.searchPodcasts("wrint", "freakshow").subscribe(testSubscriber)
        testSubscriber.assertNoErrors()
    }

    @Test
    fun searchForPodcastsWrintAndFreakshowWithLimit() {
        client.searchPodcasts("wrint", "freakshow", limit = 5).subscribe(testSubscriber)
        testSubscriber.assertNoErrors()
    }

    @Test
    fun searchForPodcastsWrintAndFreakshowWithLimitAndLanguage() {
        client.searchPodcasts("wrint", "freakshow", limit = 5, language = "de").subscribe(testSubscriber)
        testSubscriber.assertNoErrors()
    }

}