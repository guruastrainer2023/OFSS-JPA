package com.training.bean.pack4;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="CountryHoliday10")
public class CountryHolidays {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ch_id_seq")
	@SequenceGenerator(name = "ch_id_seq", sequenceName ="seq13", allocationSize = 1)
	private int id;
	
	@Column
	private String countryName;
	
	@ElementCollection
    @CollectionTable(name = "Country_holidays_dates_10") 
    @MapKeyColumn(name = "holiday_name")
    @Column(name = "holiday_date")
	private Map<String, LocalDate> holidayMap;
	
	public CountryHolidays(int id, String countryName, Map<String, LocalDate> holidayMap) {
		super();
		this.id = id;
		this.countryName = countryName;
		this.holidayMap = holidayMap;
	}
	public CountryHolidays(String countryName, Map<String, LocalDate> holidayMap) {
		super();
		this.countryName = countryName;
		this.holidayMap = holidayMap;
	}
	public CountryHolidays(int id) {
		super();
		this.id = id;
	}
	public CountryHolidays() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public Map<String, LocalDate> getHolidayMap() {
		return holidayMap;
	}
	public void setHolidayMap(Map<String, LocalDate> holidayMap) {
		this.holidayMap = holidayMap;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryHolidays other = (CountryHolidays) obj;
		return id == other.id;
	}
	@Override
	public String toString() {
		return "CountryHolidays [id=" + id + ", countryName=" + countryName + ", holidayMap=" + holidayMap + "]";
	}

	
	
	public void addHoliday(String holidayName, LocalDate holidayDate) {
		if(this.holidayMap==null)
			this.holidayMap=new HashMap<>();
		
		this.holidayMap.put(holidayName, holidayDate);
	}
	
}
