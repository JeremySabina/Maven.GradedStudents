package io.zipcoder;

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

}
