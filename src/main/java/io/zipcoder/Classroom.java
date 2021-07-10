package io.zipcoder;

import java.util.*;

public class Classroom {
    int maxNumberOfStudents = 0;
    Student[] students;
    int averageExamScore = 0;

    public Classroom() {
        this.students = new Student[30];
    }
// Do you need the Dot dot dot?
    public Classroom(Student... students) {
        this.students = students;
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Student[] getStudents() {
        return students;
    }

    public int getAverageExamScore() {
       int averageSum = 0;
        for (Student student : students) {
            averageSum += student.getAverageExamScore();

        }
      return averageSum/students.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = student;
            }
        }
    }

    // remove element from student array
    //
    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> arrayOfStudents = new ArrayList<Student>(Arrays.asList(students));
        for (int i = 0; i <arrayOfStudents.size() ; i++) {
            Student student = arrayOfStudents.get(i);
            if(student.getLastName() == lastName && student.getFirstName() == firstName){
                arrayOfStudents.remove(student);
                arrayOfStudents.add(null);
            }
        }
        students = arrayOfStudents.toArray(new Student[0]);
    }
// Add in Arraylists adds furthest to the end

    public Student[] getStudentsByScore() {

        List<Student> arrayOfStudents = new ArrayList<Student>(Arrays.asList(students));

        Comparator<Student> byExamScores = Comparator.comparing(Student::getExamScores);
        Comparator<Student> byFullName = Comparator.comparing(Student::getFullName);

        Collections.sort(arrayOfStudents, byExamScores.thenComparing(byFullName));
        Collections.reverse(arrayOfStudents);

        Student[] sortedByScore = arrayOfStudents.toArray(new Student[0]);
        return sortedByScore;
    }
}
