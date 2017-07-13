package com.leapstack.ltc.entity.menu.auth;

import com.leapstack.ltc.entity.BaseExtendEntity;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Entity
@Data
@Table(name = "role")
@ToString(exclude = "accessEntities")
public class RoleEntity {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "comment")
    private String comment;

    @Column(name = "active", columnDefinition = "TINYINT DEFAULT 0")//default false
    private Boolean active;

    @Column(name = "company_id")
    private Long companyId;

    @ManyToMany(mappedBy = "roleEntities", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AccessEntity> accessEntities;
}
