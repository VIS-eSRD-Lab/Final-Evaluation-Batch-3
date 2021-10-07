package com.example.restservice.Test1;

public class Result {
    private int stdId;
    private int courseId;
    private int phase;
    private String grade;

    public Result() {
    }

    public Result(int stdId, int courseId, int phase, String grade) {
        this.stdId = stdId;
        this.courseId = courseId;
        this.phase = phase;
        this.grade = grade;
    }

    public int getStdId() {
        return stdId;
    }

    public void setStdId(int stdId) {
        this.stdId = stdId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getPhase() {
        return phase;
    }

    public void setPhase(int phase) {
        this.phase = phase;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
