package com.niit.service;
import java.util.List;

import com.niit.model.Publication;

public interface PublicationService {
	
	public void addPublication(Publication publication);
	
	public List<Publication> getPublications();
	
	public Publication getPublication(int pubId);
	
	public void deletePublication(int pubId);
}
