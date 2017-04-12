package com.example.j2eeapp.services;

import java.util.List;

import javax.faces.model.SelectItem;

import com.example.j2eeapp.domain.LecturesEntity;




public interface LecturesService {
	
	boolean createLecture(LecturesEntity lecturesEntity, String lectureTopicName);
	List<SelectItem> loadLectureNumber();
	List<LecturesEntity> loadAllLectures();
	boolean updateLecture(LecturesEntity  lecturesEntity);
	void deleteLcture(LecturesEntity lecturesEntity);
	

}
