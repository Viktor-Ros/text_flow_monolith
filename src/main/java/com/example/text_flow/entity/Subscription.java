package com.example.text_flow.entity;


import javax.persistence.*;

@Entity
public class Subscription extends BaseEntity {

    @Transient
    public static final String entityCode = "sub";


    @Column(nullable = false)
    private String writerId;

    @Column(nullable = false)
    private String subscriberId;


    public Subscription() {
        super(entityCode);
    }

    public Subscription(String writerId, String subscriberId) {
        super(entityCode);
        this.writerId = writerId;
        this.subscriberId = subscriberId;
    }

    public String getWriterId() {
        return writerId;
    }

    public void setWriterId(String writerId) {
        this.writerId = writerId;
    }

    public String getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(String subscriberId) {
        this.subscriberId = subscriberId;
    }

    @Override
    public String toString() {
        return "Subscription{" +
                "id=" + getId() +
                ", creationDate=" + getCreationDate() +
                ", modifyDate=" + getModifyDate() +
                ", writerId=" + writerId +
                ", subscriberId=" + subscriberId +
                '}';
    }
}


