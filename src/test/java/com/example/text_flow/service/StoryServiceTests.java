package com.example.text_flow.service;

import com.example.text_flow.entity.Story;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.text_flow.utils.TestData.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoryServiceTests {

    @Autowired
    StoryService storyService;


    @Test()
    @Order(1)
    public void getStoryListByAuthorId(){
        List<Story> storyList = storyService.getStoryListByAuthorId(EMP_1_ID);

        Assertions.assertNotNull(storyList, "Story list by author id is NULL");
        Assertions.assertNotEquals(storyList.size(), 0, "Story list by author id is EMPTY");
        Assertions.assertEquals(storyList.size(), ST_LIST_SIZE_BY_AUTHOR_ID, "Story list by author id is WRONG size");
    }

    @Test()
    @Order(2)
    public void getStoryListBySubscriberId(){
        List<Story> storyList = storyService.getStoryListBySubscriberId(EMP_2_ID);

        Assertions.assertNotNull(storyList, "Story list by author id is NULL");
        Assertions.assertNotEquals(storyList.size(), 0, "Story list by subscriber id is EMPTY");
        Assertions.assertEquals(storyList.size(), ST_LIST_SIZE_BY_SUBSCRIBER_ID, "Story list by subscriber id is WRONG size");
    }

}
