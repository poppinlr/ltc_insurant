package com.leapstack.ltc.entity.menu.auth;

import com.leapstack.ltc.entity.BaseExtendEntity;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
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
@ToString(exclude = {"accessEntities","companyEntity"})
public class RoleEntity {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    @Setter(AccessLevel.NONE)
    private Long roleId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "comment")
    private String comment;

    @Column(name = "active", columnDefinition = "TINYINT DEFAULT 0")//default false
    private Boolean active;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity companyEntity;

    @ManyToMany
    @JoinTable(name = "access_role",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "access_id", referencedColumnName = "access_id"))
    private List<AccessEntity> accessEntities;
}
