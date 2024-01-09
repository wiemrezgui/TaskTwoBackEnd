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

    public void createCourse(Course course) {
        this.courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
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
    public void uploadImage(Long courseId, MultipartFile file) throws IOException {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            course.setPicByte(CourseController.compressBytes(file.getBytes()));
            courseRepository.save(course);
        } else {
            throw new RuntimeException("Course not found");
        }
    }
    @Override
    public byte[] getImage(Long courseId) throws IOException {
        Optional<Course> optionalCourse = courseRepository.findById(courseId);

       if (optionalCourse.isPresent()) {
      Course course = optionalCourse.get();
           return CourseController.decompressBytes(course.getPicByte());
        } else {
           throw new RuntimeException("Course not found");
        }
    }

	@Override
	public Course findById(Long id) {
		Optional<Course> course = courseRepository.findById(id);
		return course.isPresent() ? course.get() : null;
	}

}
