package telran.ashkelon2018.geo.domain;

import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"id"})
@ToString
@Builder
public class Place {
	int id;
	String info;
	@GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2D)
	double[] location;

}
