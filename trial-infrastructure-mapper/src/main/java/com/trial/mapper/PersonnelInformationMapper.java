package com.trial.mapper;

import com.trial.pojo.PersonnelInformation;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: 人员信息类
 * @date: 2020/7/15 10:05
 * @author: luoziwen
 */
@Mapper
public interface PersonnelInformationMapper {

    PersonnelInformation select();
}
