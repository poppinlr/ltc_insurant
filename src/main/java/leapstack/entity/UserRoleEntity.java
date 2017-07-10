package leapstack.entity;

import leapstack.common.Creatable;
import leapstack.common.CreatedAtListener;
import leapstack.common.Modifiable;
import leapstack.common.ModifiedAtListener;
import leapstack.constant.DatabaseConstant;
import lombok.Data;
import org.hibernate.annotations.ColumnTransformer;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by zhuochen on 2017/7/4.
 */
@Entity
@EntityListeners({ModifiedAtListener.class, CreatedAtListener.class})
@Table(name = "user_role")
@Data
public class UserRoleEntity extends BaseEntity implements Serializable, Creatable, Modifiable {

    @Id
    @GeneratedValue
    private Long id;

    private String mobile;

    @Column(name="password")
    @ColumnTransformer(
            read= "AES_DECRYPT(password, '"+ DatabaseConstant.ENCRYPTION_KEY +"')",
            write = "AES_ENCRYPT(?, '"+ DatabaseConstant.ENCRYPTION_KEY +"')")
    private String password;

    private Integer roleId;

}
