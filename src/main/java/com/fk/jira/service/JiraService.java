package com.fk.jira.service;

import com.fk.jira.Exception.ResourceNotFoundException;
import com.fk.jira.dao.Epic;
import com.fk.jira.dto.EpicDto;
import com.fk.jira.dto.EpicDtoList;
import com.fk.jira.repository.EpicRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.fk.jira.Exception.ApiMessageEnum.RESOURCE_NOT_FOUND;

@Service
public class JiraService {

    @Autowired
    EpicRepository epicRepository;

    @Async
    public EpicDto addEpic(EpicDto epicDto) {
        Epic epic = epicRepository.save(Objects.requireNonNull(Epic.from(epicDto)));
        return EpicDto.from(epic);
    }

    public EpicDtoList getEpics() {
        List<Epic> epicList = epicRepository.findAll();
        return EpicDtoList.from(epicList);
    }

    public EpicDto getEpic(String id) {
        Optional<Epic> byId = epicRepository.findById(id);
        if (byId.isPresent()) {
            return EpicDto.from(byId.get());
        } else {
            throw new ResourceNotFoundException(RESOURCE_NOT_FOUND.getCode(), RESOURCE_NOT_FOUND.getReason(), RESOURCE_NOT_FOUND.getMessage());
        }
    }

    public void deleteEpic(String id) {
        epicRepository.deleteById(id);
    }

    public void updateEpic(EpicDto epicDto, String id) {
        Epic epic = epicRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(epicDto, Objects.requireNonNull(epic), getNullPropertyNames(epicDto));

        Epic save = epicRepository.save(epic);
        System.out.println(save);
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }

        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
