package com.hariankoding.composecookbook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hariankoding.composecookbook.ui.theme.ComposeCookbookTheme

class MainActivity : ComponentActivity() {
    private val viewModel = RecipeListViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCookbookTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Cookbook(viewModel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Cookbook(viewModel: RecipeListViewModel) {
    Column(modifier = Modifier.fillMaxWidth()) {
        TopAppBar(
            title = {
                Text(
                    text = "Compose Cookbook",
                    modifier = Modifier.testTag("topAppBarText")
                )

            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier.testTag("topAppBar")
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Button(
                onClick = { viewModel.addPlaceholderRecipe() },
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("addPlaceholderButton")
            ) {
                Text(text = "Add Placeholder")
            }
            Button(
                onClick = { viewModel.removeLastRecipe() },
                modifier = Modifier
                    .padding(8.dp)
                    .testTag("removeLastButton")
            ) {
                Text(text = "Remove Last")
            }

        }
        Row {
            RecipeList(viewModel)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val viewModel = RecipeListViewModel()
    ComposeCookbookTheme {
        Cookbook(viewModel = viewModel)
    }
}