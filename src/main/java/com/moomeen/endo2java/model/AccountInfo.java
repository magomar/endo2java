package com.moomeen.endo2java.model;

import static com.moomeen.endo2java.model.Constants.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.ZonedDateTime;
import java.util.TimeZone;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountInfo {

	@JsonProperty("weight_kg")
	private Integer weight;
	private String phone;
	private Sex sex;
	private ZonedDateTime syncTime;
	private ZonedDateTime dateOfBirth;
	@JsonProperty("lounge_member")
	private Boolean loungeMember;
	@JsonProperty("favorite_sport")
	private Sport favoriteSport;
	@JsonProperty("favorite_sport2")
	private Sport favoriteSport2;
	private String units;
	private String country;
	private Long id;
	@JsonProperty("first_name")
	private String firstName;
	@JsonProperty("last_name")
	private String lastName;
	@JsonProperty("picture_id")
	private Long pictureId;
	private ZonedDateTime weightTime;
	@JsonProperty("height_cm")
	private Integer height;
	private ZonedDateTime createdTime;
	private TimeZone timeZone;

	@JsonProperty("sync_time")
	public void setSyncTime(String s){
		this.syncTime = ZonedDateTime.parse(s, DATE_TIME_FORMATTER);
	}

	@JsonProperty("date_of_birth")
	public void setDateOfBirth(String s){
		this.dateOfBirth = ZonedDateTime.parse(s, DATE_TIME_FORMATTER);
	}

	@JsonProperty("weight_time")
	public void setWeightTime(String s){
		this.weightTime = ZonedDateTime.parse(s, DATE_TIME_FORMATTER);
	}

	@JsonProperty("created_time")
	public void setCreatedTime(String s){
		this.createdTime = ZonedDateTime.parse(s, DATE_TIME_FORMATTER);
	}
	
	@JsonProperty("time_zone")
	public void setTimeZone(String s){
		this.timeZone = TimeZone.getTimeZone(s);
	}

	public Integer getWeight() {
		return weight;
	}

	public String getPhone() {
		return phone;
	}

	public Sex getSex() {
		return sex;
	}

	public ZonedDateTime getSyncTime() {
		return syncTime;
	}

	public ZonedDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public Boolean getLoungeMember() {
		return loungeMember;
	}

	public Sport getFavoriteSport() {
		return favoriteSport;
	}

	public Sport getFavoriteSport2() {
		return favoriteSport2;
	}

	public String getUnits() {
		return units;
	}

	public String getCountry() {
		return country;
	}

	public Long getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public Long getPictureId() {
		return pictureId;
	}

	public ZonedDateTime getWeightTime() {
		return weightTime;
	}

	public Integer getHeight() {
		return height;
	}

	public ZonedDateTime getCreatedTime() {
		return createdTime;
	}

	public TimeZone getTimeZone() {
		return timeZone;
	}
}
