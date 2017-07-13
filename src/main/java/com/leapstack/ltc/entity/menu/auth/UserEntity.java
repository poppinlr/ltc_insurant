package com.leapstack.ltc.entity.menu.auth;

import com.leapstack.ltc.entity.BaseExtendEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Entity
@Data
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "role_id")
    private Long roleId;
}
