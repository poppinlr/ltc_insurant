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

    @ManyToOne
//    @JoinColumn(name = "menu_id")
    @JoinColumn(name="menu_id",referencedColumnName="menu_id", insertable=false, updatable=false)
    private MenuEntity menuEntity;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "access_role",
            joinColumns = @JoinColumn(name = "access_id", referencedColumnName = "access_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<RoleEntity> roleEntities;
//    @JoinTable(name="access_role",joinColumns=@JoinColumn(name="access_id"),
//            inverseJoinColumns=@JoinColumn(name="role_id"))

}
