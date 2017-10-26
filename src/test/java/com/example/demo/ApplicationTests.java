package com.example.demo;

import com.example.demo.pojo.Person;
import com.example.demo.service.AsyncTaskService;
import com.example.demo.service.PersonService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.Future;

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
//		personService.insertPerson("bbb", 22);
//        Person u = personService.findById(3l);
//        System.out.println(u.toString());
//        Assert.assertEquals(21, u.getAge());
	}



    @Test
    @Rollback
    public void redis() throws Exception {
        // 保存字符串
        redisTemplate.opsForValue().set("aaa", new Person(10l,"name", 29));
//        System.out.println(redisTemplate.opsForValue().get("aaa"));
//        Assert.assertEquals("111", redisTemplate.opsForValue().get("aaa"));
    }

    @Autowired
    private AsyncTaskService asyncTaskService;
	@Test
    public void async() throws Exception {
        long start = System.currentTimeMillis();
        Future<String> task1 = asyncTaskService.doTaskOne();
        Future<String> task2 = asyncTaskService.doTaskTwo();
        Future<String> task3 = asyncTaskService.doTaskThree();
        while(true) {
            if(task1.isDone() && task2.isDone() && task3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
            Thread.sleep(1000);
        }
        long end = System.currentTimeMillis();
        System.out.println("任务全部完成，总耗时：" + (end - start) + "毫秒");

    }
}



