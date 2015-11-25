package org.lukedowell.supernat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lukedowell.supernat.entities.Election;
import org.lukedowell.supernat.repositories.ElectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by ldowell on 11/25/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SuperGameElectionApplication.class)
@WebAppConfiguration
public class SuperGameElectionApplicationTests {

    @Autowired
    ElectionRepository electionRepository;

    @Test
    public void contextLoads() {
    }

}
