package tv.athena.kmmnetwork

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import tv.athena.kmmnetwork.api.ApiConstant
import tv.athena.kmmnetwork.api.CollectorRegistry
import kotlin.native.concurrent.SharedImmutable

/**
 * Time:2021/7/22 2:56 下午
 * Author:dengqu
 * Description:
 */
@SharedImmutable
internal expect val ApplicationDispatcher: CoroutineDispatcher

class KtorService {
    private val client = HttpClient()
    private val address = ApiConstant.HOST
    fun sendRequest(collectorRegistry: CollectorRegistry) {
        println(collectorRegistry.toString())
        GlobalScope.launch(ApplicationDispatcher) {
            client.post(address + "${collectorRegistry.jobName}") {
                body = collectorRegistry.toString()
            }
        }
    }
}