package com.example.paycard

import android.content.Context

class Prefs(val contex: Context) {
    private val GUARDAR_NOMBRE = "name"
    private val GUARDAR_SECCION = "seccion"
    private val GUARDAR_MONTO = "monto"

    private val sharepreference = contex.getSharedPreferences(GUARDAR_NOMBRE, 0)

    fun GuardarName(name: String) {
        sharepreference.edit().putString(GUARDAR_NOMBRE, name).apply()
    }

    fun GuardarSeccion(session: Boolean) {
        sharepreference.edit().putBoolean(GUARDAR_SECCION, session)
    }

    fun GuaradarMonto(monto: String) {
        sharepreference.edit().putString(GUARDAR_MONTO, monto)
    }

    fun GetName(): String {
        return sharepreference.getString(GUARDAR_NOMBRE, "")!!
    }


    fun GetSeccion(): Boolean {
        return sharepreference.getBoolean(GUARDAR_SECCION, false)
    }

    fun GetMonto(): String {
        return sharepreference.getString(GUARDAR_MONTO, "00")!!
    }
}