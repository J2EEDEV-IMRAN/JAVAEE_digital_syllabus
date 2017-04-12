package com.example.j2eeapp.domain;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.example.j2eeapp.commons.domain.BaseEntity;

@Entity
@Table(name="courses")
public class CoursesEntity extends BaseEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5610744565502850451L;
	private String courseCode;
	private String courseTitle;
	private String courseOverview;
	private Float courseCredit;
	private String courseReferenceBook;
	private String courseType;
	private Float courseCreditHours;
	private Integer courseYear;
	private Integer courseTerm;
	@ManyToOne
	@JoinColumn(name="user_id")
	private UserEntity userEntity;
	@OneToMany(mappedBy="coursesEntity",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	private List<LecturesEntity> lecturesEntity;
	@OneToMany(mappedBy="coursesEntity",cascade=CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<LabExamplesEntity> labExamplesEntity;
	
	
	public Integer getCourseYear() {
		return courseYear;
	}
	public void setCourseYear(Integer courseYear) {
		this.courseYear = courseYear;
	}
	public Integer getCourseTerm() {
		return courseTerm;
	}
	public void setCourseTerm(Integer courseTerm) {
		this.courseTerm = courseTerm;
	}
	public List<LecturesEntity> getLecturesEntity() {
		return lecturesEntity;
	}
	public void setLecturesEntity(List<LecturesEntity> lecturs) {
		this.lecturesEntity = lecturs;
	}
	public List<LabExamplesEntity> getLabExamplesEntity() {
		return labExamplesEntity;
	}
	public void setLabExamplesEntity(List<LabExamplesEntity> labExamplesEntity) {
		this.labExamplesEntity = labExamplesEntity;
	}
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseOverview() {
		return courseOverview;
	}
	public void setCourseOverview(String courseOverview) {
		this.courseOverview = courseOverview;
	}

	public Float getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(Float courseCredit) {
		this.courseCredit = courseCredit;
	}
	public String getCourseReferenceBook() {
		return courseReferenceBook;
	}
	public void setCourseReferenceBook(String courseReferenceBook) {
		this.courseReferenceBook = courseReferenceBook;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public String getCourseType() {
		return courseType;
	}
	
	public Float getCourseCreditHours() {
		return courseCreditHours;
	}
	public void setCourseCreditHours(Float courseCreditHours) {
		this.courseCreditHours = courseCreditHours;
	}

}
