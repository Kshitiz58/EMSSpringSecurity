package com.spring.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.security.model.Subscriber;

public interface SubscriberRepository extends JpaRepository<Subscriber, Integer>{

}
