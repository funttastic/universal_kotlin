import XCTest
import main

class iosAppTests: XCTestCase {
    func testExample() {
        assert(!Proxy().proxyHello().isEmpty)
    }
}
