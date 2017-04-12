package com.example.j2eeapp.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.CoursesEntity;

public interface CoursesDao extends GenericDao<CoursesEntity, Long> {
	
	boolean checkAvailable(String courseCode);
    List<SelectItem> getCreditOptions();
	List<SelectItem> getCourseTypesOptions();
	List<SelectItem> getCourseCreditHoursOption();
	List<SelectItem> getCourseYear();
	List<SelectItem> getCourseTerm();
	CoursesEntity loadCourseByCourseCode(String courseCode);
	
	List<CoursesEntity> getFirstFCourses();
	List<CoursesEntity> getFirstSCourses();
	List<CoursesEntity> getSecondFCourses();
	List<CoursesEntity> getSecondSCourses();
	
	List<CoursesEntity> getThirdFCourses();
	List<CoursesEntity> getThirdSCourses();
	List<CoursesEntity> getFourthFCourses();
	List<CoursesEntity> getFourthSCourses();

}
