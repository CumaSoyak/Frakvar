package farkvar.com.utils

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import farkvar.com.CoreApp
import farkvar.com.utils.AppConstants.IS_USER_LOGGED
import farkvar.com.utils.AppConstants.PREF_NAME
import farkvar.com.utils.AppConstants.TOKEN
import farkvar.com.utils.extensions.get
import farkvar.com.utils.extensions.removeValue
import farkvar.com.utils.extensions.setValue


object PrefUtils {
    private const val FIRST_TIME = "is_First_Time_Open"


    private val instance: SharedPreferences = CoreApp.context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun checkIsFirstTimeOpen(): Boolean {
        val firstTime = instance.getBoolean(FIRST_TIME, true)
        if (firstTime) {
            instance.setValue(FIRST_TIME, false)
            return true
        }
        return false
    }
/*
    fun set(user: String) {

        instance.removeValue(USER_DETAIL)
        instance.setValue(USER_DETAIL, user)

    }

    fun remove(key: String) {
        instance.removeValue(key)
    }

    fun get(key: String, value: Any?) {
        instance.get(key, value)
    }

    fun createUser(user: String) {

        if (!isLoggedUser()) {

            instance.setValue(IS_USER_LOGGED, true)

        }
        instance.removeValue(USER_DETAIL)
        instance.setValue(USER_DETAIL, user)


    }

    fun createCity(city: String) {
        instance.removeValue(CITY)
        instance.setValue(CITY, city)
    }

    fun getCity(): List<Cities>? {

        val turnsType = object : TypeToken<List<Cities>>() {}.type
        val turns = Gson().fromJson<List<Cities>>(instance.getString(CITY, ""), turnsType)
        // return GsonBuilder().create().fromJson<List<Cities>>(instance.getString(CITY, ""),turnsType)
        return turns
    }

    fun getUser(): User {

        return GsonBuilder().create().fromJson(instance.getString(USER_DETAIL, ""), User::class.java)

    }

    fun getUserId(): Int {
        return getUser().id
    }

    fun createToken(token: String) {
        instance.setValue(TOKEN, token)
    }
*/
    fun getToken(): String {
        if (instance.getString(TOKEN,null).isNullOrEmpty()){
            return ""
        }
        else{
            return GsonBuilder().create().fromJson(instance.getString(TOKEN, ""), String::class.java)
        }
    }


    fun isLoggedUser(): Boolean = instance.getBoolean(IS_USER_LOGGED, false)

/*
    fun logoutUser() {

        instance.setValue(IS_USER_LOGGED, false)

        instance.removeValue(USER_DETAIL)

        instance.removeValue(TOKEN)


    }
*/
}