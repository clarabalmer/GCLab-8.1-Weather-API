package co.grandcircus.WeatherProject;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
	private RestTemplate restTemplate = new RestTemplate();
	
	public WeatherResponse getWeather(double latitude, double longitude) {
		String url = "https://forecast.weather.gov/MapClick.php?lat={0}&lon={1}&FcstType=json";
		WeatherResponse response = restTemplate.getForObject(url, WeatherResponse.class, latitude, longitude);
		return response;
	}
}
