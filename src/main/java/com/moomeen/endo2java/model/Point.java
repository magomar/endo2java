package com.moomeen.endo2java.model;

import static com.moomeen.endo2java.model.Constants.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Point {
	private ZonedDateTime time;
	private Double speed;
	@JsonProperty("dist")
	private Double distance;
	@JsonProperty("alt")
	private Double altitude;
	@JsonProperty("lng")
	private Double longitude;
	@JsonProperty("lat")
	private Double latitude;
	@JsonProperty("inst")
	private PointInstruction instruction;

	@JsonProperty("time")
	public void setStartTime(String startTime){
		this.time = ZonedDateTime.parse(startTime, DATE_TIME_FORMATTER);
	}

	public ZonedDateTime getTime() {
		return time;
	}
	public Double getSpeed() {
		return speed;
	}
	public Double getDistance() {
		return distance;
	}
	public Double getAltitude() {
		return altitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public PointInstruction getInstruction() {
		return instruction;
	}
}