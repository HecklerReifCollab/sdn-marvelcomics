package com.thehecklers.sdnmarvelcomics.event;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {
    private final EventRepo repo;

    public EventController(EventRepo repo) { this.repo = repo; }

    @GetMapping
    public Iterable<Event> getAllEvent() { return repo.findAll(); }
}
