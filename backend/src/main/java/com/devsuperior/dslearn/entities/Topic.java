package com.devsuperior.dslearn.entities;

import java.io.Serializable;
import java.time.Instant;
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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_topic")
public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String title;
	
	@Column(nullable = false, columnDefinition = "TEXT")
	private String body;
	
	@Column(nullable = false, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	
	@ManyToOne
	@JoinColumn(name = "author_id", nullable = false)
	private User author;
	
	@ManyToMany
	@JoinTable(
			name = "tb_topic_likes",
			joinColumns = @JoinColumn(name = "topic_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "user_id", nullable = false)
	)
	private Set<User> likes = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	@ManyToOne
	@JoinColumn(name = "lesson_id")
	private Lesson lesson;
	
	@ManyToOne
	@JoinColumn(name = "answer_id", nullable = true)
	private Reply answer;
	
	@OneToMany(mappedBy = "topic")
	private List<Reply> replies = new ArrayList<>();
	
	public Topic() {}

	public Topic(Long id, String title, String body, Instant moment, User author, 
			Offer offer, Lesson lesson, Reply answer) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.moment = moment;
		this.author = author;
		this.offer = offer;
		this.lesson = lesson;
		this.answer = answer;
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

	public Set<User> getLikes() {
		return likes;
	}

	public void addLike(User like) {
		this.likes.add(like);
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public Lesson getLesson() {
		return lesson;
	}

	public void setLesson(Lesson lesson) {
		this.lesson = lesson;
	}

	public Reply getAnswer() {
		return answer;
	}

	public void setAnswer(Reply answer) {
		this.answer = answer;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void addReply(Reply reply) {
		this.replies.add(reply);
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
		Topic other = (Topic) obj;
		return Objects.equals(id, other.id);
	}
	
}
