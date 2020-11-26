package com.interview;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Test for the controller.
 * @author JRCeja
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmploySkillsApplicationTests {

    @Autowired
    EmployeeSkillController employeeSkillController;

    @Test
    public void verifyPing() {
        Assert.assertSame("pong", employeeSkillController.ping());
    }
}
