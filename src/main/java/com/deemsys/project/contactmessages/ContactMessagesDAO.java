package com.deemsys.project.contactmessages;

import com.deemsys.project.common.IGenericDAO;
import com.deemsys.project.entity.ContactMessages;
import com.deemsys.project.entity.EmployerMessages;
/**
 * 
 * @author Deemsys
 *
 */
public interface ContactMessagesDAO extends IGenericDAO<ContactMessages>{
	public int getUnreadMessageCount();
}
