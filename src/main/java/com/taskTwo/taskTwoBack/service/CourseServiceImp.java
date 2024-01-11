package com.taskTwo.taskTwoBack.service;

import com.taskTwo.taskTwoBack.controller.CourseController;
import com.taskTwo.taskTwoBack.model.Course;
import com.taskTwo.taskTwoBack.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course>getAllCourses() {
        return courseRepository.findAll();
    }
    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
    @Override
    public Course updateCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
 
	@Override
	public Course findById(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		return course.isPresent() ? course.get() : null;
	}

}
