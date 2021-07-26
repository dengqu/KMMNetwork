package tv.athena.kmmnetwork.api

/**
 * Time:2021/7/22 5:52 下午
 * Author:dengqu
 * Description:
 */
class Label private constructor() {
    private var value: Double = 0.0

    private var extends: Map<String, String>? = null

    override fun toString(): String {
        val stringBuilder = StringBuilder()
        extends?.let {
            if (it.isNotEmpty()) {
                stringBuilder.append("{")
                for ((k, v) in it) {
                    stringBuilder.append(k)
                    stringBuilder.append("=\"")
                    stringBuilder.append(v)
                    stringBuilder.append("\",")
                }
                stringBuilder.append("}")
            }
        }
        stringBuilder.append(" ")
        stringBuilder.append(value.toString())
        stringBuilder.append("\n")

        return stringBuilder.toString()
    }

    class LabelBuilder{
        private val mLabel = Label()
        fun value(value: Double): LabelBuilder {
            mLabel.value = value
            return this
        }

        fun extends(extends: Map<String, String>): LabelBuilder {
            mLabel.extends = extends
            return this
        }

        fun builder(): Label {
            return mLabel
        }
    }
}