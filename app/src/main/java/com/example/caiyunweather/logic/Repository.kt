package com.example.caiyunweather.logic

import androidx.lifecycle.liveData
import com.example.caiyunweather.logic.model.Place
import com.example.caiyunweather.logic.network.CaiYunWeatherNetwork
import kotlinx.coroutines.Dispatchers
import java.lang.RuntimeException

object Repository {

    fun searchPlaces(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = CaiYunWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                val places = placeResponse.places
                Result.success(places)
            } else {
                Result.failure(RuntimeException("response status it ${placeResponse.status}"))
            }
        }catch (e:Exception){
        Result.failure<List<Place>>(e)
        }
        emit(result)
    }
}