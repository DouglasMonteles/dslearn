package com.devsuperior.dslearn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslearn.dtos.NotificationDto;
import com.devsuperior.dslearn.repositories.NotificationRepository;

@Service
public class NotificationService {

	@Autowired
	private NotificationRepository notificationRepository;
	
	@Autowired
	private AuthService authService;
	
	@Transactional(readOnly = true)
	public Page<NotificationDto> notificationsForCurrentUser(Pageable pageable) {
		var user = this.authService.authenticaded();
		var page = this.notificationRepository.findByUser(user, pageable);
		
		return page.map(notif -> new NotificationDto(notif));
	}
	
}
