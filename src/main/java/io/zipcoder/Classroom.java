package io.zipcoder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Classroom {
    int maxNumberOfStudents = 0;
    Student[] studentArray;
    int averageExamScore = 0;

    public Classroom() {
        this.studentArray = new Student[30];
    }

    // Do you need the Dot dot dot?
    public Classroom(Student... studentArray) {
        this.studentArray = studentArray;
    }

    public Classroom(int maxNumberOfStudents) {
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public Student[] getStudentArray() {
        return studentArray;
    }

    public int getAverageExamScore() {
        int averageSum = 0;
        for (Student student : studentArray) {
            averageSum += student.getAverageExamScore();

        }
        return averageSum / studentArray.length;
    }

    public void addStudent(Student student) {
        for (int i = 0; i < studentArray.length; i++) {
            if (studentArray[i] == null) {
                studentArray[i] = student;
            }
        }
    }

    // remove element from student array
    //
    public void removeStudent(String firstName, String lastName) {
        ArrayList<Student> arrayOfStudents = new ArrayList<Student>(Arrays.asList(studentArray));
        for (int i = 0; i < arrayOfStudents.size(); i++) {
            Student student = arrayOfStudents.get(i);
            if (student.getLastName() == lastName && student.getFirstName() == firstName) {
                arrayOfStudents.remove(student);
                arrayOfStudents.add(null);
            }
        }
        studentArray = arrayOfStudents.toArray(new Student[0]);
    }
// Add in Arraylists adds furthest to the end

    public Student[] getStudentsByScore() {

        List<Student> arrayOfStudents = new ArrayList<Student>(Arrays.asList(studentArray));

        Comparator<Student> byExamScores = Comparator.comparing(Student::getExamScores);
        Comparator<Student> byFullName = Comparator.comparing(Student::getFullName);

        Collections.sort(arrayOfStudents, byExamScores.thenComparing(byFullName));
        Collections.reverse(arrayOfStudents);

        Student[] sortedByScore = arrayOfStudents.toArray(new Student[0]);
        return sortedByScore;
    }

    // Standard Deviation,
    public Map<Student, Character> getGradeBook() {
        Map<Student, Character> result =new HashMap<>();
        for(Student student : studentArray) {
            Double percentile = getPercentile(student);
            boolean isPercentileBetween0And10 = percentile > 10;
            boolean isPercentileBetween11And29 = percentile > 29;
            boolean isPercentileBetween30And50 = percentile > 50;
            boolean isPercentileBetween51And89 = percentile > 89;
            if(isPercentileBetween0And10) {
                result.put(student, 'A');
            } else if(isPercentileBetween11And29) {
                result.put(student, 'B');
            } else if(isPercentileBetween30And50) {
                result.put(student, 'C');
            } else if(isPercentileBetween51And89) {
                result.put(student, 'D');
            } else {
                result.put(student, 'F');
            }
        }
        return result;
    }

    private double getPercentile(Student student) {
        List<Double> allStudentGrades = Stream
                .of(studentArray)
                .map(Student:: getAverageExamScore)
                .collect(Collectors.toList());

        double studentAveragePercentage = student.getAverageExamScore();
        boolean isPercentileGreaterThan0 = studentAveragePercentage >= 0;
        boolean isPercentileLessThan100 = studentAveragePercentage <= 100;
        boolean isPercentileValid = isPercentileGreaterThan0 && isPercentileLessThan100;
        boolean isItemsEmpty = allStudentGrades.isEmpty();
        boolean areArgumentsValid = isPercentileValid && !isItemsEmpty;
        if(!areArgumentsValid) {
            throw new IllegalArgumentException();
        }
        Collections.sort(allStudentGrades);
        return allStudentGrades.get((int) Math.round(studentAveragePercentage / 100.0 * (allStudentGrades.size() - 1)));
    }
}

// HashMap<Student, Character> gradeBook = new HashMap<>();

//    public static double calculateSD(double numArray[])
//    {
//        double sum = 0.0, standardDeviation = 0.0;
//        int length = numArray.length;
//
//        for(double num : numArray) {
//            sum += num;
//        }
//
//        double mean = sum/length;
//
//        for(double num: numArray) {
//            standardDeviation += Math.pow(num - mean, 2);
//        }
//
//        return Math.sqrt(standardDeviation/length);
//    }

