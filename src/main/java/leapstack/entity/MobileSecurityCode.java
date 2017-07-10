package leapstack.entity;

import leapstack.common.Creatable;
import leapstack.common.CreatedAtListener;
import leapstack.common.Modifiable;
import leapstack.common.ModifiedAtListener;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by zhuochen on 2017/7/5.
 */
@Entity
@EntityListeners({ModifiedAtListener.class, CreatedAtListener.class})
@Table(name = "mobileSecurityCode")
@Data
public class MobileSecurityCode extends BaseEntity implements Serializable, Creatable, Modifiable{

    @Id
    private Long mobile;

    private int securityCode;
}
