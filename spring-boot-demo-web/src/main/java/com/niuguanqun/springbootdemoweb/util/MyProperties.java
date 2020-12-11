package com.niuguanqun.springbootdemoweb.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class MyProperties {

    @Value("${com.niuguanqun.title}")
    private String title;

    @Value("${com.neo.description}")
    private String description;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MyProperties() {
    }

    @Override
    public String toString() {
        return "MyProperties{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
