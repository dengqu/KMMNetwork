package tv.athena.kmmnetwork.api

/**
 * Time:2021/7/22 6:31 下午
 * Author:dengqu
 * Description:
 */
class CollectorRegistry(val jobName: String) {
    private var metrics: MutableList<Metric> = mutableListOf()

    fun addMetrics(metric: Metric) {
        metrics.add(metric)
    }

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        for (metric in metrics) {
            stringBuilder.append(metric.toString())
        }

        return stringBuilder.toString()
    }
}