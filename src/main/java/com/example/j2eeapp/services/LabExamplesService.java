package com.example.j2eeapp.services;

import java.util.List;
import com.example.j2eeapp.domain.LabExamplesEntity;

public interface LabExamplesService {
	boolean createLabExamples(LabExamplesEntity labExamplesEntity,String courseCode);
	List<LabExamplesEntity> loadAllLabs();
	boolean updateLabExample(LabExamplesEntity labExamplesEntity);
	void deleteLabExample(LabExamplesEntity labExamplesEntity);
}
