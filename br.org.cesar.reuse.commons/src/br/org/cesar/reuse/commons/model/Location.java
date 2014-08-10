package br.org.cesar.reuse.commons.model;

public class Location {

	private double latitude;
	private double longitude;

	/**
	 * @return the latitude
	 */
	public final double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            The latitude to set
	 */
	public final void setLatitude(final double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public final double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            The longitude to set
	 */
	public final void setLongitude(final double longitude) {
		this.longitude = longitude;
	}
}
