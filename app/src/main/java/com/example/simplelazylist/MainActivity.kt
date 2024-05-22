package com.example.simplelazylist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.simplelazylist.ui.navigation.Navigation
import com.example.simplelazylist.ui.theme.SimpleLazyListTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleLazyListTheme {
                Navigation()
            }
        }
    }
}




@Composable
fun DogFact() {
    Text(text = "Hello world")
}

//@Preview(showBackground = true, widthDp = 320, heightDp = 480)
//@Composable
//fun PreviewItemCard() {
//    ItemCard(imageUrl = "https:\\/\\/images.dog.ceo\\/breeds\\/cotondetulear\\/100_2397.jpg\"")
//}


