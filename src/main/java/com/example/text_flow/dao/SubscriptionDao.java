package com.example.text_flow.dao;

import com.example.text_flow.entity.Subscription;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


@Repository
public class SubscriptionDao extends BaseDao<Subscription> {

    public SubscriptionDao() {
        super(Subscription.class);
    }


    @Transactional
    public List<Subscription> getSubscriptionListByWriterId(String writerId){
        CriteriaQuery<Subscription> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Subscription.class);
        criteriaQuery.where(criteriaQuery.from(Subscription.class).get("writerId").in(writerId));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    @Transactional
    public List<Subscription> getSubscriptionListBySubscriberId(String subscriberId){
        CriteriaQuery<Subscription> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(Subscription.class);
        criteriaQuery.where(criteriaQuery.from(Subscription.class).get("subscriberId").in(subscriberId));

        return entityManager.createQuery(criteriaQuery).getResultList();
    }

}
