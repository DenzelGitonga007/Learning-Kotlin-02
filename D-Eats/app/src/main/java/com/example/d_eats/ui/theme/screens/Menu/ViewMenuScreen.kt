package com.example.d_eats.ui.theme.screens.Menu

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.d_eats.R
import com.example.d_eats.data.MenuViewModel
import com.example.d_eats.models.Menu
import com.example.d_eats.navigation.ADD_MENU
import com.example.d_eats.navigation.ROUTE_ABOUT
import com.example.d_eats.navigation.ROUTE_HOME
import com.example.d_eats.ui.theme.LightCyan
import com.google.firebase.auth.FirebaseAuth

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "RememberReturnType")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ViewMenuScreen(navController: NavHostController) {
    val context = LocalContext.current
    val taskRepository = MenuViewModel(navController, context)

    val emptyTaskState = remember { mutableStateOf(Menu("", "", "", "", "", "")) }
    val emptyTasksListState = remember { mutableStateListOf<Menu>() }

    val tasks = taskRepository.allMenu(emptyTaskState, emptyTasksListState)

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "D-Eats",
                        fontSize = 40.sp,
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = LightCyan,
                    titleContentColor = Color.White
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(ADD_MENU) // Navigate to the ADD_MENU screen
                },
                containerColor = LightCyan
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add Meal", tint = Color.White)
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Card(
                    modifier = Modifier.size(70.dp),
                    shape = RoundedCornerShape(50)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.register),
                        contentDescription = "top icon",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(6.dp)
                    )
                }
            }
            Text(
                text = "View Menus",
                fontSize = 26.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily.SansSerif
            )
            Spacer(modifier = Modifier.height(15.dp))

            LazyColumn {
                items(tasks) { menu ->
                    TaskItem(
                        name = menu.name,
                        description = menu.description,
                        quantity = menu.quantity,
                        price = menu.price,
                        id = menu.id,
                        userId = menu.userId,
                        navController = navController,
                        taskRepository = taskRepository
                    )
                }
            }
        }
    }
}




@Composable
fun TaskItem(
    name: String, description: String, quantity: String, price: String, id: String, userId: String,
    navController: NavHostController,
    taskRepository: MenuViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 25.dp)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                Color.LightGray
            )
        ) {
            Column(
                modifier = Modifier.padding(8.dp)
            ) {
                Text(
                    text = "Meal: $name",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    textDecoration = TextDecoration.Underline
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Description : $description",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Quantity : $quantity",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    text = "Amount per plate : $price",
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(3.dp))

                Row(
                    modifier = Modifier
                        .padding(bottom = 10.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    OutlinedButton(
                        onClick = {
                            taskRepository.updateMenu(id)
                        },
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(LightCyan)
                    ) {
                        Row {
                            Icon(
                                imageVector = Icons.Default.Edit,
                                contentDescription = "update"
                            )
                            Spacer(modifier = Modifier.width(3.dp))
                            Text(
                                text = "Update"
                            )
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Button(
                            onClick = {
                                taskRepository.deleteMenu(id)
                            },
                            colors = ButtonDefaults.buttonColors(
                                Color.Red
                            ),
                            shape = RoundedCornerShape(8.dp)
                        ) {
                            Row {
                                Icon(imageVector = Icons.Default.Delete, contentDescription = "delete")
                                Spacer(modifier = Modifier.width(3.dp))
                                Text(
                                    text = "Delete",
                                    color = Color.White
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun ViewMenuScreenPreview() {
    ViewMenuScreen(navController = rememberNavController())
}
