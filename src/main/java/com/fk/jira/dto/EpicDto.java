package com.fk.jira.dto;

import com.fk.jira.dao.Epic;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Optional;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EpicDto {
    String id;
    String name;
    String desc;
    StoryPoint storyPoint;

    public static EpicDto from(Epic epic)
    {
        if(ObjectUtils.isEmpty(epic)){
            return null;
        }

        return EpicDto.builder().
                id(epic.getId()).
                name(epic.getName()).
                desc(epic.getDesc()).
                storyPoint(epic.getStoryPoint()).build();
    }
}
