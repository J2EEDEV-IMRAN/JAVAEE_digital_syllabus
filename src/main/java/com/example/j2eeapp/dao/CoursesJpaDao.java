package com.example.j2eeapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.util.Assert;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.CoursesEntity;

public class CoursesJpaDao extends GenericJpaDao<CoursesEntity, Long> implements CoursesDao {

	public CoursesJpaDao() 
	{
		super(CoursesEntity.class);
	}

	public boolean checkAvailable(String courseCode) {
		Assert.notNull(courseCode);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
		
		Query query = getEntityManager()
			.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
					+ " c where c.courseCode = :courseCode").setParameter("courseCode", courseCode);
		
		Long count = (Long) query.getSingleResult();
		
		return count < 1;
	}
	
private List<SelectItem> creditOptions;
	
	public List<SelectItem> getCreditOptions()
	{
		if(creditOptions==null)
		{
			creditOptions=new ArrayList<SelectItem>();
			creditOptions.add(new SelectItem(new Float((float)0.50), "0.50" ));
			creditOptions.add(new SelectItem(new Float((float)0.75), "0.75" ));
			creditOptions.add(new SelectItem(new Float((float)1.0), "1.0" ));
			creditOptions.add(new SelectItem(new Float((float)1.25), "1.25" ));
			creditOptions.add(new SelectItem(new Float((float)1.50), "1.50" ));
			creditOptions.add(new SelectItem(new Float((float)1.75), "1.75" ));
			creditOptions.add(new SelectItem(new Float((float)2.0), "2.0" ));
			creditOptions.add(new SelectItem(new Float((float)2.75), "2.75" ));
			creditOptions.add(new SelectItem(new Float((float)3.0), "3.0" ));
		}
		return creditOptions;	
	}
	
	private List<SelectItem> courseTypeOptions;
	public List<SelectItem> getCourseTypesOptions()
	{
		 if(courseTypeOptions==null)
		 {
			 courseTypeOptions=new ArrayList<SelectItem>();
			 courseTypeOptions.add(new SelectItem(new String(("Theoritical"))));
			 courseTypeOptions.add(new SelectItem(new String(("Lab"))));
		 }
		 return courseTypeOptions;
	}
	
	private List<SelectItem> courseCreditHours;
	public List<SelectItem> getCourseCreditHoursOption() {
		if(courseCreditHours==null)
		 {
			courseCreditHours=new ArrayList<SelectItem>();
			courseCreditHours.add(new SelectItem(new Float((float)0.50), "0.50" ));
			courseCreditHours.add(new SelectItem(new Float((float)0.75), "0.75" ));
			courseCreditHours.add(new SelectItem(new Float((float)1.0), "1.0" ));
			courseCreditHours.add(new SelectItem(new Float((float)1.25), "1.25" ));
			courseCreditHours.add(new SelectItem(new Float((float)1.50), "1.50" ));
			courseCreditHours.add(new SelectItem(new Float((float)1.75), "1.75" ));
			courseCreditHours.add(new SelectItem(new Float((float)2.0), "2.0" ));
			courseCreditHours.add(new SelectItem(new Float((float)2.75), "2.75" ));
			courseCreditHours.add(new SelectItem(new Float((float)3.0), "3.0" ));
		 }
		 return courseCreditHours;
	}
	
	private List<SelectItem> courseYears;
	public List<SelectItem> getCourseYear() {
		if(courseYears==null)
		 {
			courseYears=new ArrayList<SelectItem>();
			courseYears.add(new SelectItem(new Integer(1), "1" ));
			courseYears.add(new SelectItem(new Integer(2), "2" ));
			courseYears.add(new SelectItem(new Integer(3), "3" ));
			courseYears.add(new SelectItem(new Integer(4), "4" ));
		 }
		 return courseYears;
	}

	private List<SelectItem> courseTerms;
	public List<SelectItem> getCourseTerm() {
		if(courseTerms==null)
		 {
			courseTerms=new ArrayList<SelectItem>();
			courseTerms.add(new SelectItem(new Integer(1), "1" ));
			courseTerms.add(new SelectItem(new Integer(2), "2" ));
		 }
		 return courseTerms;
	}

	public CoursesEntity loadCourseByCourseCode(String courseCode) {
       Assert.notNull(courseCode);
		
       CoursesEntity course = null;
		
		Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
				+ " u where u.courseCode = :courseCode").setParameter("courseCode", courseCode);
		
		try {
			course = (CoursesEntity) query.getSingleResult();
		} catch(NoResultException e) {
			//do nothing
		}
		
		return course;
	}

	@SuppressWarnings("unchecked")
	public List<CoursesEntity> getFirstFCourses() {
		
		 List<CoursesEntity> courseff = null;
		 Integer year=1;
		 Integer term=1;
			
			
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.courseYear = :year and u.courseTerm=:term").setParameter("year", year).setParameter("term", term);
			
			try {
				courseff = (List<CoursesEntity>) query.getResultList();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return courseff;
	}

	@SuppressWarnings("unchecked")
	public List<CoursesEntity> getFirstSCourses() {
		 List<CoursesEntity> coursefs = null;
		 
		 Integer year=1;
		 Integer term=2;
			
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.courseYear = :year and u.courseTerm=:term").setParameter("year", year).setParameter("term",  term);
			
			try {
				coursefs = (List<CoursesEntity>) query.getResultList();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return coursefs;
	}

	@SuppressWarnings("unchecked")
	public List<CoursesEntity> getSecondFCourses() {
		 List<CoursesEntity> coursesf = null;
		 
		 Integer year=2;
		 Integer term=1;
			
			
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.courseYear = :year and u.courseTerm=:term").setParameter("year", year).setParameter("term", term);
			
			try {
				coursesf = (List<CoursesEntity>) query.getResultList();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return coursesf;
	}

	@SuppressWarnings("unchecked")
	public List<CoursesEntity> getSecondSCourses() {
		 List<CoursesEntity> coursess = null;
		 
		 Integer year=2;
		 Integer term=2;
			
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.courseYear = :year and u.courseTerm=:term").setParameter("year", year).setParameter("term", term);
			
			try {
				coursess = (List<CoursesEntity>) query.getResultList();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return coursess;
	}

	@SuppressWarnings("unchecked")
	public List<CoursesEntity> getThirdFCourses() {
         List<CoursesEntity> coursetf = null;
         Integer year=3;
		 Integer term=1;
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.courseYear = :year and u.courseTerm=:term").setParameter("year", year).setParameter("term", term);
			
			try {
				coursetf = (List<CoursesEntity>) query.getResultList();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return coursetf;
	}

	@SuppressWarnings("unchecked")
	public List<CoursesEntity> getThirdSCourses() {
        List<CoursesEntity> coursets = null;
         Integer year=3;
		 Integer term=2;
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.courseYear = :year and u.courseTerm=:term").setParameter("year", year).setParameter("term", term);
			
			try {
				coursets = (List<CoursesEntity>) query.getResultList();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return coursets;
	}

	@SuppressWarnings("unchecked")
	public List<CoursesEntity> getFourthFCourses() {
            List<CoursesEntity> courseff = null;
		
            Integer year=4;
   		 Integer term=1;
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.courseYear = :year and u.courseTerm=:term").setParameter("year", year).setParameter("term", term);
			
			try {
				courseff = (List<CoursesEntity>) query.getResultList();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return courseff;
	}

	@SuppressWarnings("unchecked")
	public List<CoursesEntity> getFourthSCourses() {
           List<CoursesEntity> coursefs = null;
           Integer year=4;
  		 Integer term=2;
			Query query = getEntityManager().createQuery("select u from " + getPersistentClass().getSimpleName()
					+ " u where u.courseYear = :year and u.courseTerm=:term").setParameter("year", year).setParameter("term", term);
			
			try {
				coursefs = (List<CoursesEntity>) query.getResultList();
			} catch(NoResultException e) {
				//do nothing
			}
			
			return coursefs;
	}



}
