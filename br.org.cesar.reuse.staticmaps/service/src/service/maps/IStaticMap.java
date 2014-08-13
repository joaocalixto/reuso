package service.maps;

import br.org.cesar.reuse.commons.model.GeoMapData;
import br.org.cesar.reuse.commons.model.StaticMapException;


public interface IStaticMap {
	
	public String getStaticMapURL(GeoMapData geoMapData) throws StaticMapException;

}
