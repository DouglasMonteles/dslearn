package com.devsuperior.dslearn.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_lesson")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Lesson implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String title;
	
	@Column(nullable = false)
	private Integer position;
	
	@ManyToOne
	@JoinColumn(name = "section_id", nullable = false)
	private Section section;
	
	@ManyToMany
	@JoinTable(
			name = "tb_lessons_done",
			joinColumns = @JoinColumn(name = "lesson_id"),
			inverseJoinColumns = {
					@JoinColumn(name = "user_id", nullable = false),
					@JoinColumn(name = "offer_id", nullable = false),
			}
	)
	private Set<Enrollment> enrollmentsDone = new HashSet<>();
	
	@OneToMany(mappedBy = "lesson")
	private List<Topic> topics = new ArrayList<>();
	
	@OneToMany(mappedBy = "lesson")
	private List<Deliver> deliveries = new ArrayList<>();
	
	public Lesson() {}

	public Lesson(Long id, String title, Integer position, Section section) {
		super();
		this.id = id;
		this.title = title;
		this.position = position;
		this.section = section;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Set<Enrollment> getEnrollmentsDone() {
		return enrollmentsDone;
	}
	
	public void addEnrollmentDone(Enrollment enrollment) {
		this.enrollmentsDone.add(enrollment);
	}
	
	public List<Deliver> getDeliveries() {
		return deliveries;
	}

	public void addDeliver(Deliver deliver) {
		this.deliveries.add(deliver);
	}
	
	public List<Topic> getTopics() {
		return topics;
	}

	public void addTopic(Topic topic) {
		this.topics.add(topic);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lesson other = (Lesson) obj;
		return Objects.equals(id, other.id);
	}
	
}
