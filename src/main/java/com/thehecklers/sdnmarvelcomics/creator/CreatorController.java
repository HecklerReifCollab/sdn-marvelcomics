package com.thehecklers.sdnmarvelcomics.creator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/creators")
public class CreatorController {
    private final CreatorRepo repo;

    public CreatorController(CreatorRepo repo) { this.repo = repo; }

    @GetMapping
    public Iterable<Creator> getAllCreators() { return repo.findAll(); }
}
