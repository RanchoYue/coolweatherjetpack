package com.coolweather.coolweatherjetpack.learn

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coolweather.coolweatherjetpack.CoolWeatherApplication
import com.coolweather.coolweatherjetpack.data.model.weather.Weather
import com.coolweather.coolweatherjetpack.util.InjectorUtil
import kotlinx.coroutines.launch

/**
 * @author yue
 */
class WeatherViewModelExt : ViewModel() {
    private val userLiveData = MutableLiveData<Weather>()
    val weather: LiveData<Weather>
        get() = userLiveData

    fun doAction() {
        launch({
            userLiveData.value = InjectorUtil.getWeatherRepository().getWeather("CN101340102")
        }, {
            Toast.makeText(CoolWeatherApplication.context, it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit) =
        viewModelScope.launch {
            try {
                block()
            } catch (e: Throwable) {
                error(e)
            }
        }
}