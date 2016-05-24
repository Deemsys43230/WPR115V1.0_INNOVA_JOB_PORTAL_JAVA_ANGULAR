package com.deemsys.project.jobtag;

import java.util.List;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.JobTag;
/**
 * 
 * @author Deemsys
 *
 */
public interface JobTagDAO extends IGenericDAO<JobTag>{
	public List<JobTag> getJobTagByJobId(Long jobId);
	public void deleteJobTagByJobId(Long jobId);
}
