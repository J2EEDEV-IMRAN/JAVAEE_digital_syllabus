package com.example.j2eeapp.domain;


import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;

@Entity
@Table(name="lectures")
public class LecturesEntity extends BaseEntity
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9077091622276560238L;
	private String lectureTopicName;
	private Long lectuerNumber;
	@ManyToOne
	private CoursesEntity coursesEntity;
	public String getLectureTopicName() {
		return lectureTopicName;
	}
	public void setLectureTopicName(String lectureTopicName) {
		this.lectureTopicName = lectureTopicName;
	}
	public Long getLectuerNumber() {
		return lectuerNumber;
	}
	public void setLectuerNumber(Long lectuerNumber) {
		this.lectuerNumber = lectuerNumber;
	}
	public CoursesEntity getCoursesEntity() {
		return coursesEntity;
	}
	public void setCoursesEntity(CoursesEntity coursesEntity) {
		this.coursesEntity = coursesEntity;
	}

	

}
