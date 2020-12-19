package com.fk.jira.dao;

import com.fk.jira.dto.EpicDto;
import com.fk.jira.dto.StoryPoint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Epic {
    @Id
    String id;
    String name;
    String desc;
    StoryPoint storyPoint;

    public static Epic from(EpicDto epicDto)
    {
        if(ObjectUtils.isEmpty(epicDto)){
            return null;
        }

        return Epic.builder().
                id(epicDto.getId()).
                name(epicDto.getName()).
                desc(epicDto.getDesc()).
                storyPoint(epicDto.getStoryPoint()).build();
    }

}
