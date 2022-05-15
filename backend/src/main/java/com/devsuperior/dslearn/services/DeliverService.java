package com.devsuperior.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearn.dtos.DeliverRevisionDto;
import com.devsuperior.dslearn.repositories.DeliverRepository;

@Service
public class DeliverService {

	@Autowired
	private DeliverRepository deliverRepository;
	
	@Transactional
	public void saveRevision(Long id, DeliverRevisionDto revisionDto) {
		var deliver = this.deliverRepository.getById(id);
		
		deliver.setStatus(revisionDto.getStatus());
		deliver.setFeedback(revisionDto.getFeedback());
		deliver.setCorrectCount(revisionDto.getCorrectCount());
		
		this.deliverRepository.save(deliver);
	}
	
}
