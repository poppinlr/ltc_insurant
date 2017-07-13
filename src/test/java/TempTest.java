import com.leapstack.ltc.Application;
import com.leapstack.ltc.entity.menu.auth.AccessEntity;
import com.leapstack.ltc.entity.menu.auth.MenuEntity;
import com.leapstack.ltc.entity.menu.auth.RoleEntity;
import com.leapstack.ltc.repository.menu.auth.AccessEntityRepository;
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

    @Test
    public void testContact(){
        menuService.getAllMenuService();
    }

    @Test
    public void generate(){
        MenuEntity menuEntity = new MenuEntity();
//        menuEntity.setLevel(2);
        menuEntity.setMenuName("menu2");
        menuEntity.setUrl("/");

        menuEntityRepository.save(menuEntity);
    }

    @Test
    public void generate2(){
        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setAccessName("access2");
        accessEntityRepository.save(accessEntity);
    }

    @Test
    public void manytomanytest(){
        AccessEntity accessEntity = new AccessEntity();
        accessEntity.setAccessName("accesstest");
        ArrayList<AccessEntity> accessEntities = new ArrayList<>();
        accessEntities.add(accessEntity);

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleName("role1");
        roleEntity.setActive(true);
        roleEntity.setComment("comment");
        roleEntity.setAccessEntities(accessEntities);

        roleEntityRepository.save(roleEntity);
    }

    @Test
    public void getAllAccess(){
        List<AccessEntity> list = accessEntityRepository.findAll();
        log.info(list.size());
    }
}
