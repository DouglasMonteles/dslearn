package com.devsuperior.dslearn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.dslearn.entities.Notification;

@Repository
public interface LessonRepository extends JpaRepository<Notification, Long> {

}
