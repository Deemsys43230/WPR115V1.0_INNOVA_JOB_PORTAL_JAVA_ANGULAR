package com.deemsys.project.jobSeeker;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.JobSeeker;
/**
 * 
 * @author Deemsys
 *
 */
public interface JobSeekerDAO extends IGenericDAO<JobSeeker>{

	public JobSeeker get(String id);

	public void delete(String id);

}
