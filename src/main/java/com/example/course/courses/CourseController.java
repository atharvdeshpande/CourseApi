package com.example.course.courses;

import com.example.course.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class CourseController {
    @Autowired
    private CourseService courseservice;
    @GetMapping("/topic/id/course")
    public List<Course> getAllTopics(@PathVariable String topicid)
    {
        return courseservice.getAllCourses(topicid);
    }

    @GetMapping("/topic/{topicid}/course/{id}")
    public Optional<Course> getCourse(@PathVariable String id)

    {
        return courseservice.getCourse(id);
    }
    @PostMapping("/topic/{topicid}/course")
    public void addCourse(@RequestBody Course c,@PathVariable String topicid)
    {
        c.setTopic(new Topic(topicid,"",""));
        courseservice.addCourse(c);
    }

    @PutMapping("/topic/{topicid}/course/{id}")
    public void updateCourse(@RequestBody Course c, @PathVariable String id,@PathVariable String topicid)
    {
        c.setTopic(new Topic(topicid,"",""));
        courseservice.updateCourse(id,c);
    }

    @DeleteMapping("/topic/{topicid}/course/{id}")
    public void delCourse(@PathVariable String id)
    {
        courseservice.delCourse(id);
    }
}
