package com.example.kmmnetwork.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kmmnetwork.Greeting
import android.widget.TextView
import tv.athena.kmmnetwork.api.CollectorRegistry
import tv.athena.kmmnetwork.api.Metric
import tv.athena.kmmnetwork.KtorService
import tv.athena.kmmnetwork.api.Label

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tv: TextView = findViewById(R.id.text_view)
        tv.text = greet()

        val collectorRegistry = CollectorRegistry("Spring_Collect")
        val map = hashMapOf<String, String>()
        map["ver"] = "1.0"
        val label = Label.LabelBuilder().extends(map).value(10.0).builder()
        val metric = Metric.MetricBuilder().name("CpuUsage")
            .help("Android Performance Monitors")
            .type("gauge")
            .addLabel(label)
            .builder()
        collectorRegistry.addMetrics(metric)
        tv.setOnClickListener {
            KtorService().sendRequest(collectorRegistry)
        }
    }
}

