package com.example.text_flow.entity;


import javax.persistence.*;

@Entity
public class Story extends BaseEntity {

    @Transient
    public static final String entityCode = "str";


    @Column(nullable = false)
    private String textValue;

    @Column(updatable = false)
    private String authorId;

    public Story() {
        super(entityCode);
    }

    public Story(String textValue, String authorId) {
        super(entityCode);
        this.textValue = textValue;
        this.authorId = authorId;
    }


    public String getTextValue() {
        return textValue;
    }

    public void setTextValue(String textValue) {
        this.textValue = textValue;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Story{" +
                "id=" + getId() +
                ", creationDate=" + getCreationDate() +
                ", modifyDate=" + getModifyDate() +
                ", textValue='" + textValue +
                ", authorId=" + authorId +
                '}';
    }
}
