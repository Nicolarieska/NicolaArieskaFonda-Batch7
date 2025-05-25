/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller;

import com.example.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.service.PostResponseService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Asus
 */
@RestController
@RequestMapping("/api/me/posts")
public class PostController {

    @Autowired
    private PostResponseService postService;

    @GetMapping()
    public List<Post> getMyPosts() {
        return postService.getPostsOfCurrentUser();
    }

    @PostMapping()
    public Post createMyPost(@RequestBody Post post) {
        return postService.createPostForCurrentUser(post);
    }

    @PatchMapping("/{id}")
    public Post updateMyPost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updateOwnPost(id, post);
    }

    @DeleteMapping("/{id}")
    public String deleteMyPost(@PathVariable Long id) {
        postService.deleteOwnPost(id);
        return "Post Deleted";
    }
}
