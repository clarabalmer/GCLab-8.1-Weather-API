package co.grandcircus.WeatherProject;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@Autowired
	private WeatherService weatherService;
	
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}
	@PostMapping("/locationSelect")
	public String showWeather(@RequestParam double latitude, @RequestParam double longitude, Model model) {
		WeatherResponse weather = weatherService.getWeather(latitude, longitude);
		model.addAttribute("weather", weather);
		ArrayList<UpcomingWeather> upcomingWeather = new ArrayList<>();
		for (int i = 0; i < weather.getTime().getStartPeriodName().length; i++) {
			upcomingWeather.add(new UpcomingWeather(weather.getTime().getStartPeriodName()[i], weather.getData().getTemperature()[i],
					weather.getData().getText()[i]));
		}
		model.addAttribute("upcomingWeather", upcomingWeather);
		return "weatherResults";
	}
}
