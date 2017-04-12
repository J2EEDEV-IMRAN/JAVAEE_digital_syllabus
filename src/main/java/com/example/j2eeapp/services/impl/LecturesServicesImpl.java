package com.example.j2eeapp.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import com.example.j2eeapp.dao.CoursesDao;
import com.example.j2eeapp.dao.LecturesDao;
import com.example.j2eeapp.dao.UserDao;
import com.example.j2eeapp.domain.CoursesEntity;
import com.example.j2eeapp.domain.LecturesEntity;
import com.example.j2eeapp.services.LecturesService;

public class LecturesServicesImpl implements LecturesService {
	
	LecturesDao lecturesDao;
	CoursesDao coursesDao;
	UserDao  userDao;



	public LecturesServicesImpl(LecturesDao lecturesDao, CoursesDao coursesDao,
			UserDao userDao) {
		super();
		this.lecturesDao = lecturesDao;
		this.coursesDao = coursesDao;
		this.userDao = userDao;
	}

	public boolean createLecture(LecturesEntity lecturesEntity, String courseCode) 
	{
		if(!lecturesDao.checkAvailable(lecturesEntity.getLectureTopicName()))
		{
		  FacesMessage message=constructErrorMessage(String.format("Lecture '%s' not available", "is"), null);
		   getFacesContext().addMessage(null, message);
		   return false;
		}
		try {
			CoursesEntity coursesEntity=coursesDao.loadCourseByCourseCode(courseCode);
			lecturesEntity.setCoursesEntity(coursesEntity);
			lecturesDao.save(lecturesEntity);
			
		} catch (Exception e) {
			FacesMessage message= constructFatalMessage(e.getMessage(), null);
			getFacesContext().addMessage(null, message);
			return false;
		}
		return true;
	}

	public List<SelectItem> loadLectureNumber() {
		List<SelectItem> lecturs=lecturesDao.getLectures();
		return lecturs;
	}
	
	public List<LecturesEntity> loadAllLectures() {
	List<LecturesEntity> lecturs  =	(List<LecturesEntity>) lecturesDao.findAll();
		return  lecturs;
	}
	
	public boolean updateLecture(LecturesEntity  lecturesEntity) {
		
		try {
			lecturesDao.update(lecturesEntity);
			} 
			catch (Exception e) {
				FacesMessage message=constructFatalMessage(e.getMessage(), null);
				getFacesContext().addMessage(null, message);
				return false;
				
			}
		return true;
	}
	
	public void deleteLcture(LecturesEntity lecturesEntity) {
		lecturesDao.delete(lecturesEntity);
	}
	
	
	protected FacesMessage constructInfoMessage(String message,String detail)
	{
		return new FacesMessage(FacesMessage.SEVERITY_INFO,message,detail);
	}
	protected FacesMessage constructErrorMessage(String message,String detail)
	{
		return new FacesMessage(FacesMessage.SEVERITY_ERROR,message,detail);
	}
	protected FacesMessage constructFatalMessage(String message,String detail)
	{
	      return new FacesMessage(FacesMessage.SEVERITY_FATAL,message,detail);	
	}
	
	FacesContext getFacesContext()
	{
		return FacesContext.getCurrentInstance();
	}

	public LecturesDao getLecturesDao() {
		return lecturesDao;
	}

	public void setLecturesDao(LecturesDao lecturesDao) {
		this.lecturesDao = lecturesDao;
	}

	public CoursesDao getCoursesDao() {
		return coursesDao;
	}

	public void setCoursesDao(CoursesDao coursesDao) {
		this.coursesDao = coursesDao;
	}


}
