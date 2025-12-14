package com.example.sign_in_responsive_adaptative.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.sign_in_responsive_adaptative.model.Login

class MainViewModel: ViewModel() {
    private val _login = mutableStateOf(Login())
    val login get() = _login
    var fullname: Boolean = false
    var birthbdate: Boolean = false
    var EMAIL: Boolean = false
    var Telefono: Boolean = false
    var NombreUser: Boolean = false
    var passwd: Boolean = false
    //Nombre completo
    fun setFullName(name: String){
        if (Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$").matches(name)){
            _login.value = _login.value.copy(fullName =  name)
            fullname = true
        }else{
            fullname = false
        }
    }

    //fecha de cumpleaños
    fun setBdate(bdate: String){
        if (bdate.isEmpty()){
            _login.value = _login.value.copy(Bdate =  bdate)
            birthbdate = true
        }else{birthbdate = false}
    }

    //mail
    fun setmail(correo: String){
        if (Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$").matches(correo)){
            _login.value = _login.value.copy(mail = correo)
            EMAIL = true
        }else{EMAIL = false}
    }
    //telefono
    fun settel(tel: String){
        if (Regex("^[0-9]{9}$").matches(tel)){
            _login.value = _login.value.copy(phone = tel.toInt())
            Telefono = true
        }else{Telefono = false}
    }
    //username
    fun setusername(Username: String){
        if (Regex("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$").matches(Username)){
            _login.value = _login.value.copy(username = Username)
            NombreUser = true
        }else{NombreUser = false}
    }
    //passwd
    fun setpasswd(passwd1: String, passwd2: String){
        if (passwd2.equals(passwd1)){
            if (Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+{}\\[\\]:;<>,.?~\\/-]).{8,}$").matches(passwd1)){
                _login.value = _login.value.copy(username = passwd1)
                passwd = true
            }else{passwd = false}
        }else{passwd = false}
    }
}