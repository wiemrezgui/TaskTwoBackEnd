package com.taskTwo.taskTwoBack.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.taskTwo.taskTwoBack.model.Course;


public interface CourseService {
	void createCourse(Course course);
    List<Course> getAllCourses();
    Course addCourse(Course course);
    Course updateCourse(Course course);
	public Course findById(Long id);
    void deleteCourse(Long id);
    void uploadImage(Long courseId, MultipartFile file) throws IOException;
    byte[] getImage(Long courseId) throws IOException;
}
