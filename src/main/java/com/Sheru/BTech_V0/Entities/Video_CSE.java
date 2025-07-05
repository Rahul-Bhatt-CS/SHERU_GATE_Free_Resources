package com.Sheru.BTech_V0.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "YTVideos_CSE")
public class Video_CSE {
    @Id
    private String video_Id;
    private String link;
    private String name;
    private String publisher;
    private String subject;
    private Boolean allowed;

    public String getVideo_Id() {
        return video_Id;
    }

    public void setVideo_Id(String video_Id) {
        this.video_Id = video_Id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Boolean getAllowed() {
        return allowed;
    }

    public void setAllowed(Boolean allowed) {
        this.allowed = allowed;
    }
}
