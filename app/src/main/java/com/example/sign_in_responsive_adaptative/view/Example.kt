package com.example.sign_in_responsive_adaptative.view

import android.icu.text.CaseMap
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sign_in_responsive_adaptative.Greeting
import com.example.sign_in_responsive_adaptative.R
import com.example.sign_in_responsive_adaptative.ui.theme.Purple40
import com.example.sign_in_responsive_adaptative.ui.theme.Sign_in_responsive_adaptativeTheme

@Composable
fun responsiveCard(
    title: String,
    description: String
) {
    var showMore by rememberSaveable { mutableStateOf(false) }


    BoxWithConstraints(
        modifier = Modifier.fillMaxSize()
            .border(
                shape = RectangleShape,
                width = 1.dp,
                color = Purple40
            )
    ) {
        if (maxWidth < 400.dp) {
            Column {
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "star"
                )
                Text(title)
            }
        } else {
            Row {
                Column {
                    Text(title)
                    Text(
                        text = description,
                        /*showMore = showMore,
                        onShowMoreToggled = { newValue ->
                            showMore = newValue
                        }

                         */
                    )
                }
                Image(
                    painter = painterResource(R.drawable.star),
                    contentDescription = "star"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Sign_in_responsive_adaptativeTheme {
        responsiveCard(title = "suka", description = "blyat")
    }
}