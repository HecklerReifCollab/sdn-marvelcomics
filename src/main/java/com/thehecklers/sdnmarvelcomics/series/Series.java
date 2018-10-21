package com.thehecklers.sdnmarvelcomics.series;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@NodeEntity
public class Series {
    @Id @GeneratedValue
    private Long neoId;
    @NonNull
    private Long id;
    @NonNull
    private String name, resourceURI, thumbnail;
    @NonNull
    private Integer startYear, endYear;
}
