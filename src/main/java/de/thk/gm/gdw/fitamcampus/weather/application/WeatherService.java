//package de.thk.gm.gdw.fitamcampus.weather.application;
//
//import de.thk.gm.gdw.fitamcampus.weather.domain.Koordinaten;
//import de.thk.gm.gdw.fitamcampus.weather.domain.Weather;
//import org.json.JSONObject;
//import org.springframework.stereotype.Service;
//
//import java.io.IOException;
//import java.net.URI;
//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
//
//@Service
//public class WeatherService {
//    public Weather getWeather(String ort) throws IOException, InterruptedException {
//        Koordinaten koordinaten = getGeoCode(ort);
//        HttpClient httpClient = HttpClient.newBuilder().build();
//        HttpRequest httpRequest = HttpRequest.newBuilder()
//                .GET()
//                .uri(URI.create("https://api.open-meteo.com/v1/forecast?latitude=" + koordinaten.getLatitude().toString() + "&longitude=" + koordinaten.getLongitude().toString() + "&current=temperature_2m,weather_code"))
//                .build();
//        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
//        JSONObject json = new JSONObject(httpResponse.body()).getJSONObject("current");
//        Float temp = json.getFloat("temperature_2m");
//        String code = weatherCodeToString(json.getInt("weather_code"));
//        Weather weather = new Weather();
//        weather.setTemperature(temp);
//        weather.setWeatherCode(code);
//        return weather;
//
//
//
//    }
//    public String getMap(String ort) throws IOException, InterruptedException {
//        // Koordinaten des Orts abrufen
//        Koordinaten koordinaten = getGeoCode(ort);
//
//        // Generiere die OpenStreetMap-URL mit den Koordinaten
//        String mapUrl = "https://www.openstreetmap.org/?mlat="
//                + koordinaten.getLatitude()
//                + "&mlon="
//                + koordinaten.getLongitude()
//                + "&zoom=15";
//
//        return mapUrl;
//    }
//
//
//
//    public Koordinaten getGeoCode(String ort) throws IOException, InterruptedException {
//        Koordinaten geoCode = new Koordinaten();
//        String stadt="https://geocoding-api.open-meteo.com/v1/search?name="+ ort +"&count=1&language=de&format=json";
//        HttpClient httpClient=HttpClient.newBuilder().build();
//        HttpRequest httpRequest =
//                HttpRequest.newBuilder().GET().uri(URI.create(stadt)).build();
//        HttpResponse<String> httpResponse=httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
//        JSONObject json = new JSONObject(httpResponse.body());
//        geoCode.setLatitude(json.getJSONArray("results").getJSONObject(0).getFloat("latitude"));
//        geoCode.setLongitude(json.getJSONArray("results").getJSONObject(0).getFloat("longitude"));
//        return geoCode;
//
//    }
//
//
//
//
//    private String weatherCodeToString(int weatherCode) {
//        switch (weatherCode) {
//            case 0:
//                return "Clear sky";
//            case 1:
//                return "Mainly clear";
//            case 2:
//                return "Partly cloudy";
//            case 3:
//                return "Overcast";
//            case 45:
//                return "Fog";
//            case 48:
//                return "Depositing rime fog";
//            case 51:
//                return "Drizzle: Light intensity";
//            case 53:
//                return "Drizzle: Moderate intensity";
//            case 55:
//                return "Drizzle: Dense intensity";
//            case 56:
//                return "Freezing Drizzle: Light intensity";
//            case 57:
//                return "Freezing Drizzle: Dense intensity";
//            case 61:
//                return "Rain: Slight intensity";
//            case 63:
//                return "Rain: Moderate intensity";
//            case 65:
//                return "Rain: Heavy intensity";
//            case 66:
//                return "Freezing Rain: Light intensity";
//            case 67:
//                return "Freezing Rain: Heavy intensity";
//            case 71:
//                return "Snow fall: Slight intensity";
//            case 73:
//                return "Snow fall: Moderate intensity";
//            case 75:
//                return "Snow fall: Heavy intensity";
//            case 77:
//                return "Snow grains";
//            case 80:
//                return "Rain showers: Slight intensity";
//            case 81:
//                return "Rain showers: Moderate intensity";
//            case 82:
//                return "Rain showers: Violent intensity";
//            case 85:
//                return "Snow showers: Slight intensity";
//            case 86:
//                return "Snow showers: Heavy intensity";
//            case 95:
//                return "Thunderstorm: Slight or moderate";
//            case 96:
//                return "Thunderstorm with slight hail";
//            case 99:
//                return "Thunderstorm with heavy hail";
//            default:
//                return "Unknown weather code";
//        }
//    }
//    }
//
package de.thk.gm.gdw.fitamcampus.weather.application;

import de.thk.gm.gdw.fitamcampus.weather.domain.Koordinaten;
import de.thk.gm.gdw.fitamcampus.weather.domain.Weather;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
public class WeatherService {

    public Weather getWeather(String ort) throws IOException, InterruptedException {
        Koordinaten koordinaten = getGeoCode(ort);

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.open-meteo.com/v1/forecast?latitude="
                        + koordinaten.getLatitude()
                        + "&longitude=" + koordinaten.getLongitude()
                        + "&current=temperature_2m,weather_code"))
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JSONObject json = new JSONObject(httpResponse.body()).getJSONObject("current");
        Float temp = json.getFloat("temperature_2m");
        String code = weatherCodeToString(json.getInt("weather_code"));

        Weather weather = new Weather();
        weather.setTemperature(temp);
        weather.setWeatherCode(code);
        return weather;
    }

    public String getMap(String ort) throws IOException, InterruptedException {
        // Koordinaten des Orts abrufen
        Koordinaten koordinaten = getGeoCode(ort);

        // Generiere die OpenStreetMap-URL mit den Koordinaten
        String mapUrl = "https://www.openstreetmap.org/export/embed.html?bbox="
                + (koordinaten.getLongitude() - 0.05) + ","
                + (koordinaten.getLatitude() - 0.05) + ","
                + (koordinaten.getLongitude() + 0.05) + ","
                + (koordinaten.getLatitude() + 0.05)
                + "&layer=mapnik&marker="
                + koordinaten.getLatitude() + ","
                + koordinaten.getLongitude();

        return mapUrl;
    }

    public Koordinaten getGeoCode(String ort) throws IOException, InterruptedException {
        Koordinaten geoCode = new Koordinaten();
        String apiUrl = "https://nominatim.openstreetmap.org/search?q="
                + ort
                + "&format=json&addressdetails=1&limit=1";

        HttpClient httpClient = HttpClient.newBuilder().build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(apiUrl))
                .header("User-Agent", "MeinProjekt (meineemail@example.com)")
                .build();

        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        JSONArray results = new JSONArray(httpResponse.body());

        if (results.isEmpty()) {
            throw new IOException("Keine Ergebnisse gefunden für Ort: " + ort);
        }

        JSONObject location = results.getJSONObject(0);
        geoCode.setLatitude(location.getFloat("lat"));
        geoCode.setLongitude(location.getFloat("lon"));
        return geoCode;
    }

    private String weatherCodeToString(int weatherCode) {
        switch (weatherCode) {
            case 0: return "Clear sky";
            case 1: return "Mainly clear";
            case 2: return "Partly cloudy";
            case 3: return "Overcast";
            case 45: return "Fog";
            case 48: return "Depositing rime fog";
            case 51: return "Drizzle: Light intensity";
            case 53: return "Drizzle: Moderate intensity";
            case 55: return "Drizzle: Dense intensity";
            case 56: return "Freezing Drizzle: Light intensity";
            case 57: return "Freezing Drizzle: Dense intensity";
            case 61: return "Rain: Slight intensity";
            case 63: return "Rain: Moderate intensity";
            case 65: return "Rain: Heavy intensity";
            case 66: return "Freezing Rain: Light intensity";
            case 67: return "Freezing Rain: Heavy intensity";
            case 71: return "Snow fall: Slight intensity";
            case 73: return "Snow fall: Moderate intensity";
            case 75: return "Snow fall: Heavy intensity";
            case 77: return "Snow grains";
            case 80: return "Rain showers: Slight intensity";
            case 81: return "Rain showers: Moderate intensity";
            case 82: return "Rain showers: Violent intensity";
            case 85: return "Snow showers: Slight intensity";
            case 86: return "Snow showers: Heavy intensity";
            case 95: return "Thunderstorm: Slight or moderate";
            case 96: return "Thunderstorm with slight hail";
            case 99: return "Thunderstorm with heavy hail";
            default: return "Unknown weather code";
        }
    }
}
