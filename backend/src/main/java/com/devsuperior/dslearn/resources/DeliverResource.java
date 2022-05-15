package com.devsuperior.dslearn.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearn.dtos.DeliverRevisionDto;
import com.devsuperior.dslearn.services.DeliverService;

@RestController
@RequestMapping(value = "/deliveries")
public class DeliverResource {

	@Autowired
	private DeliverService deliverService;
	
	@PutMapping(value = "/{id}")
	@PreAuthorize(value = "hasAnyRole('ADMIN', 'INSTRUCTOR')")
	public ResponseEntity<Void> saveRevision(@PathVariable Long id, 
			@RequestBody DeliverRevisionDto revisionDto) {
		this.deliverService.saveRevision(id, revisionDto);
		return ResponseEntity.noContent().build();
	}
	
}
