package telran.ashkelon2018.geo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2018.geo.dao.PlaceRepository;
import telran.ashkelon2018.geo.domain.Place;

@RestController
public class PlaceController {
	@Autowired
	PlaceRepository repository;
	
	@PostMapping("/place/{id}/{x}/{y}")
	public Place addPlace(@PathVariable int id, @PathVariable double x, @PathVariable double y) {
		double[] point = {x, y};
		return repository.save(new Place(id,"description",point));
	}
	
	@GetMapping("/place/{x}/{y}/{r}")
	public List<Place> findPlaces(@PathVariable double x, @PathVariable double y, @PathVariable double r){
		Point point = new Point(x, y);
		Distance distance = new Distance(r);
		return repository.findByLocationNear(point, distance);
	}
}
