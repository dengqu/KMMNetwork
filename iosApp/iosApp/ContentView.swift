import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()

    init() {
        let body = "# HELP http_requests_total The total number of HTTP requests.\n" +
                   "# TYPE http_requests_total counter\n" +
                   "http_requests_total{method=\"post\",code=\"200\"} 1027\n" +
                   "http_requests_total{method=\"post\",code=\"400\"} 3\n"
        KtorService().sendRequest(bdy: body)
    }
	var body: some View {
		Text(greet)
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
	ContentView()
	}
}
