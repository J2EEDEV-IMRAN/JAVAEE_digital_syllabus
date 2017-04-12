package com.example.j2eeapp.services;

import java.util.List;

import javax.faces.model.SelectItem;

import com.example.j2eeapp.domain.CoursesEntity;

public interface CoursesService {
	boolean createCourse(CoursesEntity coursesEntity,String name);
	List<SelectItem> loadCredits();
	List<SelectItem> loadcourseTypes();
	List<SelectItem> loadCourseCreditHours();
	List<SelectItem> loadCourseYear();
	List<SelectItem> loadCourseTerm();
	List<CoursesEntity> loadAllCourses();
	boolean updateCourse(CoursesEntity coursesEntity);
	void delteCourse(CoursesEntity entity);
	
	List<CoursesEntity> loadFirstFCourses();
	List<CoursesEntity> loadFirstSCourses();
	List<CoursesEntity> loadSecondFCourses();
	List<CoursesEntity> loadSecondSCourses();
	
	List<CoursesEntity> loadThirdFCourses();
	List<CoursesEntity> loadThirdSCourses();
	List<CoursesEntity> loadFourthFCourses();
	List<CoursesEntity> loadFourthSCourses();
	
	
	List<CoursesEntity> loadLectureByCourse();
	List<CoursesEntity> loadLabExamplesByCourse();
	
}
