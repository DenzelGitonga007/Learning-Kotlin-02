package com.example.d_eats.data
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.d_eats.models.User
import com.example.d_eats.navigation.ROUTE_HOME
import com.example.d_eats.navigation.VIEW_MENU
import com.example.d_eats.navigation.ROUTE_LOGIN
import com.example.d_eats.navigation.ROUTE_REGISTER
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase



class AuthViewModel(var navController: NavController, var context: Context){
    val mAuth: FirebaseAuth


    init {
        mAuth = FirebaseAuth.getInstance()
    }
    fun signup(name:String, email:String, password:String,confpassword:String){


        if (email.isBlank() || password.isBlank() ||confpassword.isBlank()){
            Toast.makeText(context,"All fields are required", Toast.LENGTH_LONG).show()
        }else if (password != confpassword){
            Toast.makeText(context,"Password do not match", Toast.LENGTH_LONG).show()
        }else{
            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {
                if (it.isSuccessful){
                    val userdata= User(name,email,password,mAuth.currentUser!!.uid)
                    val regRef=FirebaseDatabase.getInstance().getReference()
                        .child("Users/"+mAuth.currentUser!!.uid)
                    regRef.setValue(userdata).addOnCompleteListener {

                        if (it.isSuccessful){
                            navController.navigate(ROUTE_LOGIN)
                            Toast.makeText(context,"Registered Successfully", Toast.LENGTH_LONG).show()


                        }else{
                            Toast.makeText(context,"${it.exception!!.message}", Toast.LENGTH_LONG).show()
                            navController.navigate(ROUTE_REGISTER)
                        }
                    }
                }else{
                    navController.navigate(ROUTE_REGISTER)
                }

            } }

    }

    fun login(email: String, password: String){

        if (email.isBlank() || password.isBlank()){
            Toast.makeText(context,"All fields are required", Toast.LENGTH_LONG).show()
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                if (it.isSuccessful ){
                    Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
//                    navController.navigate(ROUTE_HOME)
                    navController.navigate(VIEW_MENU)
                }else{
                    Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }





    fun logout(){
        mAuth.signOut()
        navController.navigate(ROUTE_HOME)
    }

    fun isLoggedIn(): Boolean = mAuth.currentUser != null

}