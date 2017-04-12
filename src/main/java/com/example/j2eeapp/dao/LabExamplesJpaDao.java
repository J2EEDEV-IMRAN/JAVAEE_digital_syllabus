package com.example.j2eeapp.dao;

import com.example.j2eeapp.commons.dao.GenericJpaDao;
import com.example.j2eeapp.domain.LabExamplesEntity;

public class LabExamplesJpaDao extends GenericJpaDao<LabExamplesEntity, Long> implements LabExamplesDao
{

	public LabExamplesJpaDao() 
	{
		super(LabExamplesEntity.class);
	}

	
}
