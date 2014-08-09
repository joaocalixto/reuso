package core;

import core.exception.StaticMapException;
import core.model.GeoMapData;

public interface IStaticMap {
	
	public String getStaticMapURL(GeoMapData geoMapData) throws StaticMapException;

}
