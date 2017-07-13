package com.leapstack.ltc.entity.menu.auth;

import com.leapstack.ltc.entity.BaseEntity;
import com.leapstack.ltc.entity.BaseExtendEntity;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Entity
@Data
@Table(name = "menu")
@ToString(exclude = "accessEntities")
public class MenuEntity{

    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    @Setter(AccessLevel.NONE)
    private Long menuId;

    @Column(name = "menu_name")
    private String menuName;

//    @Column(name = "level", columnDefinition = "INT DEFAULT 0")
//    private Integer level;//1,2 --> 一级菜单,二级菜单

    @Column(name = "parent_id")
    private Long parentId;//TODO verify

    @Column(name = "url")
    private String url;

    @OneToMany(mappedBy = "menuEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AccessEntity> accessEntities;
}
