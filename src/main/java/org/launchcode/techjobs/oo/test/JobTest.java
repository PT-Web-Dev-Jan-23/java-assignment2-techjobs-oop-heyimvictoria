package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job jobTest1 = new Job();
        Job jobTest2 = new Job();
        assertNotEquals(jobTest1.getId(), jobTest2.getId());
        }

        @Test
        public void testJobConstructorSetsAllFields(){
        Job jobsTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        //checks that class and value is properly assigned
            assertTrue(jobsTest.getName() instanceof String); //checks that the objects is an instance of the name Sting
            assertTrue(jobsTest.getEmployer() instanceof Employer);
            assertTrue(jobsTest.getLocation() instanceof Location);
            assertTrue(jobsTest.getPositionType() instanceof PositionType);
            assertTrue(jobsTest.getCoreCompetency() instanceof CoreCompetency);

            //checks each field is properly assigned...chatGPT is awesome
            assertEquals("Product tester", jobsTest.getName());
            assertEquals("ACME", jobsTest.getEmployer().getValue());
            assertEquals("Desert", jobsTest.getLocation().getValue());
            assertEquals("Quality control", jobsTest.getPositionType().getValue());
            assertEquals("Persistence", jobsTest.getCoreCompetency().getValue());

        }
        @Test
        public void testJobsForEquality(){
            Job job1 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
            Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        //
            boolean result = job1.equals(job2);
            assertFalse(result); //checks the result is false.. again chatGPT for the reference
        }

        @Test
    public void testToStringStartsAndEndsWithNewLine(){
            Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            String expectedData = "ID: 1\n" +
                    "Name: Product tester\n" +
                    "Employer: ACME\n" +
                    "Location: Desert\n" +
                    "Position Type: Quality control\n" +
                    "Competency: Persistence\n\n";
            assertEquals('\n' + expectedData + '\n', job1.toString());

        }

    }
