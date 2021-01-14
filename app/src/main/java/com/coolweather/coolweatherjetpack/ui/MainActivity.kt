package com.coolweather.coolweatherjetpack.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coolweather.coolweatherjetpack.R
import com.coolweather.coolweatherjetpack.ui.area.ChooseAreaFragment
import com.coolweather.coolweatherjetpack.ui.weather.WeatherActivity
import com.coolweather.coolweatherjetpack.util.InjectorUtil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val isWeatherCached = InjectorUtil.getWeatherRepository().getWeather() != null
//        if (isWeatherCached) {
//            val intent = Intent(this, WeatherActivity::class.java)
//            startActivity(intent)
//            finish()
//        } else {
            supportFragmentManager.beginTransaction().replace(R.id.container, ChooseAreaFragment())
                .commit()
//        }
    }
}
