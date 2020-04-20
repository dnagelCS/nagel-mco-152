package nagel.weather;

import com.google.gson.Gson;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetCurrentWeather {

    public CurrentWeather getCurrentWeather(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));

        Gson gson = new Gson();
        CurrentWeather currentWeather = gson.fromJson(reader, CurrentWeather.class);

        return currentWeather;
    }

/*    public static void main(String[] args) throws IOException {
        //URL url = new URL("https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b6907d289e10d714a6e88b30761fae22");
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?zip=94040,us&appid=ae64c1e0eb7deb372764616366d1105f");

        String name = currentWeather.name;
        System.out.println(name);

        String temp = ((int)(((currentWeather.main.temp) - 273.15) * (9.0/5) + 32) + "°F");
        System.out.println(temp);

    }*/
}
