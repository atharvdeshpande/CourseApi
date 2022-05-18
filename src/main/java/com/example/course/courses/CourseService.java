package com.example.course.courses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class CourseService {

    @Autowired
    private CourseRepository courserepository;

    public List<Course> getAllCourses(String topicid){

        List<Course> courses=new ArrayList<>();
        courserepository.findByTopicId(topicid)
                .forEach(courses::add);
        return courses;
    }

    public Optional<Course> getCourse(String id){


        return courserepository.findById(id);
    }


    public void addCourse(Course t) {
       courserepository.save(t);
    }

    public void updateCourse(String id, Course t) {

       courserepository.save(t);
    }

    public void delCourse(String id) {
        courserepository.deleteById(id);
    }
}
