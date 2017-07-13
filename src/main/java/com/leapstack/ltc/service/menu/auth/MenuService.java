package com.leapstack.ltc.service.menu.auth;

import com.leapstack.ltc.entity.menu.auth.MenuEntity;
import com.leapstack.ltc.repository.menu.auth.MenuEntityRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Service
@Log4j
public class MenuService {

    @Autowired
    private MenuEntityRepository menuEntityRepository;

    public void getAllMenuService(){
        List<MenuEntity> menuEntities = menuEntityRepository.findAll();
        log.info(menuEntities.get(0));
    }
}
