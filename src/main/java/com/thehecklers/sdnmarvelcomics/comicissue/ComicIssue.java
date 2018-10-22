package com.thehecklers.sdnmarvelcomics.comicissue;

import com.thehecklers.sdnmarvelcomics.character.Character;
import com.thehecklers.sdnmarvelcomics.creator.Creator;
import com.thehecklers.sdnmarvelcomics.event.Event;
import com.thehecklers.sdnmarvelcomics.series.Series;
import com.thehecklers.sdnmarvelcomics.story.Story;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
@NodeEntity
public class ComicIssue {
    @Id @GeneratedValue
    private Long neoId;
    @NonNull
    private Long id;
    @NonNull
    private String name, resourceURI, thumbnail;
    @NonNull
    private Integer pageCount;
    @NonNull
    private Double issueNumber;

    @Relationship(type = "INCLUDES")
    public List<Character> characters = new ArrayList<>();

    @Relationship(type = "CREATED_BY")
    public List<Creator> creators = new ArrayList<>();

    @Relationship(type = "PART_OF")
    public List<Event> events = new ArrayList<>();

    @Relationship(type = "BELONGS_TO")
    public List<Series> series = new ArrayList<>();

    @Relationship(type = "MADE_OF")
    public List<Story> stories = new ArrayList<>();

    public List<Character> getCharacters() { return characters; }

    public List<Creator> getCreators() { return creators; }

    public List<Event> getEvents() { return events; }

    public List<Series> getSeries() { return series; }

    public List<Story> getStories() { return stories; }
}
