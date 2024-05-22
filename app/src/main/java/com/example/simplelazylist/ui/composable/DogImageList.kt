import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.simplelazylist.R
import com.example.simplelazylist.ui.navigation.Screen
import com.example.simplelazylist.ui.viewmodel.SimpleListViewModel

@Composable
fun DogImageList(navController: NavController, viewModel: SimpleListViewModel = hiltViewModel()) {
    val dogImageModel by viewModel.dogImageList.collectAsState()

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        dogImageModel.listOfDogs?.let { messages ->
            items(messages) { imageUrl ->
                imageUrl?.let {
                    ItemCard(it) {
                        navController.navigate(Screen.RandomDogImageScreen.route)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ItemCard(imageUrl: String, function: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = function),
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            GlideImage(
                model = imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            ) {
                it
                    .load(imageUrl)
                    .placeholder(R.drawable.ic_launcher_foreground)

            }
        }
    }
}