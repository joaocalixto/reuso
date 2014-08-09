package test;

import java.math.BigDecimal;

import core.IStaticMap;
import core.exception.StaticMapException;
import core.impl.StaticGMaps;
import core.model.GeoMapData;

public class TestBuildURLStaticMaps {

	private GeoMapData geoMapData;

	public void test() {
		IStaticMap staticMaps = new StaticGMaps();

		BigDecimal big1 = new BigDecimal(40.714728).setScale(6, BigDecimal.ROUND_HALF_UP);
		BigDecimal big2 = new BigDecimal(-73.998672).setScale(6, BigDecimal.ROUND_HALF_UP);
		
		BigDecimal[] center = new BigDecimal[2];
		center[0] = big1;
		center[1] = big2;
		
		Integer[] size = { 400, 400 };
		geoMapData = new GeoMapData(center, 12, size, false);
		try {
			String staticMapURL = staticMaps.getStaticMapURL(geoMapData);
			
			System.out.println("http://maps.googleapis.com/maps/api/staticmap?center=40.714728,-73.998672&zoom=12&size=400x400&sensor=false");
			System.out.println(staticMapURL);
		} catch (StaticMapException e) {
			e.printStackTrace();
		}
	}

}
