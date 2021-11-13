package com.example.speechkin1.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String body;
    private Date date;
    private String categories;

    public String getPreview(int symbols) {
        if (getBody().length() > symbols) {
            return getBody().substring(0, symbols);
        } else {
            return getBody();
        }

    }
}
