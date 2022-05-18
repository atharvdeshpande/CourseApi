package com.example.course.topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@Service
public class TopicService {

    @Autowired
    private TopicRepository topicrepository;
    private List<Topic> topics=new ArrayList<>(Arrays.asList(

            new Topic("12ERQ","spring","springDescription"),
                new Topic("java","java spring","java spring Description"),
                new Topic("java script","java script framework","java script ōDescription")
        ));
    public List<Topic> getAllTopics(){

        List<Topic> topics=new ArrayList<>();
        topicrepository.findAll()
                .forEach(topics::add);
        return topics;
    }

    public Optional<Topic> getTopic(String id){


        return topicrepository.findById(id);
    }


    public void addTopics(Topic t) {
       topicrepository.save(t);
    }

    public void updateTopics(String id, Topic t) {

       topicrepository.save(t);
    }

    public void delTopic(String id) {
        topicrepository.deleteById(id);
    }
}
