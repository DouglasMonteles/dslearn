package com.devsuperior.dslearn.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.devsuperior.dslearn.entities.pk.EnrollmentPK;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK();

	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollmentMoment;
	
	@Column(nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	
	@Column(nullable = false)
	private Boolean available;
	
	@Column(nullable = false)
	private Boolean onlyUpdate;
	
	@ManyToMany(mappedBy = "enrollmentsDone")
	private Set<Lesson> lessonsDone = new HashSet<>();
	
	public Enrollment() {}

	public Enrollment(User suer, Offer offer, Instant enrollmentMoment, Instant refundMoment, Boolean available, Boolean onlyUpdate) {
		super();
		this.id.setUser(suer);
		this.id.setOffer(offer);
		this.enrollmentMoment = enrollmentMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

	public User getStudent() {
		return id.getUser();
	}
	
	public void setStudent(User user) {
		this.id.setUser(user);
	}
	
	public Offer getOffer() {
		return id.getOffer();
	}
	
	public void setOffer(Offer offer) {
		this.id.setOffer(offer);
	}

	public Instant getEnrollmentMoment() {
		return enrollmentMoment;
	}

	public void setEnrollmentMoment(Instant enrollmentMoment) {
		this.enrollmentMoment = enrollmentMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Boolean getOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(Boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	public Set<Lesson> getLessonsDone() {
		return lessonsDone;
	}

	public void addLessonDone(Lesson lessonDone) {
		this.lessonsDone.add(lessonDone);
	}
	
}
