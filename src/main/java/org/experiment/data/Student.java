package org.experiment.data;

import javax.annotation.PostConstruct;
import java.util.Map;

public class Student {
    private String name;
    private Map<String, Integer> mapGradesOfStudent;
    private Boolean isEnrolled = false;

    public Student(String name, Map<String, Integer> mapGradesOfStudent) {
        this.name = name;
        this.mapGradesOfStudent = mapGradesOfStudent;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getMapGradesOfStudent() {
        return mapGradesOfStudent;
    }

    public Boolean getEnrolled() {
        return isEnrolled;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMapGradesOfStudent(Map<String, Integer> mapGradesOfStudent) {
        this.mapGradesOfStudent = mapGradesOfStudent;
    }

    public void setEnrolled(Boolean enrolled) {
        isEnrolled = enrolled;
    }

    public Double calculateAverageGrades() {
        Double average = 0.0;
        for (Map.Entry<String, Integer> entry : mapGradesOfStudent.entrySet()) {
            average += entry.getValue();
        }
        average /= mapGradesOfStudent.size();
        return average;
    }

    @PostConstruct
    public void init() {
        if (calculateAverageGrades() >= 3.0) {
            isEnrolled = true;
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", mapGradesOfStudent=" + mapGradesOfStudent +
                ", isEnrolled=" + isEnrolled +
                '}';
    }
}

