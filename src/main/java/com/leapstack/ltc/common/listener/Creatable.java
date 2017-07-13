package com.leapstack.ltc.common.listener;

import java.util.Date;

/**
 * Created by zhuochen on 2017/7/5.
 */
public interface Creatable {
    void setCreatedAt(final Date date);
    Date getCreatedAt();
}
