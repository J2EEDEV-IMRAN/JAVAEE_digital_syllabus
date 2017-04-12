package com.example.j2eeapp.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.j2eeapp.commons.domain.BaseEntity;
@Entity
@Table(name="labexamples")
public class LabExamplesEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8937619415609995313L;
	
	private String labExampleName;
	private String labExampleSolution;
	private String labExampleSampleAnswer;
	@ManyToOne
	private CoursesEntity coursesEntity;
	
	public CoursesEntity getCoursesEntity() {
		return coursesEntity;
	}
	public void setCoursesEntity(CoursesEntity coursesEntity) {
		this.coursesEntity = coursesEntity;
	}
	public String getLabExampleName() {
		return labExampleName;
	}
	public void setLabExampleName(String labExampleName) {
		this.labExampleName = labExampleName;
	}
	public String getLabExampleSolution() {
		return labExampleSolution;
	}
	public void setLabExampleSolution(String labExampleSolution) {
		this.labExampleSolution = labExampleSolution;
	}
	public String getLabExampleSampleAnswer() {
		return labExampleSampleAnswer;
	}
	public void setLabExampleSampleAnswer(String labExampleSampleAnswer) {
		this.labExampleSampleAnswer = labExampleSampleAnswer;
	}
	
	

}
