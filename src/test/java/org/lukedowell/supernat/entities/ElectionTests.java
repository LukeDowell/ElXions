package org.lukedowell.supernat.entities;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.lukedowell.supernat.SuperGameElectionApplication;
import org.lukedowell.supernat.repositories.ElectionRepository;
import org.lukedowell.supernat.services.interfaces.ElectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by ldowell on 11/25/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SuperGameElectionApplication.class)
public class ElectionTests {

    @Autowired
    ElectionService electionService;

    @Autowired
    ElectionRepository electionRepository;

    @Test
    public void myTest() {
        assertEquals(1, 1);
    }

}
