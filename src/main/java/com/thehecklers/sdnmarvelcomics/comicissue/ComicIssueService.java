package com.thehecklers.sdnmarvelcomics.comicissue;

import com.thehecklers.sdnmarvelcomics.character.Character;
import com.thehecklers.sdnmarvelcomics.creator.Creator;
import com.thehecklers.sdnmarvelcomics.event.Event;
import com.thehecklers.sdnmarvelcomics.series.Series;
import com.thehecklers.sdnmarvelcomics.story.Story;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ComicIssueService {
    private final ComicIssueRepo issueRepo;

    public ComicIssueService(ComicIssueRepo issueRepo) { this.issueRepo = issueRepo; }

    private Map<String, Object> toD3Format(Collection<ComicIssue> issues) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<ComicIssue> result = issues.iterator();
        while (result.hasNext()) {
            ComicIssue issue = result.next();
            nodes.add(map("name", issue.getName(), "label", "issue"));
            int target = i;
            i++;
            for (Character character : issue.getCharacters()) {
                Map<String, Object> comicChar = map("name", character.getName(), "label", "character");
                int source = nodes.indexOf(comicChar);
                if (source == -1) {
                    nodes.add(comicChar);
                    source = i++;
                }

                rels.add(map("source", source, "target", target));
            }
            for (Creator creator : issue.getCreators()) {
                Map<String, Object> comicCre = map("name", creator.getName(), "label", "creator");
                int source = nodes.indexOf(comicCre);
                if (source == -1) {
                    nodes.add(comicCre);
                    source = i++;
                }

                rels.add(map("source", source, "target", target));
            }
            for (Series series : issue.getSeries()) {
                Map<String, Object> comicSeries = map("name", series.getName(), "label", "series");
                int source = nodes.indexOf(comicSeries);
                if (source == -1) {
                    nodes.add(comicSeries);
                    source = i++;
                }

                rels.add(map("source", source, "target", target));
            }
            for (Story story : issue.getStories()) {
                Map<String, Object> comicStor = map("name", story.getName(), "label", "story");
                int source = nodes.indexOf(comicStor);
                if (source == -1) {
                    nodes.add(comicStor);
                    source = i++;
                }

                rels.add(map("source", source, "target", target));
            }
            for (Event event : issue.getEvents()) {
                Map<String, Object> comicEvent = map("name", event.getName(), "label", "event");
                int source = nodes.indexOf(comicEvent);
                if (source == -1) {
                    nodes.add(comicEvent);
                    source = i++;
                }

                rels.add(map("source", source, "target", target));
            }
        }
        return map("nodes", nodes, "links", rels);
    }

    private Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

    @Transactional(readOnly = true)
    public Iterable<ComicIssue> findAllComicIssues() { return issueRepo.findAll(); }

    @Transactional(readOnly = true)
    public ComicIssue findByName(String name) { return issueRepo.findByName(name); }

    @Transactional(readOnly = true)
    public Iterable<ComicIssue> findByNameLike(String name) { return issueRepo.findByNameLike(name); }

    @Transactional(readOnly = true)
    public Map<String, Object> graph(int limit) { return toD3Format(issueRepo.graph(limit)); }
}
