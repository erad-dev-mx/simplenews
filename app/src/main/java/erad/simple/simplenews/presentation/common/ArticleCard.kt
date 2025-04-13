package erad.simple.simplenews.presentation.common

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage
import coil.request.ImageRequest
import erad.simple.simplenews.domain.model.Article
import erad.simple.simplenews.domain.model.Source
import erad.simple.simplenews.ui.theme.Dimens.ArticleCardSize
import erad.simple.simplenews.ui.theme.Dimens.ExtraSmallPadding
import erad.simple.simplenews.ui.theme.SimplenewsTheme

@Composable
fun ArticleCard(
    modifier: Modifier = Modifier,
    article: Article,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Row(
        modifier = modifier.clickable { onClick() }) {
        AsyncImage(
            modifier = modifier
                .size(ArticleCardSize)
                .clip(MaterialTheme.shapes.medium),
            model = ImageRequest.Builder(context).data(article.urlToImage).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        Column(
            verticalArrangement = Arrangement.SpaceAround,
            modifier = modifier
                .padding(horizontal = ExtraSmallPadding)
                .height(ArticleCardSize)
        ) {
            Text(
                text = article.title,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "by ${article.source.name}",
                    style = MaterialTheme.typography.labelMedium,
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ArticleCardPreview() {
    SimplenewsTheme {
        ArticleCard(
            article = Article(
                source = Source(id = "", name = "MARVEL"),
                author = "John Doe",
                title = "Sample Title for Article in Simplenews and it is a long title",
                description = "Sample Description",
                url = "https://example.com",
                urlToImage = "https://example.com/image.jpg",
                publishedAt = "2023-10-01T00:00:00Z",
                content = "Sample Content"
            ),
            onClick = {}
        )
    }
}