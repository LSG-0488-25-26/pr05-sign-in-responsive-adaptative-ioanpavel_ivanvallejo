package com.example.sign_in_responsive_adaptative.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.sign_in_responsive_adaptative.model.RegistreInfo

class MainViewModel : ViewModel() {

    private val _registreUserInfo = mutableStateOf(RegistreInfo())
    val registreUserInfo get() = _registreUserInfo


    //register user name setter
    fun setName(nombre: String) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(nombre = nombre)
    }
    //register user surname1 setter
    fun setSurnameFirst(apellido: String) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(apellido1 = apellido)
    }
    //register user surname2 setter
    fun setSurnameSecond(apellido: String) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(apellido2 = apellido)
    }
    //register user email setter
    fun setEmail(email: String) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(email = email)
    }
    //register user birthdate setter
    fun setBirthdate(fecha: String) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(fechaNacimiento = fecha)
    }
    //register user passwd setter
    fun setpasswd(passwd: String) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(passwd = passwd)
    }
    //register user passwd setter
    fun setpasswdComprobation(passwd: String) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(passwdConfirm = passwd)
    }
    //register user gender setter
    fun setTc(tc: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(tc = tc)
    }
    //register user username setter
    fun setUserName(username: String) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(userName = username)
    }

    //comprobar username
    fun setUserName(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(ValiduserName = valid)
    }


    //register user name setter
    fun IsValidName(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(Validnombre = valid)
    }
    //register user surname1 setter
    fun IsValidSurnameFirst(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(Validapellido1 = valid)
    }
    //register user surname2 setter
    fun IsValidSurnameSecond(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(Validapellido2 = valid)
    }
    //register user email setter
    fun IsValidEmail(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(Validemail = valid)
    }
    //register user birthdate setter
    fun IsValidBirthdate(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(ValidfechaNacimiento = valid)
    }
    //register user passwd setter
    fun IsValidpasswd(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(Validpasswd = valid)
    }
    //register user passwd setter
    fun IsValidpasswdComprobation(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(ValidpasswdConfirm = valid)
    }
    //register user username setter
    fun IsValidUserName(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(ValiduserName = valid)
    }
    //register user gender setter
    fun IsValidTermsConditions(valid: Boolean) {
        _registreUserInfo.value =
            _registreUserInfo.value.copy(tc = valid)
    }

    //textfieldsValidation
    fun textValid(id: String, valid: Boolean){
        when (id){
            "un" -> IsValidUserName(valid)
            "n" -> IsValidName(valid)
            "sn1" -> IsValidSurnameFirst(valid)
            "sn2" -> IsValidSurnameSecond(valid)
            "m" -> IsValidEmail(valid)
            "bd" -> IsValidBirthdate(valid)
            "pass" -> IsValidpasswd(valid)
            "passC" -> if (_registreUserInfo.value.passwdConfirm
                    .equals(_registreUserInfo.value.passwd)) IsValidpasswdComprobation(true) else IsValidpasswdComprobation(false)
            "tc" -> IsValidTermsConditions(valid)
        }
    }

    //Button enabler
    fun registerInOrder(): Boolean {
        return _registreUserInfo.value.ValiduserName &&
                _registreUserInfo.value.Validnombre &&
                _registreUserInfo.value.Validapellido1 &&
                _registreUserInfo.value.Validapellido2 &&
                _registreUserInfo.value.Validemail &&
                _registreUserInfo.value.ValidfechaNacimiento &&
                _registreUserInfo.value.Validpasswd &&
                _registreUserInfo.value.ValidpasswdConfirm &&
                _registreUserInfo.value.tc
    }

}