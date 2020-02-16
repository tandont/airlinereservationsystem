package com.capgemini.airlinereservationsystem.dto;

import java.util.Date;

public class FlightAvailability {
	private Date availDate;
	private Integer availSeat;
	private Integer flightId;

	public Date getAvailDate() {
		return availDate;
	}

	public void setAvailDate(Date availDate) {
		this.availDate = availDate;
	}

	public Integer getAvailSeat() {
		return availSeat;
	}

	public void setAvailSeat(Integer availSeat) {
		this.availSeat = availSeat;
	}

	public Integer getFlightId() {
		return flightId;
	}

	public void setFlightId(Integer flightId) {
		this.flightId = flightId;
	}

	@Override
	public String toString() {
		return "FlightAvailability [availDate=" + availDate + ", availSeat=" + availSeat + ", flightId=" + flightId
				+ "]";
	}

}
