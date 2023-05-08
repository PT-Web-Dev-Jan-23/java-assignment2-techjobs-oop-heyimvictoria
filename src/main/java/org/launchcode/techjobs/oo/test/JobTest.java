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
        Job jobsTest = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        //checks that class and value is properly assigned
            assertTrue(jobsTest.getName() instanceof String); //checks that the objects is an instance of the name Sting
            assertTrue(jobsTest.getEmployer() instanceof Employer);
            assertTrue(jobsTest.getLocation() instanceof Location);
            assertTrue(jobsTest.getPositionType() instanceof PositionType);
            assertTrue(jobsTest.getCoreCompetency() instanceof CoreCompetency);

            //checks each field is properly assigned...chatGPT is awesome
            assertEquals("Web Developer", jobsTest.getName());
            assertEquals("LaunchCode", jobsTest.getEmployer().getValue());
            assertEquals("St. Louis", jobsTest.getLocation().getValue());
            assertEquals("Front-end developer", jobsTest.getPositionType().getValue());
            assertEquals("JavaScript", jobsTest.getCoreCompetency().getValue());

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
            Job job3 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
            String expectedData = "\nID: 1\n" +
                    "\nName: Web Developer\n" +
                    "\nEmployer: LaunchCode\n" +
                    "\nLocation: St. Louis" +
                    "\nPosition Type: Front-end developer\n" +
                    "\nCompetency: JavaScript\n\n";
            assertEquals(expectedData.charAt(0), job3.toString().charAt(0));
            //second assertEquals checks for the last character newline
            assertEquals(expectedData.charAt(expectedData.length()-1), job3.toString().charAt(job3.toString().length()-1));
        }
        @Test
        public void testToStringContainsCorrectLabelsAndData() {
            Job job4 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
            String jobString = job4.toString();
            //created a job object and called the toString method to get the string representation of the object.
            String dataExpected = "\nID: 4\n" +
                    "Name: Web Developer\n" +
                    "Employer: LaunchCode\n" +
                    "Location: St. Louis\n" +
                    "Position Type: Front-end developer\n" +
                    "Core Competency: JavaScript\n";
            assertEquals(dataExpected, jobString.toString());
        }
           /* assertTrue(jobString.contains("ID: "));
            assertTrue(jobString.contains("Name: Web Developer"));
            assertTrue(jobString.contains("Employer: LaunchCode"));
            assertTrue(jobString.contains("Location: St. Louis"));
            assertTrue(jobString.contains("Position Type: Front-end developer"));
            assertTrue(jobString.contains("Core Competency: JavaScript"));*/

            // so initially tried with the assertTrue but i kept getting assertion, missing invocation errors, so i refactored to try it the same way i used above with the assertEquals

        @Test
        public void testToStringHandlesEmptyField(){
            Job job5 = new Job("Web Developer", new Employer(""), new Location("St. Louis"), new PositionType(""), new CoreCompetency("JavaScript"));
            String expectedData2 = "\nID: 3\n" +
                    "Name: Web Developer\n" +
                    "Employer: Data not available\n" +
                    "Location: St. Louis\n" +
                    "Position Type: Data not available\n" +
                    "Core Competency: JavaScript\n";
            assertEquals(expectedData2, job5.toString());
        }
    }
