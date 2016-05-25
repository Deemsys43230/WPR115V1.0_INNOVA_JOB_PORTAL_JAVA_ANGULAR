package com.deemsys.project.resumedetail;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.ResumeDetail;
/**
 * 
 * @author Deemsys
 *
 */
public interface ResumeDetailDAO extends IGenericDAO<ResumeDetail>{

	public ResumeDetail get(String id);

	public void delete(String id);
	
}
