package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class StudentTest {
        @Test
        public void studentConstructorTest() {

                // : Given
                String firstName = "Leon";
                String lastName = "Hunter";
                Double[] examScores = {100.0, 95.0, 123.0, 96.0};
                Student student = new Student(firstName, lastName, examScores);

                // When
                String expectedName = student.getFirstName();


                // Then
                Assert.assertEquals(expectedName, firstName);

        }
        @Test
                public void studentGetExamScoresTest() {
                // : Given
                String firstName = "Leon";
                String lastName = "Hunter";
                Double[] examScores = {100.0, 95.0, 123.0, 96.0};
                Student student = new Student(firstName, lastName, examScores);

                // When
                String expectedExamScore =


                // Then


                }
        }
}