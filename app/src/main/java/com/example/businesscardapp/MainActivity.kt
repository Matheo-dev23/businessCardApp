package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Column(
        verticalArrangement = Arrangement.Center
        ,horizontalAlignment = Alignment.CenterHorizontally
        ,modifier = Modifier
            .fillMaxSize()
    ) {
        Spacer(Modifier.height(180.dp))
        LogoNameAndTitleSection(
            painterResource(R.drawable.picture_logo)
            , stringResource(R.string.full_name_text)
            , stringResource(R.string.title_text)
            , modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.height(150.dp))
        ContactSection(
            stringResource(R.string.phoneNumber_text)
            , stringResource(R.string.github_text)
            , stringResource(R.string.email_text)
            , modifier = Modifier.weight(1f)
        )
    }

}

@Composable
private fun LogoNameAndTitleSection(painter: Painter, name: String, title: String, modifier: Modifier){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .background(Color.Transparent)
        )
        Text(
            text = name,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 16.dp)
        )
        Text(
            text = title,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            color = Color.DarkGray,
            modifier = Modifier
                .padding(top = 10.dp)
        )
    }
}

@Composable
private fun ContactSection(phoneNumber: String, github: String,email: String, modifier: Modifier){
    Column {
        ContactCardComp(Icons.Default.Call, phoneNumber)
        ContactCardComp(Icons.Default.Share, github)
        ContactCardComp(Icons.Default.Email, email)
    }
}

@Composable
private fun ContactCardComp(imageVector: ImageVector, text: String){
    Row(Modifier.padding(top = 10.dp)) {
        Icon(
            imageVector = imageVector
            , contentDescription = null
            , tint = Color(0xFF40a85a)
        )
        Text(
            text = text,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(start = 30.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}