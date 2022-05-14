package com.devsuperior.dslearn.dtos;

import java.io.Serializable;
import java.time.Instant;

import com.devsuperior.dslearn.entities.Notification;

public class NotificationDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String text;
	
	private Instant moment;
	
	private Boolean read;
	
	private String route;
	
	private Long userId;
	
	public NotificationDto() {}

	public NotificationDto(Long id, String text, Instant moment, Boolean read, String route, Long userId) {
		super();
		this.id = id;
		this.text = text;
		this.moment = moment;
		this.read = read;
		this.route = route;
		this.userId = userId;
	}
	
	public NotificationDto(Notification notif) {
		super();
		this.id = notif.getId();
		this.text = notif.getText();
		this.moment = notif.getMoment();
		this.read = notif.isRead();
		this.route = notif.getRoute();
		this.userId = notif.getUser().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
}
