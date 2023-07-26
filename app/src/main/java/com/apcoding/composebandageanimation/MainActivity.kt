package com.apcoding.composebandageanimation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.apcoding.composebandageanimation.bandage.BandageReveal
import com.apcoding.composebandageanimation.ui.Card
import com.apcoding.composebandageanimation.ui.CardBehindContent
import com.apcoding.composebandageanimation.ui.ImageCard
import com.apcoding.composebandageanimation.ui.theme.ComposeBandageAnimationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBandageAnimationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    Column(Modifier.padding(16.dp), verticalArrangement = spacedBy(8.dp)) {

                        BandageReveal(behindContent = {
                            CardBehindContent(it)
                        }, content = {
                            Card("JETPACK COMPOSE", R.drawable.icon1, 3.dp)
                        })


                        BandageReveal(behindContent = {
                            CardBehindContent(it)
                        }, content = {
                            Card("Ankit Parida", R.drawable.puzzle, 3.dp)
                        })


                        BandageReveal(behindContent = {
                            CardBehindContent(it)
                        }, content = {
                            ImageCard(4.dp)
                        })

                    }
                }

            }
        }
    }
}




