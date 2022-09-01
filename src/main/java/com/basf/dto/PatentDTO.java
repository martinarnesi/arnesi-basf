package com.basf.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PatentDTO {
    //Todo extract year, title, and abstract from each XML patent
    // (just pick some appropriate xml field)

    private String identifier;
    private String year;
    private String title;
    private String abstractData;
}
