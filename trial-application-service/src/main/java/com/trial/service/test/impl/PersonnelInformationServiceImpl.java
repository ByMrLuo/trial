package com.trial.service.test.impl;

import com.trial.mapper.PersonnelInformationMapper;
import com.trial.pojo.PersonnelInformation;
import com.trial.service.test.PersonnelInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @date: 2020/7/15 10:26
 * @author: luoziwen
 */
@Service
public class PersonnelInformationServiceImpl implements PersonnelInformationService {

    @Autowired
    private PersonnelInformationMapper personnelInformationMapper;

    @Override
    public PersonnelInformation select() {
        PersonnelInformation personnelInformation = personnelInformationMapper.select();
        return personnelInformation;
    }
}