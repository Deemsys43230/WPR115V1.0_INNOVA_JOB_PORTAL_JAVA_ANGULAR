package com.deemsys.project.jobtagmap;

import java.util.List;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.JobTagMap;
/**
 * 
 * @author Deemsys
 *
 */
public interface JobTagMapDAO extends IGenericDAO<JobTagMap>{
	public List<JobTagMap> getJobTagMapByJobId(Long jobId);
	public void deleteJobTagMapByJobId(Long jobId);
}
