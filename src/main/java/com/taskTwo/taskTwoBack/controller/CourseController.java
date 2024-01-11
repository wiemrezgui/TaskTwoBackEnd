package com.taskTwo.taskTwoBack.controller;

import com.taskTwo.taskTwoBack.model.Course;
import com.taskTwo.taskTwoBack.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;
@CrossOrigin("*")
@RestController
@RequestMapping("/task")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public List<Course>getAllCourses(){
		return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
	public Course getCourseById(@PathVariable Long id) {
		return courseService.findById(id);
	}
    @PostMapping("/create")
    public Course CreateCourse(@RequestBody Course course) {
        return courseService.addCourse(course);
    }

    @PutMapping("/update")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCourse(@PathVariable("id") Long id) {
        courseService.deleteCourse(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

