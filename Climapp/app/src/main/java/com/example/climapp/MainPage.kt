package com.example.climapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.climapp.ui.theme.ClimappTheme

@Composable

fun MainPage(modifier: Modifier = Modifier){

}

@Preview(showBackground = true)
@Composable
fun MainPagePreview(){
    ClimappTheme {
        MainPage()
    }
}
