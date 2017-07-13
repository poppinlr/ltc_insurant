package com.leapstack.ltc.common.listener;

import java.util.Date;

/**
 * Created by zhuochen on 2017/7/5.
 */
public interface Modifiable {
    void setModifiedAt(final Date date);
    Date getModifiedAt();

}
