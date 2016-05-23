package com.deemsys.project.documentType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deemsys.project.entity.DocumentType;
/**
 * 
 * @author Deemsys
 *
 * DocumentType 	 - Entity
 * documentType 	 - Entity Object
 * documentTypes 	 - Entity List
 * documentTypeDAO   - Entity DAO
 * documentTypeForms - EntityForm List
 * DocumentTypeForm  - EntityForm
 *
 */
@Service
@Transactional
public class DocumentTypeService {

	@Autowired
	DocumentTypeDAO documentTypeDAO;
	
	//Get All Entries
	public List<DocumentTypeForm> getDocumentTypeList()
	{
		List<DocumentTypeForm> documentTypeForms=new ArrayList<DocumentTypeForm>();
		
		List<DocumentType> documentTypes=new ArrayList<DocumentType>();
		
		documentTypes=documentTypeDAO.getAll();
		
		for (DocumentType documentType : documentTypes) {
			//TODO: Fill the List
			documentTypeForms.add(new DocumentTypeForm(documentType.getDocTypeId(), documentType.getDocTypeName(), documentType.getDocPrefix(), documentType.getDescription(), documentType.getStatus()));
		}
		
		return documentTypeForms;
	}
	
	//Get Particular Entry
	public DocumentTypeForm getDocumentType(Integer getId)
	{
		DocumentType documentType=new DocumentType();
		
		documentType=documentTypeDAO.get(getId);
		
		//TODO: Convert Entity to Form
		//Start
		DocumentTypeForm documentTypeForm=new DocumentTypeForm();
		if(documentType!=null)
		documentTypeForm=new DocumentTypeForm(documentType.getDocTypeId(), documentType.getDocTypeName(), documentType.getDocPrefix(), documentType.getDescription(), documentType.getStatus());
		
		//End
		
		return documentTypeForm;
	}
	
	//Merge an Entry (Save or Update)
	public int mergeDocumentType(DocumentTypeForm documentTypeForm)
	{
		//TODO: Convert Form to Entity Here
		
		//Logic Starts
		
		DocumentType documentType=new DocumentType(documentTypeForm.getDocTypeName(), documentTypeForm.getDocPrefix(), documentTypeForm.getDescription(), documentTypeForm.getStatus());
		documentType.setDocTypeId(documentTypeForm.getDocTypeId());
		//Logic Ends
		
		
		documentTypeDAO.merge(documentType);
		return 1;
	}
	
	//Save an Entry
	public int saveDocumentType(DocumentTypeForm documentTypeForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		DocumentType documentType=new DocumentType();
		
		//Logic Ends
		
		documentTypeDAO.save(documentType);
		return 1;
	}
	
	//Update an Entry
	public int updateDocumentType(DocumentTypeForm documentTypeForm)
	{
		//TODO: Convert Form to Entity Here	
		
		//Logic Starts
		
		DocumentType documentType=new DocumentType();
		
		//Logic Ends
		
		documentTypeDAO.update(documentType);
		return 1;
	}
	
	//Delete an Entry
	public int deleteDocumentType(Integer id)
	{
		documentTypeDAO.delete(id);
		return 1;
	}
	
	
	
}
