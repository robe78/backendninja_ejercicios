package com.udemy.backendninja.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);

	public List<Person> getListPeople() {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Roberto", 40));
		people.add(new Person("Dimas", 30));
		people.add(new Person("Costa", 20));
		people.add(new Person("Antunez", 10));
		LOG.info("HOLA DESDE EL SERVICIO");
		return people;	
	}



}
