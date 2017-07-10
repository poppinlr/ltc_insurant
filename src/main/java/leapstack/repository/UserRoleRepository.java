package leapstack.repository;

import leapstack.entity.UserRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuochen on 2017/7/4.
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>{

    UserRoleEntity findByMobile(String mobile);

    UserRoleEntity findByMobileAndPassword(Long mobile, String password);

}
