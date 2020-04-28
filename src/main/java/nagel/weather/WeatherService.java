package nagel.weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("http://api.openweathermap.org/data/2.5/weather?zip&appid=ae64c1e0eb7deb372764616366d1105f&units=imperial")
    Call<CurrentWeather> getWeather(@Query("zip") String zip);
}
