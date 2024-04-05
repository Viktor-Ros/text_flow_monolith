package com.example.text_flow.dao;

import com.example.text_flow.entity.Story;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.example.text_flow.utils.TestData.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StoryDaoTests {

    @Autowired
    StoryDao storyDao;

    private static String ST_ID_NEW;


    @Test()
    @Order(1)
    public void save(){
        Story savedStory = storyDao.save(new Story(ST_VALUE_NEW, EMP_1_ID));

        Assertions.assertNotNull(savedStory, "Story is NOT saved");
        Assertions.assertNotEquals(savedStory.getId(), null, "Story was created INCORRECT");

        ST_ID_NEW = savedStory.getId();
    }

    @Test
    @Order(2)
    public void getById(){
        Story story = storyDao.getById(ST_1_ID);

        Assertions.assertNotNull(story, "Story is NOT get by id");
    }

    @Test
    @Order(3)
    public void delete(){
        String message = storyDao.deleteById(ST_ID_NEW);

        Assertions.assertEquals( Story.class.getName() + " with id = " + ST_ID_NEW + " successfully DELETED", message,"Story is NOT deleted");
    }

    @Test
    @Order(4)
    public void getAll(){
        List<Story> storyList = storyDao.getAllList();

        Assertions.assertNotNull(storyList, "All Story list is NULL");
        Assertions.assertNotEquals(storyList.size(), 0, "All Story list is EMPTY");
        Assertions.assertEquals(storyList.size(), ST_ALL_LIST_SIZE, "All Story list is WRONG size");
    }

    @Test
    @Order(5)
    public void getStoryListByAuthorId(){
        List<Story> storyList = storyDao.getStoryListByAuthorId(EMP_1_ID);

        Assertions.assertNotNull(storyList, "Story list by author id is NULL");
        Assertions.assertNotEquals(storyList.size(), 0, "Story list by author id is EMPTY");
        Assertions.assertEquals(storyList.size(), ST_LIST_SIZE_BY_AUTHOR_ID, "Story list by author id is WRONG size");
    }

}
