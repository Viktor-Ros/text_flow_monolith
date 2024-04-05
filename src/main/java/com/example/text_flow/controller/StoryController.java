package com.example.text_flow.controller;

import com.example.text_flow.entity.Story;
import com.example.text_flow.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/story")
public class StoryController extends BaseController<Story> {

    @Autowired
    StoryService storyService;


    @GetMapping("/story_list_by_author_id/{author_id}")
    public List<Story> getStoryListByAuthorId(@PathVariable String author_id){
        return storyService.getStoryListByAuthorId(author_id);
    }

    @GetMapping("/story_list_by_subscriber_id/{subscriber_id}")
    public List<Story> getStoryListBySubscriberId(@PathVariable String subscriber_id){
        return storyService.getStoryListBySubscriberId(subscriber_id);
    }

}
