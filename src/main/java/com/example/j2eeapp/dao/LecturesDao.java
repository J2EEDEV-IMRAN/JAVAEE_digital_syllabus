package com.example.j2eeapp.dao;

import java.util.List;

import javax.faces.model.SelectItem;

import com.example.j2eeapp.commons.dao.GenericDao;
import com.example.j2eeapp.domain.LecturesEntity;

public interface LecturesDao extends GenericDao<LecturesEntity, Long>
{
	List<SelectItem> getLectures();
	boolean checkAvailable(String lectureTopicName);
}
