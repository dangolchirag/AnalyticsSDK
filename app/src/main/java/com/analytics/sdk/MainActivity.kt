package com.analytics.sdk

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.analytics.sdk.ui.theme.AnalyticsSDKTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnalyticsSDKTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Text("Insert Session", modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                // AnalyticsSDK.startSession()
                            })
                        Text("End Session", modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                // AnalyticsSDK.stopSession()
                            })
                        Text("Get Session", modifier = Modifier
                            .padding(16.dp)
                            .clickable {

                            })
                        Text("Insert Event", modifier = Modifier
                            .padding(16.dp)
                            .clickable {
                                // AnalyticsSDK.trackEvent("Test Event", mapOf("a" to "b"))
                            })
                        Text("Get Events", modifier = Modifier
                            .padding(16.dp)
                            .clickable {

                            })
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AnalyticsSDKTheme {
        Greeting("Android")
    }
}