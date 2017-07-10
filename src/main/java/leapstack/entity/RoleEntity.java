package leapstack.entity;

import leapstack.common.Creatable;
import leapstack.common.CreatedAtListener;
import leapstack.common.Modifiable;
import leapstack.common.ModifiedAtListener;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by zhuochen on 2017/7/5.
 */
@Entity
@EntityListeners({ModifiedAtListener.class, CreatedAtListener.class})
@Table(name = "role")
@Data
public class RoleEntity extends BaseEntity implements Serializable, Creatable, Modifiable {

    @Id
    @GeneratedValue
    private Long id;

    private String roleName;

    private Integer level;

}
