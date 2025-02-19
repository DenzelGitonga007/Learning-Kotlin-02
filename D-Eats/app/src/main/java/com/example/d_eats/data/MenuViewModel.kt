package com.example.d_eats.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavHostController
import com.example.d_eats.models.Menu
import com.example.d_eats.navigation.ADD_MENU
import com.example.d_eats.navigation.ROUTE_LOGIN
import com.example.d_eats.navigation.VIEW_MENU
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MenuViewModel(var navController: NavHostController, var context: Context) {
    var authViewModel:AuthViewModel
    var progress:ProgressDialog
    init {
        authViewModel = AuthViewModel(navController, context)
        if (!authViewModel.isLoggedIn()){
            navController.navigate(ROUTE_LOGIN)
        }
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait...")
    }

    fun uploadMenu(name:String, description:String,quantity:String,price:String){
        val taskId = System.currentTimeMillis().toString()
        progress.show()

        val currentUser = FirebaseAuth.getInstance().currentUser
        val userId = currentUser?.uid

        val task = Menu(name,description,quantity,price,taskId,userId?:"")
        val databaseRef = FirebaseDatabase.getInstance().getReference()
            .child("Menus/$taskId")
        databaseRef.setValue(task).addOnCompleteListener {
            progress.dismiss()
            if (it.isSuccessful){
                navController.navigate(VIEW_MENU)
                Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
            }
        }
    }


    fun deleteMenu(taskId:String){
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Menus/$taskId")
        ref.removeValue()
        Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show()
    }

    fun updateMenu(taskId:String){
        val ref = FirebaseDatabase.getInstance().getReference()
            .child("Menus/$taskId")
        ref.removeValue()
        navController.navigate(ADD_MENU)
    }

    fun allMenu(
        task: MutableState<Menu>,
        tasks: SnapshotStateList<Menu>): SnapshotStateList<Menu> {
        progress.show()

        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Menus")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                tasks.clear()
                for (snap in snapshot.children){
                    val retrievedTask = snap.getValue(Menu::class.java)
                    task.value = retrievedTask!!
                    tasks.add(retrievedTask)
                }
                progress.dismiss()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return tasks
    }

}