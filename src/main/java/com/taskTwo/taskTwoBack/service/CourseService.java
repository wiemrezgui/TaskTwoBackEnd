package com.taskTwo.taskTwoBack.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.taskTwo.taskTwoBack.model.Course;


public interface CourseService {
	void createCourse(Course course);
    Optional<List<Course>> getAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Course course);
    void deleteCourse(String id);
    void uploadImage(String courseId, MultipartFile file) throws IOException;
    byte[] getImage(String courseId) throws IOException;
}
