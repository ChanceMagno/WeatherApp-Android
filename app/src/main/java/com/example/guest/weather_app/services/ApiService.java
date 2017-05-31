package com.example.guest.weather_app.services;


import android.util.Log;

import com.example.guest.weather_app.Constants;

import org.json.JSONObject;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;

import models.DayForecast;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class ApiService {
    public static final String TAG = ApiService.class.getSimpleName();

    public static void getWeather (String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder().build();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        String url = urlBuilder.build().toString();
        Log.d("url", url);

        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }


        public static ArrayList<DayForecast> processResults(Response response) {
                ArrayList<DayForecast> dayForecasts = new ArrayList<>();
        try {

            if (response.isSuccessful()) {
                String jsonData = response.body().string();
                JSONObject dayObject = new JSONObject(jsonData);
                String name = dayObject.getString("name");
                String clouds = dayObject.getJSONObject("clouds").getString("all");
                String main = dayObject.getJSONArray("weather").getJSONObject(0).getString("main");
                String description = dayObject.getJSONArray("weather").getJSONObject(0).getString("description");
                String icon = dayObject.getJSONArray("weather").getJSONObject(0).getString("icon");
                String currentTemp = dayObject.getJSONObject("main").getString("temp");
                String minTemp = dayObject.getJSONObject("main").getString("temp_min");
                String maxTemp = dayObject.getJSONObject("main").getString("temp_max");

                DayForecast dayForecast = new DayForecast(name, main, description, icon, currentTemp, maxTemp, minTemp, clouds);
                dayForecasts.add(dayForecast);

            }
            } catch(IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }


            return dayForecasts;
    }





}
