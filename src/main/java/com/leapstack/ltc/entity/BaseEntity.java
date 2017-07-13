package com.leapstack.ltc.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by zhuochen on 2017/7/5.
 */
@MappedSuperclass
@Data
public class BaseEntity {

    @Column(updatable = false)
    private Date createdAt;
    private Date modifiedAt;
}
