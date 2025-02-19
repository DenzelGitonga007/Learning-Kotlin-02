package com.example.d_eats.ui.theme.screens.Menu

import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.d_eats.R
import com.example.d_eats.data.MenuViewModel
import com.example.d_eats.navigation.ROUTE_ABOUT
import com.example.d_eats.navigation.ROUTE_HOME
import com.example.d_eats.navigation.VIEW_MENU
import com.example.d_eats.ui.theme.LightCyan

import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMenuScreen(navController: NavHostController) {
    val context = LocalContext.current


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
            .verticalScroll(rememberScrollState())
    ) {
        Column (
            modifier = Modifier.padding(horizontal = 12.dp)
        ){

            var menuName by remember { mutableStateOf("") }
            var menuDescription by remember { mutableStateOf("") }
            var quantity by remember { mutableStateOf("") }
            var price by remember { mutableStateOf("") }

            Spacer(modifier = Modifier.height(30.dp))


            //intro row
            Row (
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ){
                //card holding icon
                Card (
                    modifier = Modifier
                        .size(70.dp),
                    shape = RoundedCornerShape(50),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Gray
                    )
                ){
                    Image(
                        painter = painterResource(id = R.drawable.register),
                        contentDescription = "top icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp)
                    )
                }
                //end of card holding icon

            }
            Text(
                text = "Add Menu",
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif,
                color = Color.Black
            )
            // intro row end


            Spacer(modifier = Modifier.height(28.dp))


            OutlinedTextField(
                value = menuName,
                onValueChange = { menuName = it },
                placeholder = { Text(text="eg.pizza") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(text = "Menu Name") }
            )

            Spacer(modifier = Modifier.height(13.dp))















            OutlinedTextField(
                value = menuDescription,
                onValueChange = { menuDescription = it },
                placeholder = { Text(text="eg. steak or chicken... ") },
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(
                    text = "Menu Description",
                    fontSize = 17.sp,
                    textDecoration = TextDecoration.Underline
                )
                },
            )

            Spacer(modifier = Modifier.height(15.dp))


            OutlinedTextField(
                value = quantity,
                onValueChange = {quantity= it },
                placeholder = { Text(text="eg.large or small... ") },
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(
                    text = "Quantity",
                    fontSize = 17.sp,
                    textDecoration = TextDecoration.Underline
                )
                },
            )

            Spacer(modifier = Modifier.height(15.dp))


            OutlinedTextField(
                value = price,
                onValueChange = { price = it },
                placeholder = { Text(text="eg. ksh.650 for small/ksh.1200 for large... ") },
                modifier = Modifier
                    .height(130.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                label = { Text(
                    text = "Amount Description",
                    fontSize = 17.sp,
                    textDecoration = TextDecoration.Underline
                )
                },
            )

            Spacer(modifier = Modifier.height(15.dp))

            val modifier = Modifier
            val context = LocalContext.current
            MenuUploadButton(modifier,context, navController , menuName.trim() , menuDescription.trim() , quantity.trim(),price.trim())

        }
    }
}

@Composable
fun MenuUploadButton(modifier: Modifier = Modifier, context: Context, navController: NavHostController, name:String, description:String, quantity:String, price:String){
    Button(onClick = {
        val taskRepository = MenuViewModel(navController,context)
        taskRepository.uploadMenu(name, description,quantity,price)
    },
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(LightCyan),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp, vertical = 20.dp)
    ) {
        Text(
            text = "Upload Menu",
            fontSize = 17.sp
        )
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun AddMenuScreenPreview(){
    AddMenuScreen(navController = rememberNavController())
}