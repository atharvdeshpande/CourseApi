package com.example.course.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class TopicController {
    @Autowired
    private TopicService topicservice;
    @GetMapping("/topic")
    public List<Topic> getAllTopics()
    {
        return topicservice.getAllTopics();
    }

    @GetMapping("/topic/{id}")
    public Optional<Topic> getTopic(@PathVariable String id)

    {
        return topicservice.getTopic(id);
    }
    @PostMapping("/topic")
    public void addTopics(@RequestBody Topic t)
    {
        topicservice.addTopics(t);
    }

    @PutMapping("/topic/{id}")
    public void updateTopics(@RequestBody Topic t,@PathVariable String id)
    {
        topicservice.updateTopics(id,t);
    }

    @DeleteMapping("/topic/{id}")
    public void delTopic(@PathVariable String id)
    {
        topicservice.delTopic(id);
    }
}
