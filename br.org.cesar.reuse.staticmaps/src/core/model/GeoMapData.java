package core.model;

import java.math.BigDecimal;

public class GeoMapData {

	private BigDecimal[] center;
	private Integer zoom;
	private Integer[] size;
	private Boolean sensor;
	
	public GeoMapData(BigDecimal[] center, Integer zoom, Integer[] size, Boolean sensor) {
		super();
		this.center = center;
		this.zoom = zoom;
		this.size = size;
		this.sensor = sensor;
	}
	public BigDecimal[] getCenter() {
		return center;
	}
	public void setCenter(BigDecimal[] center) {
		this.center = center;
	}
	public Integer getZoom() {
		return zoom;
	}
	public void setZoom(Integer zoom) {
		this.zoom = zoom;
	}
	public Integer[] getSize() {
		return size;
	}
	public void setSize(Integer[] size) {
		this.size = size;
	}
	public Boolean getSensor() {
		return sensor;
	}
	public void setSensor(Boolean sensor) {
		this.sensor = sensor;
	}

	
}
