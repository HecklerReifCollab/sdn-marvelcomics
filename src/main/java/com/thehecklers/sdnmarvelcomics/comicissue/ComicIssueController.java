package com.thehecklers.sdnmarvelcomics.comicissue;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/comicissues")
public class ComicIssueController {
    private final ComicIssueService issueService;

    public ComicIssueController(ComicIssueService issueService) { this.issueService = issueService; }

    @GetMapping("/findbyname")
    @ResponseBody
    public ComicIssue findByName(@RequestParam(required = false) String name) {
        if (name == null) {
            return issueService.findAllComicIssues().iterator().next();
        } else {
            return issueService.findByName(name);
        }
    }

    @GetMapping("/findbynamelike")
    @ResponseBody
    public Iterable<ComicIssue> findByNameLike(@RequestParam(required = false) String name) {
        return issueService.findByNameLike(name);
    }

    @GetMapping("/buildgraph")
    @ResponseBody
    public Map<String, Object> buildgraph(@RequestParam(value = "limit",required = false) Integer limit) {
        return issueService.graph(limit == null ? 100 : limit);
    }

    @GetMapping("/graph")
    public String getGraphPage(@RequestParam(value = "limit",required = false) Integer limit, Model model) {
        model.addAttribute(buildgraph(limit));
        return "issuesgraph";
    }

}
