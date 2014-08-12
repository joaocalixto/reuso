package br.org.cesar.reuse.commons.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Repair {

	private long id;
	private String description;
	private Date openingDate;
	private Location location;
	private RepairStatus status;

	/**
	 * @return the id
	 */
	public final long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public final void setId(final long id) {
		this.id = id;
	}

	/**
	 * @return the description
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public final void setDescription(final String description) {
		this.description = description;
	}

	/**
	 * @return the openingDate
	 */
	public final Date getOpeningDate() {
		return openingDate;
	}

	/**
	 * @param openingDate
	 *            the openingDate to set
	 */
	public final void setOpeningDate(final Date openingDate) {
		this.openingDate = openingDate;
	}

	/**
	 * @return the location
	 */
	public final Location getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public final void setLocation(final Location location) {
		this.location = location;
	}

	/**
	 * @return the status
	 */
	public final RepairStatus getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public final void setStatus(final RepairStatus status) {
		this.status = status;
	}

	public static List<String> getAtributes() {

		return new ArrayList<String>() {
			{
				add("Description");
			}
		};
	}
}
