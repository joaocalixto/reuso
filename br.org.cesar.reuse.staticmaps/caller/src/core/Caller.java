package core;

import java.math.BigDecimal;

import service.maps.IStaticMap;
import br.org.cesar.reuse.commons.model.GeoMapData;
import br.org.cesar.reuse.commons.model.StaticMapException;

public class Caller {
	/**
	 * 
	 */
	private IStaticMap mapservice;

	public Caller() {
		
		BigDecimal big1 = new BigDecimal(40.714728).setScale(6, BigDecimal.ROUND_HALF_UP);
		BigDecimal big2 = new BigDecimal(-73.998672).setScale(6, BigDecimal.ROUND_HALF_UP);
		
		BigDecimal[] center = new BigDecimal[2];
		center[0] = big1;
		center[1] = big2;
		
		Integer[] size = { 400, 400 };
		GeoMapData geoMapData = new GeoMapData(12, size, false);
		
	}

	public void setMap(IStaticMap maps) {
		System.out.println("Maps service chegando");
		this.mapservice = maps;
	}

	public void unsetMap(IStaticMap maps) {
		System.out.println("Maps service indo embora");
		if (mapservice == this.mapservice) {
			this.mapservice = null;
			System.out.println("Maps service foi embora");
		}
	}
}
