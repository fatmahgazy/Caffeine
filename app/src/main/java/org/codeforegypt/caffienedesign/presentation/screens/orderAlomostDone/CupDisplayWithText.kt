package org.codeforegypt.caffienedesign.presentation.screens.orderAlomostDone

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.codeforegypt.caffienedesign.R
import org.codeforegypt.caffienedesign.presentation.components.CoffeeTitleText
import org.codeforegypt.caffienedesign.presentation.components.TwoSmallGrayDots
import org.codeforegypt.caffienedesign.presentation.components.WaveProgressAnimation
import org.codeforegypt.caffienedesign.ui.theme.DescriptionCaffeine
import org.codeforegypt.caffienedesign.ui.theme.MyTransparentColor
import org.codeforegypt.caffienedesign.ui.theme.TextSizeOfCup
import org.codeforegypt.caffienedesign.ui.theme.Urbanist

@Composable
fun CupDisplayWithText(
    volume: String,
    cupImageRes: Int,
    progress: Float,
    modifier: Modifier = Modifier
    ) {

    Column(
        modifier = modifier.fillMaxSize()
            .padding(start = 16.dp, top = 145.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "$volume ML",
                fontSize = 17.sp,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                color = TextSizeOfCup,
                modifier = Modifier.padding(top = 30.dp)
            )
            Spacer(modifier = Modifier.width(20.dp))
            Box(
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = cupImageRes),
                    contentDescription = "",
                    modifier = Modifier.padding(vertical = 12.dp)
                        .width(246.dp)
                        .height(300.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.the_chance_coffe),
                    contentDescription = "",
                    modifier = Modifier.size(66.dp)
                )
            }

        }
    }
    Column(
        modifier = modifier.fillMaxSize()
            .padding(top = 570.dp),
    ) {
        WaveProgressAnimation(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            progress = progress
        )
        Spacer(modifier = Modifier.height(25.dp))
        Text(
            text = "Almost Done",
            fontSize = 22.sp,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            color = DescriptionCaffeine,
            modifier = Modifier.padding(start = 120.dp, end = 120.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Your coffee will be finish in",
            fontSize = 16.sp,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            color = MyTransparentColor,
            modifier = Modifier.padding(start = 79.dp, end = 79.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 86.5.dp),
            horizontalArrangement = Arrangement.spacedBy(14.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            CoffeeTitleText("CO")
            TwoSmallGrayDots()
            CoffeeTitleText("FF")
            TwoSmallGrayDots()
            CoffeeTitleText("EE")
        }

    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextWithCupPreview(){
    CupDisplayWithText(
        volume = "400 ML",
        cupImageRes = R.drawable.blackcup1,
        progress = 0.5f
    )
}