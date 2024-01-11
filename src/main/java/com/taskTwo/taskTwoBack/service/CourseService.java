package com.taskTwo.taskTwoBack.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.taskTwo.taskTwoBack.model.Course;


public interface CourseService {
    public List<Course>getAllCourses();
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
	public Course findById(Long id);
    public void deleteCourse(Long id);
    //void uploadImage(Long courseId, MultipartFile file) throws IOException;
   // byte[] getImage(Long courseId) throws IOException;
}
