package com.devsuperior.dslearn.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dslearn.entities.enums.ResourceType;

@Entity
@Table(name = "tb_resource")
public class Resource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 30, nullable = false)
	private String title;
	
	@Column(length = 255, nullable = false)
	private String description;
	
	@Column(nullable = false)
	private Integer position;
	
	@Column(length = 255, nullable = false)
	private String imgUrl;
	
	@Column(nullable = false)
	private ResourceType type;
	
	@Column(nullable = true)
	private String externalLink;
	
	@ManyToOne
	@JoinColumn(name = "offer_id", nullable = false)
	private Offer offer;
	
	@OneToMany(mappedBy = "resource")
	private List<Section> sections = new ArrayList<>();
	
	public Resource() {}

	public Resource(Long id, String title, String description, Integer position, String imgUrl, ResourceType type,
			String externalLink, Offer offer) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.position = position;
		this.imgUrl = imgUrl;
		this.type = type;
		this.externalLink = externalLink;
		this.setOffer(offer);
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPosition() {
		return position;
	}

	public void setPosition(Integer position) {
		this.position = position;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public ResourceType getType() {
		return type;
	}

	public void setType(ResourceType type) {
		this.type = type;
	}

	public String getExternalLink() {
		return externalLink;
	}

	public void setExternalLink(String externalLink) {
		this.externalLink = externalLink;
	}

	public Offer getOffer() {
		return offer;
	}

	public void setOffer(Offer offer) {
		this.offer = offer;
	}
	
	public List<Section> getSections() {
		return sections;
	}
	
	public void addSection(Section section) {
		this.sections.add(section);
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
		Resource other = (Resource) obj;
		return Objects.equals(id, other.id);
	}
	
}
