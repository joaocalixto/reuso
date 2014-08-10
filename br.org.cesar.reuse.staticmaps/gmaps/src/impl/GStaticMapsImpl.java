package impl;

import java.math.BigDecimal;

import service.GeoMapData;
import service.IStaticMap;
import service.StaticMapException;

public class GStaticMapsImpl implements IStaticMap {

	public static final String prefix = "http://maps.googleapis.com/maps/api/staticmap?";
	public static final String separete_str = "&";
	
	@Override
	public String getStaticMapURL(GeoMapData geoMapData) throws StaticMapException {
		// http://maps.googleapis.com/maps/api/staticmap?center=40.714728,-73.998672&zoom=12&size=400x400&sensor=false
		
		StringBuilder retorno = new StringBuilder();
		
		BigDecimal[] center = geoMapData.getCenter();
		
		retorno.append(this.prefix);
		retorno.append(validateAndBuildCenter(center));
		retorno.append(this.separete_str);
		
		if(geoMapData.getZoom() != null) {
			retorno.append("zoom="+geoMapData.getZoom().toString());
		}
		
		retorno.append(this.separete_str);
		Integer[] size = geoMapData.getSize();
		retorno.append(validateAndBuildSize(size));
		
		retorno.append(this.separete_str);
		if(geoMapData.getSensor() != null) {
			retorno.append("sensor="+geoMapData.getSensor().toString());
		}
		
		
		return retorno.toString();
	}
	
	private StringBuilder validateAndBuildCenter(BigDecimal[] center) throws StaticMapException {
		StringBuilder centerStr = new StringBuilder();
		if(center != null && center.length > 1) {
			centerStr = new StringBuilder();
			centerStr.append("center=");
			centerStr.append(center[0].toString()+","+center[1].toString());
		}else {
			throw new StaticMapException("Parametro Invalido" + "[CENTER]");
		}
		return centerStr;
	}
	
	private StringBuilder validateAndBuildSize(Integer[] size) throws StaticMapException {
		StringBuilder centerStr = new StringBuilder();
		if(size != null && size.length > 1) {
			centerStr = new StringBuilder();
			centerStr.append("size=");
			centerStr.append(size[0].toString()+"x"+size[1].toString());
		}else {
			throw new StaticMapException("Parametro Invalido" + "[ZOOM]");
		}
		return centerStr;
	}

}
