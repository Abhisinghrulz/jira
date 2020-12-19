package com.fk.jira.dto;

import com.fk.jira.dao.Epic;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpicDtoList {
    List<EpicDto> epicDtoList;

    public static EpicDtoList from(List<Epic> epicList){
        return EpicDtoList.builder().epicDtoList(epicList.stream().map(epic -> EpicDto.from(epic)).collect(Collectors.toList())).build();
    }
}
