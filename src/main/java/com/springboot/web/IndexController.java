package com.springboot.web;

import com.springboot.service.posts.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostService postService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("postsList", postService.findAllDesc());
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSaveForm() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("posts", postService.findById(id));
        return "posts-update";
    }
}
