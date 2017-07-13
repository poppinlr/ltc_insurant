package com.leapstack.ltc.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by zhuochen on 2017/7/12.
 */
@MappedSuperclass
@Data
public class BaseExtendEntity extends BaseEntity{

    @Column(updatable = false)
    private String createdBy;
    private String modifiedBy;
}
