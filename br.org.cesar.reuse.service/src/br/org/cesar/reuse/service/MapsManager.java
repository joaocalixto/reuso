package br.org.cesar.reuse.service;

import newmaps.IStaticMap;
import br.org.cesar.reuse.commons.model.GeoMapData;
import br.org.cesar.reuse.commons.model.StaticMapException;

public class MapsManager {

	public static IStaticMap map;
	
	public static IStaticMap getInstanceIStaticMap(){
		return map;
	}
	
	public String getStaticMapURL(GeoMapData geoMapData) throws StaticMapException{
		return map.getStaticMapURL(geoMapData);
	}
	
	public void setMap(IStaticMap staticMap) {   
		map = staticMap;  
	}  
	public void unsetAuth(IStaticMap staticMap) {   
		if (staticMap == map) {    
			map = null;    
		}  
	} 

	
	
}
