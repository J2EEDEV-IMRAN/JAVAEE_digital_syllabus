package com.example.j2eeapp.services.impl;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import com.example.j2eeapp.dao.CoursesDao;
import com.example.j2eeapp.dao.LabExamplesDao;
import com.example.j2eeapp.domain.CoursesEntity;
import com.example.j2eeapp.domain.LabExamplesEntity;
import com.example.j2eeapp.services.LabExamplesService;

public class LabExamplesServicesImpl implements LabExamplesService {
	
	LabExamplesDao labExamplesDao;
	CoursesDao coursesDao;
	public LabExamplesServicesImpl(LabExamplesDao labExamplesDao,CoursesDao coursesDao) {
		super();
		this.labExamplesDao = labExamplesDao;
		this.coursesDao = coursesDao;
	}
	
	
	public boolean createLabExamples(LabExamplesEntity labExamplesEntity,String courseCode)
	{
		try {	
			CoursesEntity coursesEntity =coursesDao.loadCourseByCourseCode(courseCode);
			labExamplesEntity.setCoursesEntity(coursesEntity);
			labExamplesDao.save(labExamplesEntity);
		} 
		catch (Exception e) {
		   FacesMessage message=constructErrorMessage(e.getMessage(), null);
			getFacesContext().addMessage(null,message);
			return false;
		 }
		return true;
	}
	
	
	public List<LabExamplesEntity> loadAllLabs() {
		List<LabExamplesEntity> examples = labExamplesDao.findAll();
		return examples;
	}
	
	public boolean updateLabExample(LabExamplesEntity labExamplesEntity) {
		try {
			labExamplesDao.update(labExamplesEntity);
			} 
			catch (Exception e) {
				FacesMessage message=constructFatalMessage(e.getMessage(), null);
				getFacesContext().addMessage(null, message);
				return false;
				
			}
		return true;
	}
	
	public void deleteLabExample(LabExamplesEntity labExamplesEntity)
	{
		labExamplesDao.delete(labExamplesEntity);
		
	}
	
	
	protected FacesMessage constructErrorMessage(String message,String details)
	{
		 return new FacesMessage(FacesMessage.SEVERITY_ERROR,message,details);
	}

	protected FacesMessage constructFatalMessage(String message,String details)
	{
		 return new FacesMessage(FacesMessage.SEVERITY_FATAL,message,details);
	}
	protected FacesMessage constructInfoMessage(String message,String details)
	{
		return new FacesMessage(FacesMessage.SEVERITY_INFO,message,details);
	}
	
	FacesContext getFacesContext()
	{
		return FacesContext.getCurrentInstance();
	}
	
	public LabExamplesDao getLabExamplesDao() {
		return labExamplesDao;
	}
	public void setLabExamplesDao(LabExamplesDao labExamplesDao) {
		this.labExamplesDao = labExamplesDao;
	}
	public CoursesDao getCoursesDao() {
		return coursesDao;
	}
	public void setCoursesDao(CoursesDao coursesDao) {
		this.coursesDao = coursesDao;
	}





	

}
