package com.shankarlohar.amphibians.ui.view.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.shankarlohar.amphibians.model.AmphibianInfo
import com.shankarlohar.amphibians.ui.ErrorScreen
import com.shankarlohar.amphibians.ui.LoadingScreen
import com.shankarlohar.amphibians.ui.view.AmphibiansUiState

@Composable
fun HomeScreen(
    amphibiansUiState: AmphibiansUiState,
    modifier: Modifier = Modifier
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier)
        is AmphibiansUiState.Success -> AmphibiansCardList(amphibiansUiState.AmphibiansInfo, modifier)
        is AmphibiansUiState.Error -> ErrorScreen(modifier)
    }
}

@Composable
fun AmphibiansCardList(amphibiansInfo: List<AmphibianInfo>, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(4.dp)
    ) {
        items(amphibiansInfo) { amphibianInfo ->
            AmphibianCard(amphibianInfo = amphibianInfo)
        }
    }
}

@Composable
fun AmphibianCard(amphibianInfo: AmphibianInfo) {
//    name,type,description,image

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        elevation = 8.dp
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = amphibianInfo.name,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(amphibianInfo.imgSrc)
                    .crossfade(true)
                    .build(),
                contentDescription = amphibianInfo.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
            Text(
                text = amphibianInfo.type,
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
            )
            Text(
                text = amphibianInfo.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }
    }
}
