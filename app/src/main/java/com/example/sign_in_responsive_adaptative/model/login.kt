package com.example.sign_in_responsive_adaptative.model

data class Login(
    var fullName: String = "",
    var Bdate: String = "",
    var mail: String = "",
    var phone: Int = 0,
    var username: String = "",
    var passwd: String = "",
    var passwdConfirmation: String = "",
    var tc: Boolean = false //Terminos y condiciones
)