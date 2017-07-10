package leapstack.common;

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
