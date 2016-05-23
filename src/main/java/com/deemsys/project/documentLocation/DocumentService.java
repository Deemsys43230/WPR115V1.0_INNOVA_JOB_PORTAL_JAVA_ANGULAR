package com.deemsys.project.documentLocation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.DocumentLocation;
/**
 * 
 * @author Deemsys
 *
 * DocumentLocation 	 - Entity
 * documentLocation 	 - Entity Object
 * documentLocations 	 - Entity List
 * documentLocationDAO   - Entity DAO
 * documentLocationForms - EntityForm List
 * DocumentLocationForm  - EntityForm
 *
 */
@Service
@Transactional
public class DocumentService {

	@Autowired
	DocumentLocationDAO documentLocationDAO;
	
	//Get All Entries
	public List<DocumentLocationForm> getDocumentLocationList()
	{
		List<DocumentLocationForm> documentLocationForms=new ArrayList<DocumentLocationForm>();
		
		List<DocumentLocation> documentLocations=new ArrayList<DocumentLocation>();
		
		documentLocations=documentLocationDAO.getAll();
		
		for (DocumentLocation documentLocation : documentLocations) {
			//TODO: Fill the List
			documentLocationForms.add(new DocumentLocationForm(documentLocation.getDocLocationId(), documentLocation.getDocLocation(), documentLocation.getDescription(), documentLocation.getStatus()));
		}
		
		return documentLocationForms;
	}
	
	//Get Particular Entry
	public DocumentLocationForm getDocumentLocation(Integer getId)
	{
		DocumentLocation documentLocation=new DocumentLocation();
		
		documentLocation=documentLocationDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		DocumentLocationForm documentLocationForm=new DocumentLocationForm();
		if(documentLocation!=null){
			documentLocationForm=new DocumentLocationForm(documentLocation.getDocLocationId(), documentLocation.getDocLocation(), documentLocation.getDescription(), documentLocation.getStatus());
		}
		
		
		//End
		return documentLocationForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeDocumentLocation(DocumentLocationForm documentLocationForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		DocumentLocation documentLocation=new DocumentLocation(documentLocationForm.getDocLocation(),documentLocationForm.getDescription(),documentLocationForm.getStatus());
		documentLocation.setDocLocationId(documentLocationForm.getDocLocationId());
		
		//Logic Ends
		
		
		documentLocationDAO.merge(documentLocation);
		return 1;
	}
	
	//Save an Entry
	public int saveDocumentLocation(DocumentLocationForm documentLocationForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		DocumentLocation documentLocation=new DocumentLocation();
		
		//Logic Ends
		
		documentLocationDAO.save(documentLocation);
		return 1;
	}
	
	//Update an Entry
	public int updateDocumentLocation(DocumentLocationForm documentLocationForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		DocumentLocation documentLocation=new DocumentLocation();
		
		//Logic Ends
		
		documentLocationDAO.update(documentLocation);
		return 1;
	}
	
	//Delete an Entry
	public int deleteDocumentLocation(Integer id)
	{
		documentLocationDAO.delete(id);
		return 1;
	}
	
	
	
}
