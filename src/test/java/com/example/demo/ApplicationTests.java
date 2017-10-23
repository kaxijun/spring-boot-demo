package com.example.demo;

import com.example.demo.pojo.Person;
import com.example.demo.service.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;

	@Test
	@Rollback(true) // default true
	public void findByName() throws Exception {
		personService.insertPerson("bbb", 22);
        Person u = personService.findById(3l);
        System.out.println(u.toString());
//        Assert.assertEquals(21, u.getAge());
	}



    @Test
    public void test() throws Exception {
        // 保存字符串
        redisTemplate.opsForValue().set("aaa", new Person(10l,"name", 29));
        System.out.println(redisTemplate.opsForValue().get("aaa"));
//        Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));
    }

	@Test
    public void Redis() throws Exception {

    }
}



