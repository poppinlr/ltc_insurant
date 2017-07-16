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
@Table(name = "company")
@ToString(exclude = "roleEntities")
public class CompanyEntity {

    @Id
    @GeneratedValue
    @Column(name = "company_id")
    @Setter(AccessLevel.NONE)
    private Long companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "level", columnDefinition = "int default 0")
    private Integer level;//0,1,2 --> 总公司,分公司,分支公司

    @Column(name = "parent_id")
    private Long parentId;//TODO verify this.level > parent_level

    @OneToMany(mappedBy = "companyEntity", cascade = CascadeType.ALL)
    private List<RoleEntity> roleEntities;

}
