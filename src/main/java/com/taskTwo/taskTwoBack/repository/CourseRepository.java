package com.taskTwo.taskTwoBack.repository;
import com.taskTwo.taskTwoBack.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CourseRepository extends JpaRepository<Course,String>{
}