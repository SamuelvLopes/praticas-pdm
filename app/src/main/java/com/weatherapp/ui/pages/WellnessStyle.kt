package com.weatherapp.ui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

internal val HeroGradient = listOf(Color(0xFF0CB8FF), Color(0xFF32D586))
internal val PurpleGradient = listOf(Color(0xFF8A46FF), Color(0xFFE251C7))
internal val BlueGradient = listOf(Color(0xFF45A1FF), Color(0xFF58DDE8))
internal val TealGradient = listOf(Color(0xFF07BEB8), Color(0xFF48D17B))
internal val OrangeGradient = listOf(Color(0xFFFF8A3D), Color(0xFFFFC14F))
internal val YellowGradient = listOf(Color(0xFFFFC14F), Color(0xFFFF8A3D))
internal val LavenderGradient = listOf(Color(0xFF8E9EFB), Color(0xFF69C7FF))

@Composable
internal fun GradientContainer(
    colors: List<Color>,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(32.dp))
            .background(Brush.linearGradient(colors))
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = content
    )
}
