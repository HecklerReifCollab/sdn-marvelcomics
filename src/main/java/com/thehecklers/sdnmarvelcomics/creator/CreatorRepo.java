package com.thehecklers.sdnmarvelcomics.creator;

import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface CreatorRepo extends Neo4jRepository<Creator, Long> {
}
