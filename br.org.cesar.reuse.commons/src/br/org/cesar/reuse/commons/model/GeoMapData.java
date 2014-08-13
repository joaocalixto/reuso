package br.org.cesar.reuse.commons.model;

import java.math.BigDecimal;

public class GeoMapData {

	private BigDecimal[] center;
	private Integer zoom;
	private Integer[] size;
	private Boolean sensor;

	public GeoMapData(final Integer zoom, final Integer[] size,
			final Boolean sensor) {
		super();
		center = new BigDecimal[3];
		this.zoom = zoom;
		this.size = size;
		this.sensor = sensor;
	}

	public BigDecimal[] getCenter() {
		return center;
	}

	public void setCenter(final BigDecimal[] center) {
		this.center = center;
	}

	public Integer getZoom() {
		return zoom;
	}

	public void setZoom(final Integer zoom) {
		this.zoom = zoom;
	}

	public Integer[] getSize() {
		return size;
	}

	public void setSize(final Integer[] size) {
		this.size = size;
	}

	public Boolean getSensor() {
		return sensor;
	}

	public void setSensor(final Boolean sensor) {
		this.sensor = sensor;
	}

}
