package com.example.microassignment.demo.Controller;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "POST")
public class POST {
    @Id
    private String id;
    private String userName;
    private String password;

    private String title;
    private String content;

    public POST(String userName, String password, String title, String content) {
        this.userName = userName;
        this.password = password;
        this.title = title;
        this.content = content;
    }

}
