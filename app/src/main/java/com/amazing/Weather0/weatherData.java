package com.amazing.Weather0;

import org.json.JSONException;
import org.json.JSONObject;

public class weatherData {

    private String mTemperature,micon,mcity,mWeatherType;
    private int mCondition;

    public static weatherData fromJson(JSONObject jsonObject)
    {

        try
        {
            weatherData weatherD=new weatherData();
            weatherD.mcity=jsonObject.getString("name");
            weatherD.mCondition=jsonObject.getJSONArray("weather").getJSONObject(0).getInt("id");
            weatherD.mWeatherType=jsonObject.getJSONArray("weather").getJSONObject(0).getString("main");
            weatherD.micon=updateWeatherIcon(weatherD.mCondition);
            double tempResult=jsonObject.getJSONObject("main").getDouble("temp")-273.15;
            int roundedValue=(int)Math.rint(tempResult);
            weatherD.mTemperature=Integer.toString(roundedValue);
            return weatherD;
        }


        catch (JSONException e) {
            e.printStackTrace();
            return null;
        }


    }


    private static String updateWeatherIcon(int condition)
    {
        if(condition>=0 && condition<=232)
        {
            return "thunderstorm";
        }
        else if(condition>=300 && condition<=321)
        {
            return "showerrain";
        }
        else if(condition>=500 && condition<=504)
        {
            return "dayrain";
        }
        if (condition==511)
        {
            return "snow";
        }
        else  if(condition>=520 && condition<=531)
        {
            return "showerrain";
        }
        else if(condition>=600 && condition<=622)
        {
            return "snow";
        }
        if (condition==701)
        {
            return "mist";
        }
        if (condition==711)
        {
            return "mist";
        }
        if (condition==721)
        {
            return "mist";
        }
        if (condition==731)
        {
            return "mist";
        }
        if (condition==741)
        {
            return "mist";
        }
        if (condition==751)
        {
            return "mist";
        }
        if (condition==761)
        {
            return "mist";
        }
        if (condition==762)
        {
            return "mist";
        }
        if (condition==771)
        {
            return "mist";
        }
        if (condition==781)
        {
            return "mist";
        }
        if (condition==800)
        {
            return "clearskyday";
        }
        if (condition==801)
        {
            return "fewcloudsday";
        }
        if (condition==802)
        {
            return "brokenclouds";
        }
        if (condition==803)
        {
            return "scatteredclouds";
        }
        if (condition==804)
        {
            return "scatteredclouds";
        }


        return "dunno";


    }

    public String getmTemperature() {
        return mTemperature+"°C";
    }

    public String getMicon() {
        return micon;
    }

    public String getMcity() {
        return mcity;
    }

    public String getmWeatherType() {
        return mWeatherType;
    }
}