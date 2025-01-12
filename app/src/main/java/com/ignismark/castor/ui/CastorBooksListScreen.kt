package com.ignismark.castor.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.ignismark.castor.R
import com.ignismark.castor.data.BookItem

@Composable
fun CastorBooksListScreen(
    castorUiState: CastorUiState,
    castorViewModel: CastorViewModel,
    navController: NavController,
    paddingValues: PaddingValues
) {
    BackHandler {
        navController.popBackStack(route = CastorAppScreen.Calendar.title, inclusive = false)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            LazyColumn(
                modifier = Modifier.weight(1f),
                contentPadding = PaddingValues(
                    start = 16.dp,
                    top = 4.dp,
                    end = 16.dp,
                    bottom = 4.dp
                )
            ) {
                items(castorUiState.fitnessBooks
                ) { bookItem ->
                    BookCard(
                        book = bookItem,
                        castorViewModel = castorViewModel
                    )
                }
            }
        }
    }
}

@Composable
fun BookCard(
    book: BookItem,
    castorViewModel: CastorViewModel
) {
    Card(border = BorderStroke(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = book.volumeInfo.title,
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 8.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        )
                )
                Text(
                    text = book.volumeInfo.authors.toString(),
                    textAlign = TextAlign.Left,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 8.dp,
                            top = 16.dp,
                            bottom = 16.dp
                        )
                )
            }
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(castorViewModel.prepareImageURL(bookItem = book))
                    .crossfade(true)
                    .build(),
                error = painterResource(id = R.drawable.ic_broken_image),
                placeholder = painterResource(id = R.drawable.loading_img),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth().weight(1f)
            )
        }
    }
}