package com.example.text_flow.dao;

import com.example.text_flow.entity.Story;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


@Repository
public class StoryDao extends BaseDao<Story> {
    public StoryDao() {
        super(Story.class);
    }

    @Transactional
    public List<Story> getStoryListByAuthorId(String authorId){
        CriteriaQuery<Story> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Story.class);
        criteriaQuery.where(criteriaQuery.from(Story.class).get("authorId").in(authorId));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
