package com.example.d_eats.ui.theme.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.d_eats.R
import com.example.d_eats.data.AuthViewModel
import com.example.d_eats.navigation.ROUTE_LOGIN
import com.example.d_eats.navigation.ROUTE_REGISTER
import com.example.d_eats.ui.theme.LightCyan

@Composable
fun RegisterScreen(navController: NavController){

   Column(
      modifier = Modifier.fillMaxSize(),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
   ){

      
      Image(
         painter = painterResource(R.drawable.register),
         contentDescription = "register icon",
         modifier = Modifier.size(200.dp)
      )


      Spacer(modifier = Modifier.height(20.dp))

      Text(
         "D-Eats",
         fontSize = 40.sp,
         fontFamily = FontFamily.Cursive,
         fontWeight = FontWeight.ExtraBold
      )

      Spacer(modifier = Modifier.height(5.dp))

      Text(
         "Do not have account? Register Here!",
         fontSize = 18.sp
      )

      Spacer(modifier = Modifier.height(5.dp))



      var name by remember { mutableStateOf("") }
      var email by remember { mutableStateOf("") }
      var password by remember { mutableStateOf("") }
      var confpassword by remember { mutableStateOf("") }


      OutlinedTextField(
         value = name,
         onValueChange = { name = it },
         modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp),
         leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "", tint = LightCyan) },
         placeholder = { Text("Fullname")},
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
      )


      Spacer(modifier = Modifier.height(10.dp))


 OutlinedTextField(
         value = email,
         onValueChange = { email = it },
         modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp),
         leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "", tint = LightCyan) },
         placeholder = { Text("Email Address")},
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
      )


      Spacer(modifier = Modifier.height(10.dp))


 OutlinedTextField(
         value =  password,
         onValueChange = { password = it },
         modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp),
         leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = LightCyan) },
         placeholder = { Text("Password")},
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
         visualTransformation = PasswordVisualTransformation()
      )


      Spacer(modifier = Modifier.height(5.dp))


 OutlinedTextField(
         value = confpassword,
         onValueChange = {  confpassword = it },
         modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp),
         leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "", tint = LightCyan) },
         placeholder = { Text("Confirm Password")},
         keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
         visualTransformation = PasswordVisualTransformation()

 )


      Spacer(modifier = Modifier.height(5.dp))



       val context = LocalContext.current // current screen
       val authViewModel = AuthViewModel(navController, context)

       Button(
           onClick = {
               authViewModel.signup(name, email, password,confpassword)
               
           },
           modifier = Modifier.fillMaxWidth().padding(start = 14.dp, end = 14.dp),
           colors = ButtonDefaults.buttonColors(LightCyan),
           shape = RoundedCornerShape(5.dp)

       ) {

           Text(
               "Create An Account",
               fontSize = 15.sp
           )
       }


       Spacer(modifier = Modifier.height(5.dp))

       Text(
           "Already have account? Go to Login!",
           fontSize = 18.sp,
           modifier = Modifier.clickable {  navController.navigate(ROUTE_LOGIN) }
       )















   }



}



@Composable
@Preview(showBackground = true)
fun RegisterScreenPreview(){

   RegisterScreen(navController = rememberNavController())

}