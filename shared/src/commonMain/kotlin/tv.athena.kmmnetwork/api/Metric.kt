package tv.athena.kmmnetwork.api

/**
 * Time:2021/7/22 5:46 下午
 * Author:dengqu
 * Description:定义指标类
 */
class Metric private constructor() {
    /**
     * 指标名字
     */
    private var name: String = ""

    /**
     * 指标介绍
     */
    private var help: String = ""

    /**
     * 类型
     */
    private var type: String = ""

    /**
     * 指标扩展字段
     */
    private var lables: MutableList<Label> = mutableListOf()

    /**
     * prometheus 上报需要安装他指定的格式进行上报
     * see https://prometheus.io/docs/instrumenting/exposition_formats/
     */
    override fun toString(): String {
        val stringBuilder = StringBuilder()
        stringBuilder.append("# HELP ")
        stringBuilder.append(name)
        stringBuilder.append(' ')
        stringBuilder.append(help)
        stringBuilder.append("\n")

        stringBuilder.append("# TYPE ")
        stringBuilder.append(name)
        stringBuilder.append(' ')
        stringBuilder.append(type)
        stringBuilder.append("\n")

        for (label in lables) {
            stringBuilder.append(name)
            stringBuilder.append(label.toString())
            stringBuilder.append("\n")
        }

        return stringBuilder.toString()
    }

    class MetricBuilder {
        private val mMetric = Metric()
        fun name(name: String): MetricBuilder {
            mMetric.name = name
            return this
        }

        fun help(help: String): MetricBuilder {
            mMetric.help = help
            return this;
        }

        fun type(type: String): MetricBuilder {
            mMetric.type = type
            return this
        }

        fun addLabel(label: Label): MetricBuilder {
            mMetric.lables.add(label)
            return this
        }

        fun builder(): Metric {
            return mMetric
        }
    }
}