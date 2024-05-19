package com.spring.security.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.model.Subscriber;
import com.spring.security.repository.SubscriberRepository;
import com.spring.security.service.SubscriberService;

@Service
public class SubcriberServiceImpl implements SubscriberService{

	@Autowired
	private SubscriberRepository subRepo;
	
	@Override
	public void SubscriberEmail(Subscriber subscriber) {
		subRepo.save(subscriber);
		
	}

}
