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
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED)
public class ApplicationTests {

	@Autowired
	private PersonService personService;

	@Test
	@Rollback(true) // default true
	public void findByName() throws Exception {
		personService.insertPerson("bbb", 22);
        Person u = personService.findById(3l);
        System.out.println(u.toString());
        Assert.assertEquals(21, u.getAge());
	}
}



