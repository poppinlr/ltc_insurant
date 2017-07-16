import com.google.common.collect.Lists;
import com.leapstack.ltc.Application;
import com.leapstack.ltc.entity.menu.auth.AccessEntity;
import com.leapstack.ltc.entity.menu.auth.CompanyEntity;
import com.leapstack.ltc.entity.menu.auth.MenuEntity;
import com.leapstack.ltc.entity.menu.auth.RoleEntity;
import com.leapstack.ltc.repository.menu.auth.AccessEntityRepository;
import com.leapstack.ltc.repository.menu.auth.CompanyEntityRepository;
import com.leapstack.ltc.repository.menu.auth.MenuEntityRepository;
import com.leapstack.ltc.repository.menu.auth.RoleEntityRepository;
import com.leapstack.ltc.service.menu.auth.MenuService;
import io.swagger.models.Contact;
import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.Access;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@Log4j
public class TempTest {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuEntityRepository menuEntityRepository;

    @Autowired
    private AccessEntityRepository accessEntityRepository;

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Autowired
    private CompanyEntityRepository companyEntityRepository;

    @Test
    public void saveMenu(){
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setMenuName("menuName");
        menuEntity.setUrl("/");
        menuEntityRepository.save(menuEntity);
    }

    @Test
    @Transactional
    public void getMenu(){
        menuEntityRepository.findAll();
    }

    @Test
    @Transactional
    public void saveAccess(){
        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setAccessName("accessName");
        accessEntity.setMenuId(1L);

        accessEntityRepository.save(accessEntity);
    }

    @Test
    @Transactional
    public void saveMenuDependOnAccess() {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setMenuName("menuDep");
        menuEntity.setUrl("/");

//        menuEntityRepository.save(menuEntity);

        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setAccessName("accessNameDep");
        accessEntity.setMenuEntity(menuEntity);

        accessEntityRepository.save(accessEntity);
    }

    @Test
    public void getAccess(){
        MenuEntity menuEntity = accessEntityRepository.findOne(1L).getMenuEntity();
        log.info(menuEntity.getMenuId());
    }

}
