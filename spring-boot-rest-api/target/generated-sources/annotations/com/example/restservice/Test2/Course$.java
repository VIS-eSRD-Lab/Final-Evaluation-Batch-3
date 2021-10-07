package com.example.restservice.Test2;

import com.speedment.jpastreamer.field.IntField;
import com.speedment.jpastreamer.field.ReferenceField;
import com.speedment.jpastreamer.field.StringField;
import com.speedment.jpastreamer.field.exception.IllegalJavaBeanException;

import java.util.List;

/**
 * The generated base for entity {@link Course} representing entities of the
 * {@code course}-table in the database.
 * <p> This file has been automatically generated by JPAStreamer.
 * 
 * @author JPAStreamer
 */
public final class Course$ {
    
    /**
     * This Field corresponds to the {@link Course} field id.
     */
    public static final IntField<Course> id = IntField.create(
        Course.class,
        "id",
        Course::getId,
        false
    );
    /**
     * This Field corresponds to the {@link Course} field courseId.
     */
    public static final IntField<Course> courseId = IntField.create(
        Course.class,
        "courseId",
        Course::getCourseId,
        false
    );
    /**
     * This Field corresponds to the {@link Course} field name.
     */
    public static final StringField<Course> name = StringField.create(
        Course.class,
        "name",
        Course::getName,
        false
    );
    /**
     * This Field corresponds to the {@link Course} field phase.
     */
    public static final ReferenceField<Course, Phase> phase = ReferenceField.create(
        Course.class,
        "phase",
        Course::getPhase,
        false
    );
    /**
     * This Field corresponds to the {@link Course} field course_fee.
     */
    public static final IntField<Course> course_fee = IntField.create(
        Course.class,
        "course_fee",
        course -> {throw new IllegalJavaBeanException(Course.class, "course_fee");},
        false
    );
    /**
     * This Field corresponds to the {@link Course} field students.
     */
    public static final ReferenceField<Course, List<Student>> students = ReferenceField.create(
        Course.class,
        "students",
        Course::getStudents,
        false
    );
}