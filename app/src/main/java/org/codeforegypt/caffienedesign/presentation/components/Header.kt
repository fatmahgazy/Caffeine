package org.codeforegypt.caffienedesign.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.presentation.ui.theme.GrayCaffeine

@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_ghost),
            contentDescription = null,
            modifier = Modifier.size(48.dp)
        )
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(
                    color = GrayCaffeine,
                    shape = CircleShape
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.add),
                contentDescription = null,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview
@Composable
fun ProfileHeaderPreview() {
    Header()
}