package com.kunal.FindCollege.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;
@Entity
@Table(name="College")
public class College {
	
	@Id
	@NotEmpty
	private String collegeId;
	@Size(min=2,max=20,message="Name should be in between 2 - 20 characters")
	private String collegeName;
	
	@NotEmpty
	@Email
	private String collegeEmail;
	@NotNull
	private String collegeCity;
	@Length(min=4,max=20,message="Country name should be in between 4 to 20 characters")
	private String collegeCountry;
	@Range(min=1,max=100,message="College Rank should be in between 1 and 100")
	private Long collegeRank;
	@URL
	private String url;
	public College() {
		super();
	}

	public College(@NotEmpty String collegeId,
			@Size(min = 2, max = 20, message = "Name should be in between 2 - 20 characters") String collegeName,
			@Email @NotEmpty String collegeEmail, @NotNull String collegeCity, String collegeCountry, Long collegeRank,
			String url) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.collegeEmail = collegeEmail;
		this.collegeCity = collegeCity;
		this.collegeCountry = collegeCountry;
		this.collegeRank = collegeRank;
		this.url = url;
	}
	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", collegeEmail=" + collegeEmail
				+ ", collegeCity=" + collegeCity + ", collegeCountry=" + collegeCountry + ", collegeRank=" + collegeRank
				+ ", url=" + url + "]";
	}
	public String getCollegeId() {
		return collegeId;
	}
	public void setCollegeId(String collegeId) {
		this.collegeId = collegeId;
	}
	public String getCollegeName() {
		return collegeName;
	}
	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}
	public String getCollegeEmail() {
		return collegeEmail;
	}
	public void setCollegeEmail(String collegeEmail) {
		this.collegeEmail = collegeEmail;
	}
	public String getCollegeCity() {
		return collegeCity;
	}
	public void setCollegeCity(String collegeCity) {
		this.collegeCity = collegeCity;
	}
	public String getCollegeCountry() {
		return collegeCountry;
	}
	public void setCollegeCountry(String collegeCountry) {
		this.collegeCountry = collegeCountry;
	}
	public Long getCollegeRank() {
		return collegeRank;
	}
	public void setCollegeRank(Long collegeRank) {
		this.collegeRank = collegeRank;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}