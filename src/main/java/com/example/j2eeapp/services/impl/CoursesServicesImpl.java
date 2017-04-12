package com.example.j2eeapp.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import org.springframework.transaction.annotation.Transactional;

import com.example.j2eeapp.dao.CoursesDao;
import com.example.j2eeapp.dao.LecturesDao;
import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.domain.CoursesEntity;
import com.example.j2eeapp.domain.LabExamplesEntity;
import com.example.j2eeapp.domain.LecturesEntity;
import com.example.j2eeapp.domain.UserEntity;
import com.example.j2eeapp.services.CoursesService;

public class CoursesServicesImpl implements CoursesService {
	
	CoursesDao coursesDao;
	UserDao userDao;
	LecturesDao lecturesDao;
	
	public CoursesServicesImpl(CoursesDao coursesDao, UserDao userDao, LecturesDao lecturesDao) {
		super();
		this.coursesDao = coursesDao;
		this.userDao = userDao;
		this.lecturesDao = lecturesDao;
	}

	public boolean createCourse(CoursesEntity coursesEntity, String name) {
		if(!coursesDao.checkAvailable(coursesEntity.getCourseCode()))
		{
		  FacesMessage message=constructErrorMessage(String.format("Course '%s' is not available", coursesEntity.getCourseCode()), null);
		   getFacesContext().addMessage(null, message);
		   return false;
		}
		try 
		{
			UserEntity userEntity=userDao.loadUserByUserName(name);
			coursesEntity.setUserEntity(userEntity);
		    coursesDao.save(coursesEntity);
		} 
		catch (Exception e) {
			FacesMessage message=constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return false;
			
		}
		
		return true;
	}
	

	public List<SelectItem> loadCredits()
	{
	 List<SelectItem> credits=	coursesDao.getCreditOptions();	
		return credits;	
	}
	
	public List<CoursesEntity> loadAllCourses() {
	    List<CoursesEntity> courses = coursesDao.findAll();
		return courses;
	}
	
	public List<SelectItem> loadCourseCreditHours() {
		List<SelectItem> creditHours=coursesDao.getCourseCreditHoursOption();
		return creditHours;
	}
	public List<SelectItem> loadcourseTypes() 
	{
	   List<SelectItem> types=coursesDao.getCourseTypesOptions();
		return types;
	}
	
	public List<SelectItem> loadCourseYear() {
		 List<SelectItem> years=coursesDao.getCourseYear();
			return years;
	}

	public List<SelectItem> loadCourseTerm() {
		 List<SelectItem> terms=coursesDao.getCourseTerm();
			return terms;
	}


	
	
	
	public boolean updateCourse(CoursesEntity coursesEntity) {
	
		try {
			coursesDao.update(coursesEntity);
			} 
			catch (Exception e) {
				FacesMessage message=constructFatalMessage(e.getMessage(), null);
				getFacesContext().addMessage(null, message);
				return false;
				
			}
		return true;
	}
	
	public List<LecturesEntity> getLectures(CoursesEntity  coursesEntity)
	{
		return coursesEntity.getLecturesEntity();
	}
	
	@Transactional
	public List<CoursesEntity> loadLectureByCourse() 
	{
	
		List<CoursesEntity> courses = coursesDao.findAll();
		for(CoursesEntity course:courses)
		{
			 List<LecturesEntity> lectures=course.getLecturesEntity();
			course.setLecturesEntity(lectures);
		}
		return courses;
	}
	
	@Transactional
	public List<CoursesEntity> loadLabExamplesByCourse()
	{
		List<CoursesEntity> courses=coursesDao.findAll();
		for(CoursesEntity course:courses)
		{
			List<LabExamplesEntity> labs=course.getLabExamplesEntity();
			course.setLabExamplesEntity(labs);
		}
		return courses;
	}
	
  protected FacesMessage constructInfoMessage(String message,String detail)
	{
		return new FacesMessage(FacesMessage.SEVERITY_INFO,message,detail);
	}
  protected FacesMessage constructFatalMessage(String message,String detail)
	{
		return new FacesMessage(FacesMessage.SEVERITY_FATAL,message,detail);
	}
   protected FacesMessage constructErrorMessage(String message,String detail)
	{
		return new FacesMessage(FacesMessage.SEVERITY_ERROR,message,detail);
	}
	
	FacesContext getFacesContext()
	{
	 return	FacesContext.getCurrentInstance();
	}

	
	public CoursesDao getCoursesDao() {
		return coursesDao;
	}

	public void setCoursesDao(CoursesDao coursesDao) {
		this.coursesDao = coursesDao;
	}
	

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void delteCourse(CoursesEntity entity)
	{
		coursesDao.delete(entity);
	}

	public List<CoursesEntity> loadFirstFCourses() {
		
		return coursesDao.getFirstFCourses();
	}

	public List<CoursesEntity> loadFirstSCourses() {
		return coursesDao.getFirstSCourses();
	}

	public List<CoursesEntity> loadSecondFCourses() {
		
		return coursesDao.getSecondFCourses();
	}

	public List<CoursesEntity> loadSecondSCourses() {
		return coursesDao.getSecondSCourses();
	}

	public List<CoursesEntity> loadThirdFCourses() {
		return coursesDao.getThirdFCourses();
	}

	public List<CoursesEntity> loadThirdSCourses() {
		return coursesDao.getThirdSCourses();
	}

	public List<CoursesEntity> loadFourthFCourses() {
		return coursesDao.getFourthFCourses();
	}

	public List<CoursesEntity> loadFourthSCourses() {
		return coursesDao.getFourthSCourses();
	}

	



}
