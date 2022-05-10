package com.devsuperior.dslearn.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_reply")
public class Reply implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String body;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;
	
	@ManyToOne
	@JoinColumn(name = "topic_id", nullable = false)
	private Topic topic;
	
	@ManyToMany
	@JoinTable(
			name = "tb_reply_likes",
			joinColumns = @JoinColumn(name = "reply_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
	)
	private List<User> likes = new ArrayList<>();
	
	public Reply() {}

	public Reply(Long id, String body, Instant moment, User author, Topic topic) {
		super();
		this.id = id;
		this.body = body;
		this.moment = moment;
		this.author = author;
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public List<User> getLikes() {
		return likes;
	}

	public void addLike(User like) {
		this.likes.add(like);
	}
	
}
