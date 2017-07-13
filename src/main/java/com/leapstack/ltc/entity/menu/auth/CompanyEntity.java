package com.leapstack.ltc.entity.menu.auth;

import com.leapstack.ltc.entity.BaseExtendEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Entity
@Data
@Table(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "level", columnDefinition = "int default 0")
    private Integer level;//0,1,2 --> 总公司,分公司,分支公司

    @Column(name = "parent_id")
    private Long parentId;//TODO verify this.level > parent_level

}
