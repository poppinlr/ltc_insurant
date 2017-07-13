package com.leapstack.ltc.entity.menu.auth;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by zhuochen on 2017/7/13.
 */
@Entity
@Table(name = "access_role")
@Data
public class AccessRoleEntity {

    @Id
    @GeneratedValue
    @Column(name = "access_role_id")
    private Long accessRoleId;

    @Column(name = "access_id")
    private Long accessId;

    @Column(name = "role_d")
    private Long roleId;
}
