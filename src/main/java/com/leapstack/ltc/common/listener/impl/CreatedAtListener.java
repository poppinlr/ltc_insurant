package com.leapstack.ltc.common.listener.impl;

import com.leapstack.ltc.common.listener.Creatable;

import javax.persistence.PrePersist;
import java.util.Date;

/**
 * Created by zhuochen on 2017/7/5.
 */
public class CreatedAtListener {

    @PrePersist
    public void setCreatedAt(final Creatable entity) {
        entity.setCreatedAt(new Date());
    }
}
