package com.prasanna.learnstateincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prasanna.learnstateincompose.ui.theme.LearnStateInComposeTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			LearnStateInComposeTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
					StatelessCompsables()
					StatefulComposables()
				}
			}
		}
	}
}

@Composable
fun StatelessCompsables() {
	var count = 0
	Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Top) {
		Text(text = "$count times recomposed :( ")
		Button(onClick = { count++ }) {
			Text(text = "Tap me!, I am a Stateless Composable")
		}
	}
}

@Composable
fun StatefulComposables() {
	val count = remember {
		mutableStateOf(0)
	}
	Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
		Text(text = "${count.value} times recomposed :) ")
		Button(onClick = { count.value++ }) {
			Text(text = "Tap me!, I am a Stateful Composable" )
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	LearnStateInComposeTheme {
		StatelessCompsables()
		StatefulComposables()
	}
}