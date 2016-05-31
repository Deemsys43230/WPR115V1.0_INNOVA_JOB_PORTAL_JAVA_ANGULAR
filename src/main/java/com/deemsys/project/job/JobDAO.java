package com.deemsys.project.job;

import java.util.List;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.Job;
/**
 * 
 * @author Deemsys
 *
 */
public interface JobDAO extends IGenericDAO<Job>{
  public Job getJobById(Long jobId);
  public List<Job> getAllJobsForUser();
  public List<Job> searchJobs(JobSearchForm jobSearchForm);
  public void deleteJobById(Long jobId);
  public List<Job> getJobListByCategoryId(Integer categoryId);
  public boolean checkJobTitle(Long jobId,String name);
}
