package com.deemsys.project.jobcategory;

import java.util.List;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.JobCategory;
/**
 * 
 * @author Deemsys
 *
 */
public interface JobCategoryDAO extends IGenericDAO<JobCategory>{
	public List<JobCategory> getJobCategoryListForUser();
}
