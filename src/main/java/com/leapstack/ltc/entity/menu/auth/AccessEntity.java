package com.leapstack.ltc.entity.menu.auth;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Entity
@Data
@Table(name = "access")
@ToString(exclude = {"menuEntity","roleEntities"})
public class AccessEntity{

    @Id
    @GeneratedValue
    @Column(name = "access_id")
    @Setter(AccessLevel.NONE)
    private Long accessId;

    @Column(name = "access_name")
    private String accessName;

    @Column(name = "menu_id")
    private Long menuId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_ id", referencedColumnName = "menu_id")
    private MenuEntity menuEntity;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "access_role",
            joinColumns = @JoinColumn(name = "access_id", referencedColumnName = "access_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<RoleEntity> roleEntities;

}
