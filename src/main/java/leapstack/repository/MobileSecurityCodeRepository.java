package leapstack.repository;

import leapstack.entity.MobileSecurityCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuochen on 2017/7/5.
 */
@Repository
public interface MobileSecurityCodeRepository extends JpaRepository<MobileSecurityCode,Long>{

    MobileSecurityCode findByMobile(Long mobile);

    MobileSecurityCode findByMobileAndSecurityCode(Long mobile, String securityCode);
}
