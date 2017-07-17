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

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private MenuEntity menuEntity;

    @ManyToMany(mappedBy = "accessEntities")
    private List<RoleEntity> roleEntities;

}
