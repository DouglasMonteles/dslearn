package com.devsuperior.dslearn.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslearn.dtos.NotificationDto;
import com.devsuperior.dslearn.services.NotificationService;

@RestController
@RequestMapping(value = "/notifications")
public class NotificationResource {

	@Autowired
	private NotificationService notificationService;
	
	@GetMapping
	public ResponseEntity<Page<NotificationDto>> notificationsForCurrentUser(Pageable pageable) {
		var notificationsDto = this.notificationService.notificationsForCurrentUser(pageable);
		return ResponseEntity.ok().body(notificationsDto);
	}
	
}
