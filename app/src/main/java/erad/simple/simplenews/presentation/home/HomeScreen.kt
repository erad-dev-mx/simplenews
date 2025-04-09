package erad.simple.simplenews.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.LazyPagingItems
import erad.simple.simplenews.R
import erad.simple.simplenews.domain.model.Article
import erad.simple.simplenews.presentation.common.ArticlesList
import erad.simple.simplenews.presentation.common.SearchBar
import erad.simple.simplenews.presentation.navgraph.Route
import erad.simple.simplenews.ui.theme.Dimens.MediumPadding1

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier, articles: LazyPagingItems<Article>, navigate: (String) -> Unit
) {
    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items.slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_splash),
            contentDescription = null,
            modifier = modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding1)
        )

        Spacer(modifier = modifier.height(MediumPadding1))

        SearchBar(
            modifier = modifier.padding(horizontal = 16.dp),
            text = "",
            readOnly = true,
            onValueChange = {},
            onClick = {
                navigate(Route.SearchScreen.route)
            },
            onSearch = {}
        )

        Spacer(modifier = modifier.height(MediumPadding1))

        Text(
            text = titles,
            modifier = modifier
                .fillMaxWidth()
                .padding(start = MediumPadding1)
                .basicMarquee(),
            fontSize = 12.sp,
            color = colorResource(id = R.color.purple_200)
        )

        Spacer(modifier = modifier.height(MediumPadding1))

        ArticlesList(
            articles = articles, onClick = {
                navigate(Route.DetailsScreen.route)
            })
    }
}