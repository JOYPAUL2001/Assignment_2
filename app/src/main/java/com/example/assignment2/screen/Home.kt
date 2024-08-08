package com.example.assignment2.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Card
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.assignment2.R
import com.example.assignment2.components.IconComponentDrawable
import com.example.assignment2.components.SpacerHeight
import com.example.assignment2.components.SpacerWidth
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun home(
    modifier: Modifier
) {
    StatusBarColor()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.main))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Header()
            SpacerHeight(24.dp)
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(
                            topStart = 30.dp,
                            topEnd = 30.dp
                        )
                    )
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier
                ) {
                    Cards(modifier = Modifier)
                    items()
                }

            }
        }

    }
}

@Composable
fun Header() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 56.dp, start = 24.dp, end = 10.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        IconComponentDrawable(icon = R.drawable.user, size = 50.dp)
        SpacerWidth(5.dp)
        Text(
            text = "Hi, Push Puttichai", fontSize = 16.sp, color = Color.White, modifier = Modifier
                .padding(start = 18.dp)
                .align(Alignment.CenterVertically)
        )
        SpacerWidth(107.dp)
        IconComponentDrawable(
            icon = R.drawable.notify,
            size = 26.dp,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Composable
fun Cards(
    modifier: Modifier = Modifier.padding(top = 14.dp, start = 24.dp, end = 24.dp)
) {
    Image(
        painter = painterResource(id = R.drawable.card),
        contentDescription = "card",
        contentScale = ContentScale.FillWidth,
    )
}

@Composable
fun items(
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(15.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
            .padding(top = 8.dp)
    ) {
        items(9) { index ->
            when (index) {
                0 -> FeatureButton(
                    "Account and Card",
                    R.drawable.wallet
                ) { /* Handle click */ }

                1 -> FeatureButton(
                    "Transfer",
                    R.drawable.syncdevice
                ) { /* Handle click */ }

                2 -> FeatureButton(
                    "Withdraw",
                    R.drawable.creditcard
                ) { /* Handle click */ }

                3 -> FeatureButton("Mobile prepaid", R.drawable.mobile) { /* Handle click */ }
                4 -> FeatureButton(
                    "Pay the bill",
                    R.drawable.receipt
                ) { /* Handle click */ }

                5 -> FeatureButton(
                    "Save online",
                    R.drawable.pig
                ) { /* Handle click */ }

                6 -> FeatureButton("Credit card", R.drawable.credit) { /* Handle click */ }
                7 -> FeatureButton(
                    "Transaction report",
                    R.drawable.file
                ) { /* Handle click */ }

                8 -> FeatureButton(
                    "Beneficiary",
                    R.drawable.contacts
                ) { /* Handle click */ }
            }
        }
    }
}

@Composable
fun FeatureButton(text: String, icon: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
    ) {
        Column(
            modifier = Modifier.padding(top = 10.dp, end = 20.dp, start = 20.dp, bottom = 10.dp )
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,


        ) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = text,
                modifier = Modifier.size(28.dp),
                alignment = Alignment.Center
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(text = text, fontSize = 12.sp, color = Color.Gray, textAlign = TextAlign.Center, lineHeight = 16.sp)
        }
    }
}


@Composable
private fun StatusBarColor() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colorScheme.primary.luminance() > 0.5f
    val statusBarColor = colorResource(id = R.color.main)
    SideEffect {
        systemUiController.setStatusBarColor(
            color = statusBarColor,
            darkIcons = useDarkIcons
        )
    }
}
