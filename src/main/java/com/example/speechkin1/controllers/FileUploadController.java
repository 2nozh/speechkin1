package com.example.speechkin1.controllers;

import com.example.speechkin1.dao.PostDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/posts/newPost")
public class FileUploadController {
    @Autowired
    private PostDAO postDAO;

    @GetMapping("")
    public String provideUploadInfo() {
        return "posts/newPost";
    }

    @PostMapping("")
    public String handleFileUpload(@ModelAttribute("file") MultipartFile file) {
        try {
            postDAO.addPost(file);
        }catch (Exception e){
            System.out.println(e.getMessage());
            return "/posts/newPost";
        }

        return "redirect:/posts";
    }
}
