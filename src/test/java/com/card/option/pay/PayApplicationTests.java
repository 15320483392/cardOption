package com.card.option.pay;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
class PayApplicationTests {

    @Before
    public void init(){
        log.info("---------------测试开始----------------");
    }

    @After
    public void after(){
        log.info("---------------测试结束----------------");
    }

    @Test
    void contextLoads() {
    }

}
