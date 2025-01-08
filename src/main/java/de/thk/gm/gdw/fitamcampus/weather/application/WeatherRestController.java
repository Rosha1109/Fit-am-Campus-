package de.thk.gm.gdw.fitamcampus.weather.application;


import de.thk.gm.gdw.fitamcampus.weather.domain.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(produces= MediaType.APPLICATION_JSON_VALUE,value="/api/weather")
public class WeatherRestController {
    Weather weather;
    @Autowired
    private WeatherService weatherService;
    @GetMapping("/gummersbach")
    public Weather getWeatherService() throws IOException, InterruptedException {
      return weatherService.getWeather();
        /*JSONObject json = weatherService.getWeather().getJSONObject("current");
        Float temp = json.getFloat("temperature_2m");
        String code = weatherService.weatherCodeToString(json.getInt("weather_code"));
        weather = new Weather();
        weather.setTemperature(temp);
        weather.setWeatherCode(code);
        return weather;*/

    }
}
