package sample

import kotlin.test.Test
import kotlin.test.assertTrue

class SampleTests {

    @Test
    fun testProxy() {
        assertTrue(Proxy().proxyHello().isNotEmpty())
    }
}
