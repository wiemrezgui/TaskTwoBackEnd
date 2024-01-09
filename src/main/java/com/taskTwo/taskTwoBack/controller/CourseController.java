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

@RestController
@RequestMapping("/task")
public class CourseController {

    private final CourseService courseService;
    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourses() {
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
    
    @PostMapping("/uploadImage/{id}")
    public ResponseEntity<?> uploadImage(@PathVariable("id") Long courseId, @RequestParam("imageFile") MultipartFile file) {
        try {
            courseService.uploadImage(courseId, file);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error uploading image", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getImage/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Long courseId) {
        try {
            byte[] imageBytes = courseService.getImage(courseId);
            return ResponseEntity.ok().contentType(org.springframework.http.MediaType.IMAGE_JPEG).body(imageBytes);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    public static byte[] compressBytes(byte[] data) throws IOException {
    	Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        deflater.end();
        outputStream.close();

        return outputStream.toByteArray(); 
		
    }
    public static byte[] decompressBytes(byte[] data) throws IOException {
    	Inflater inflater = new Inflater();
        inflater.setInput(data);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!inflater.finished()) {
            int count = 0;
			try {
				count = inflater.inflate(buffer);
			} catch (DataFormatException e) {
				e.printStackTrace();
			}
            outputStream.write(buffer, 0, count);
        }
        inflater.end();
        outputStream.close();
        return outputStream.toByteArray();    }
}

