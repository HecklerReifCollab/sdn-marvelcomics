package com.thehecklers.sdnmarvelcomics.comicissue;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface ComicIssueRepo extends Neo4jRepository<ComicIssue, Long> {
    ComicIssue findByName(String name);

    Iterable<ComicIssue> findByNameLike(String name);

    @Query("MATCH (i:ComicIssue)-[r]-(n) RETURN i, r, n LIMIT {limit}")
    Collection<ComicIssue> graph(@Param("limit") int limit);
}
