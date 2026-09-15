package com.june;

import com.june.Mapper.t_UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringTest {
    @Autowired
    private t_UserMapper userMapper;

    @Test
    public void test() {
        System.out.println(userMapper.selectById(1));
    }
}
