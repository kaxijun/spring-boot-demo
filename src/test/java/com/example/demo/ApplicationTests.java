package com.example.demo;

import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ApplicationTests {

	@Test
	public void contextLoads() {

	}

	@Autowired
	private PersonService personService;

	@Test
	@Rollback
	public void findByName() throws Exception {
		personService.insertPerson("AAA", 20);
		Person u = personService.findById(2l);
		Assert.assertEquals(20, u.getAge());
	}
}



