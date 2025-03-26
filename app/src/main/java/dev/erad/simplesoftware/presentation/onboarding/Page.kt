package dev.erad.simplesoftware.presentation.onboarding

import androidx.annotation.DrawableRes
import dev.erad.simplesoftware.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        title = "Welcome to simplenews",
        description = "simplenews is a simple news app.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Stay Updated",
        description = "Get the latest news on!",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Save Your News",
        description = "Save your favorite news.",
        image = R.drawable.onboarding3
    )
)
