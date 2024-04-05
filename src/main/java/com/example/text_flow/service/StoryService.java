package com.example.text_flow.service;

import com.example.text_flow.dao.EmployeeDao;
import com.example.text_flow.dao.SubscriptionDao;
import com.example.text_flow.dao.StoryDao;
import com.example.text_flow.entity.Story;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class StoryService extends BaseService<Story> {

    @Autowired
    private StoryDao storyDao;

    @Autowired
    private SubscriptionDao subscriptionDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Transactional
    public List<Story> getStoryListByAuthorId(String authorId){
        return storyDao.getStoryListByAuthorId(authorId);
    }

    @Transactional
    public List<Story> getStoryListBySubscriberId(@PathVariable String subscriber_id){
        return subscriptionDao.getSubscriptionListBySubscriberId(subscriber_id)
                .stream()
                .map(s -> employeeDao.getById(s.getWriterId()).getStoryList())
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

}
