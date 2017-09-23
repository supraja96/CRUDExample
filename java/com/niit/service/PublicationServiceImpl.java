package com.niit.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.PublicationDao;
import com.niit.model.Publication;


@Service("publicationService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class PublicationServiceImpl implements PublicationService {

	@Autowired
	private PublicationDao publicationDao;
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPublication(Publication publication) {
		publicationDao.addPublication(publication);
	}

	public List<Publication> getPublications() {
		return publicationDao.getPublications();
	}

	public Publication getPublication(int pubId) {
		return publicationDao.getPublication(pubId);
	}

	public void deletePublication(int pubId) {
		publicationDao.deletePublication(pubId);
	}

}
