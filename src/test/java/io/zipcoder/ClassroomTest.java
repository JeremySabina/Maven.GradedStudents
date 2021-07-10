package io.zipcoder;

import org.junit.Assert;
import org.junit.Test;

import java.net.PortUnreachableException;

public class ClassroomTest {

    @Test
    public void getStudentsByScoreTest() {
        //What do I need to make
        // Given
        String firstName0 = "Leon";
        String lastName0 = "Hunter";
        Double[] examScores0 = {100.0, 95.0, 123.0, 96.0};
        Student student0 = new Student(firstName0, lastName0, examScores0);

        String firstName1 = "Leon";
        String lastName1 = "Frankenfurt";
        Double[] examScores1 = {100.0, 95.0, 123.0, 96.0};
        Student student1 = new Student(firstName1, lastName1, examScores1);

        String firstName2 = "Steve";
        String lastName2 = "Bangalo";
        Double[] examScores2 = {90.0, 93.0, 113.0, 95.0};
        Student student2 = new Student(firstName2, lastName2, examScores2);
        Classroom classroom = new Classroom(student0, student1, student2);


        Student[] expected = {student0, student1, student2};
        //Getting the actual
        //When
        Student[] actual = classroom.getStudentsByScore();

        Assert.assertArrayEquals(expected, actual);

    }
}
