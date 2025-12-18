package com.example.sign_in_responsive_adaptative.model

data class RegistreInfo(
    var nombre: String = "",
    var apellido1: String = "",
    var apellido2: String = "",
    var email: String = "",
    var fechaNacimiento: String = "",
    var passwd: String = "",
    var passwdConfirm: String = "",
    var userName: String = "",
    var Validnombre: Boolean = false,
    var Validapellido1: Boolean = false,
    var Validapellido2: Boolean = false,
    var Validemail: Boolean = false,
    var ValidfechaNacimiento: Boolean = false,
    var Validpasswd: Boolean = false,
    var ValidpasswdConfirm: Boolean = false,
    var ValiduserName: Boolean = false,
    var tc: Boolean = false,
)