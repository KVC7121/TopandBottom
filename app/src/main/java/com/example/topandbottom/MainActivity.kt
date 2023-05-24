package com.example.topandbottom

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.consumedWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.topandbottom.ui.theme.TopandBottomTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // This is an update
            // Yo how r u master?
            CustomScaffold()
        }
    }
}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun MainContent(padding: PaddingValues) {

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .padding(padding)
                .consumedWindowInsets(padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.google),
                contentDescription =
                "instagram logo",
                modifier = Modifier.size(width = 220.dp, height = 100.dp)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                "Welcome to Google",
                color = Color.Blue,
                fontFamily =
                FontFamily.SansSerif,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(40.dp))

            Spacer(modifier = Modifier.height(40.dp))


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold() {
    Scaffold(
        topBar = { CustomTopBar() },
        content = { h -> MainContent(h) },
        bottomBar = { CustomBottomBar() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopBar() {
    TopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically, horizontalArrangement =
                Arrangement.SpaceBetween, modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        end = 20
                            .dp
                    )
            ) {
                Icon(
                    Icons.Filled.AccountBox, contentDescription = "", modifier = Modifier
                        .size(30.dp)
                )
                Image(
                    painterResource(id = android.R.drawable.star_big_on),
                    contentDescription = "",
                    modifier = Modifier.size(30.dp)
                )


            }
        },
        modifier = Modifier.drawBehind {
            drawLine(
                Color.Black,
                Offset(0f, size.height),
                Offset(size.width, size.height),
                5f
            )

        }

    )
}

@Composable
fun CustomBottomBar() {
    remember { mutableStateOf(0) }
    BottomAppBar(
        modifier = Modifier.drawBehind {
            drawLine(
                Color.LightGray,
                Offset(0f, 0f),
                Offset(size.width, 0f),
                4f
            )
        },
        containerColor = Color.White,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment =
            Alignment.CenterVertically
        ) {
            Icon(imageVector = Icons.Default.Home, "", modifier = Modifier.size(30.dp))
            Icon(imageVector = Icons.Default.Add, "", modifier = Modifier.size(30.dp))
            Icon(imageVector = Icons.Default.Person, "", modifier = Modifier.size(30.dp))
        }
    }

}
