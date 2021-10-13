package com.example.weather.logic.dao

import android.content.Context
import android.provider.Settings.Global.putString
import androidx.core.content.edit
import com.example.weather.WeatherApplication
import com.example.weather.logic.model.Place
import com.google.gson.Gson

object PlaceDao {
    fun savePlace(place : Place){
        sharedPreference().edit(){
            putString("place", Gson().toJson(place))
        }
    }

    fun getSavedPlace() : Place{
        val placeJson = sharedPreference().getString("place", "")
        return Gson().fromJson(placeJson, Place::class.java)
    }

    fun isPlaceSaved() = sharedPreference().contains("place")

    private fun sharedPreference() = WeatherApplication.context
            .getSharedPreferences("weather", Context.MODE_PRIVATE)
}