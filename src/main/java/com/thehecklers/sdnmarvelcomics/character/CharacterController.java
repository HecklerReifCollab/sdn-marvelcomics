package com.thehecklers.sdnmarvelcomics.character;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterRepo repo;

    public CharacterController(CharacterRepo repo) { this.repo = repo; }

    @GetMapping
    public Iterable<Character> getAllCharacters() { return repo.findAll(); }
}
