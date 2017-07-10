package leapstack.repository;

import leapstack.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.management.relation.Role;

/**
 * Created by zhuochen on 2017/7/6.
 */
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long>{

    RoleEntity findById(Long id);
}
