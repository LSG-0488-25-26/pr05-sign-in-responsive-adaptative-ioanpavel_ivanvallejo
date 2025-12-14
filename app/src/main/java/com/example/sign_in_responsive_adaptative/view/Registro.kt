package com.example.sign_in_responsive_adaptative.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.sign_in_responsive_adaptative.viewModel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun register(viewModel: MainViewModel = viewModel()){
    var fullname by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var passwd1 by remember { mutableStateOf("") }
    var passwd2 by remember { mutableStateOf("") }
    var user by remember { mutableStateOf("") }
    var tel by remember { mutableStateOf("") }
    var mail by remember { mutableStateOf("") }
    val datePickerState = rememberDatePickerState()
    var showDialog by remember { mutableStateOf(false) }
    Card(){
        Column {
            Text("Registre")
            //fullname
            TextField(
                value = fullname,
                onValueChange = {
                    fullname = it
                    viewModel.setFullName(name = it)
                                },
                label = { Text("Fullname") }

            )
            Spacer(modifier = Modifier.height(5.dp))
            //Birthdate
            OutlinedTextField(
                value = date,
                onValueChange = {viewModel.setBdate(date)},          // no typing
                readOnly = true,             // important
                label = { Text("Birthdate") },
                modifier = Modifier.fillMaxWidth(),
                trailingIcon = {
                    IconButton(onClick = { showDialog = true }) {
                        Icon(Icons.Default.DateRange, contentDescription = "Pick date")
                    }
                }
            )
            if (showDialog) {
                DatePickerDialog(
                    onDismissRequest = { showDialog = false },
                    confirmButton = {
                        TextButton(onClick = { showDialog = false }) {
                            Text("Confirm")
                        }
                    }
                ) {
                    DatePicker(state = datePickerState)
                }
            }
            Spacer(modifier = Modifier.height(5.dp))
            //email
            TextField(
                value = mail,
                onValueChange = {
                    mail = it
                    viewModel.setmail(correo = it)
                },
                label = { Text("Email") }
            )
            Spacer(modifier = Modifier.height(5.dp))
            //Telefono
            TextField(
                value = tel,
                onValueChange = {
                    tel = it
                    viewModel.settel(tel = it)
                },
                label = { Text("Phone") }
            )
            Spacer(modifier = Modifier.height(5.dp))
            //Username
            TextField(
                value = user,
                onValueChange = {
                    user = it
                    viewModel.setusername(Username = it)
                },
                label = { Text("Username") }
            )
            Spacer(modifier = Modifier.height(5.dp))
            //passwd1
            TextField(
                value = passwd1,
                onValueChange = {
                    passwd1 = it
                },
                label = { Text("Password") }
            )
            Spacer(modifier = Modifier.height(5.dp))
            //passwd2
            TextField(
                value = user,
                onValueChange = {
                    user = it
                    viewModel.setpasswd(passwd1 = passwd1, passwd2 = passwd2)
                },
                label = { Text("Repeat Password") }
            )
            Spacer(modifier = Modifier.height(5.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun RegistroPreview() {
    register()
}
