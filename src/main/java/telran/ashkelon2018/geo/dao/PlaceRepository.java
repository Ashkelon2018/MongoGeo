package telran.ashkelon2018.geo.dao;

import java.util.List;

import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.repository.MongoRepository;



import telran.ashkelon2018.geo.domain.Place;

public interface PlaceRepository extends MongoRepository<Place, Integer> {
	List<Place> findByLocationNear(Point point, Distance distance);
}
