package com.thehecklers.sdnmarvelcomics.comicissue;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@AllArgsConstructor
@Controller
@RequestMapping("/comicissues")
public class ComicIssueController {
    private final ComicIssueService issueService;

    @GetMapping("/findbyname")
    @ResponseBody
    public ComicIssue findByName(@RequestParam String name) {
        return issueService.findByName(name);
    }

    @GetMapping("/findbynamelike")
    @ResponseBody
    public Iterable<ComicIssue> findByNameLike(@RequestParam String name) {
        return issueService.findByNameLike(name);
    }

    @GetMapping("/buildgraph")
    @ResponseBody
    public Map<String, Object> buildgraph(@RequestParam(required = false) Integer limit) {
        return issueService.graph(limit == null ? 100 : limit);
    }

    @GetMapping("/graph")
    public String graph(@RequestParam(required = false) Integer limit, Model model) {
        model.addAttribute(buildgraph(limit));
        return "issuesgraph";
    }
}
