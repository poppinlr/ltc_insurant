package leapstack.common;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * Created by zhuochen on 2017/7/5.
 */
public class ModifiedAtListener {

    @PreUpdate
    @PrePersist
    public void setModifiedAt(final Modifiable entity) {
        entity.setModifiedAt(new Date());
    }

}
