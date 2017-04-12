package com.example.j2eeapp.dao;


import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.util.Assert;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.LecturesEntity;

public class LecturesJpaDao extends GenericJpaDao<LecturesEntity, Long>  implements LecturesDao {
	
	Session session;
	
	public LecturesJpaDao() {
		super(LecturesEntity.class);
	}
	
	public boolean checkAvailable(String lectureTopicName) {
		Assert.notNull(lectureTopicName);  // it checks whether the passed variable is empty or not (Assert class is from spring famework)
		
		Query query = getEntityManager()
			.createQuery("select count(*) from " + getPersistentClass().getSimpleName() 
					+ " c where c.lectureTopicName = :lectureTopicName").setParameter("lectureTopicName", lectureTopicName);
		
		Long count = (Long) query.getSingleResult();
		
		return count < 1;
	}

	private List<SelectItem> lectureOptions;

	public List<SelectItem> getLectures() {
		
		if(lectureOptions==null)
		{
			lectureOptions=new ArrayList<SelectItem>();
			lectureOptions.add(new SelectItem(new Integer(1),"1"));
			lectureOptions.add(new SelectItem(new Integer(2),"2"));
			lectureOptions.add(new SelectItem(new Integer(3),"3"));
			lectureOptions.add(new SelectItem(new Integer(4),"4"));
			lectureOptions.add(new SelectItem(new Integer(5),"5"));
			lectureOptions.add(new SelectItem(new Integer(6),"6"));
			lectureOptions.add(new SelectItem(new Integer(7),"7"));
			lectureOptions.add(new SelectItem(new Integer(8),"8"));
			lectureOptions.add(new SelectItem(new Integer(9),"9"));
			lectureOptions.add(new SelectItem(new Integer(10),"10"));
		}
	
		return lectureOptions;
	}
	
	


	
}
