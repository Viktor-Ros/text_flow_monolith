package com.example.text_flow.entity;


import javax.persistence.*;
import java.util.List;

@Entity
public class Employee extends BaseEntity {

    @Transient
    public static final String entityCode = "emp";


    private String name;

    @OneToMany(targetEntity = Story.class, mappedBy = "authorId", cascade = CascadeType.ALL)
    private List<Story> storyList;

    @OneToMany(targetEntity = Subscription.class,  mappedBy = "subscriberId", cascade = CascadeType.ALL)
    private List<Subscription> writerList;

    @OneToMany(targetEntity = Subscription.class, mappedBy = "writerId", cascade = CascadeType.ALL)
    private List<Subscription> subscriberList;


    public Employee() {
        super(entityCode);
    }

    public Employee(String name) {
        super(entityCode);
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Story> getStoryList() {
        return storyList;
    }

    public void setStoryList(List<Story> storyList) {
        this.storyList = storyList;
    }

    public List<Subscription> getWriterList() {
        return writerList;
    }

    public void setWriterList(List<Subscription> writerList) {
        this.writerList = writerList;
    }

    public List<Subscription> getSubscriberList() {
        return subscriberList;
    }

    public void setSubscriberList(List<Subscription> subscriberList) {
        this.subscriberList = subscriberList;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + getId() +
                ", creationDate=" + getCreationDate() +
                ", modifyDate=" + getModifyDate() +
                ", name='" + name +
                ", storyList=" + storyList +
                ", writerList=" + writerList +
                ", subscriberList=" + subscriberList +
                '}';
    }

}
