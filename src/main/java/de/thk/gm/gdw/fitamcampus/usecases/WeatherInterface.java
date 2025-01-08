package de.thk.gm.gdw.fitamcampus.usecases;

import org.json.JSONObject;

import java.io.IOException;

public interface WeatherInterface {
    JSONObject getWeather() throws IOException, InterruptedException;
}
