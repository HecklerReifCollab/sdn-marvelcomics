package com.thehecklers.sdnmarvelcomics.story;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stories")
public class StoryController {
    private final StoryRepo repo;

    public StoryController(StoryRepo repo) { this.repo = repo; }

    public Iterable<Story> getAllStories() { return repo.findAll(); }
}
