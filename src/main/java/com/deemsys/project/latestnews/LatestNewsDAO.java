package com.deemsys.project.latestnews;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.LatestNews;
/**
 * 
 * @author Deemsys
 *
 */
public interface LatestNewsDAO extends IGenericDAO<LatestNews>{
	public LatestNews getLatestNewsById(Long latestNewsId);
}
