package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.IMenuMapper;
import com.zking.pojo.xtgl.Menu;
import com.zking.service.xtgl.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MenuServiceImpl")
public class MenuServiceImpl implements IMenuService{

    @Autowired
    private IMenuMapper imm;

    @Override
    public List<Menu> findParentMenuByJop(String Jop) {
        return imm.findParentMenuByJop(Jop);
    }

    @Override
    public List<Menu> findSonMenuByParent(Menu menu) {
        return imm.findSonMenuByParent(menu);
    }

    @Override
    public List<Menu> findParentMenuAll(String query) {
        return imm.findParentMenuAll(query);
    }

    @Override
    public List<Menu> findSonMenuByPid(String MenuParent) {
        return imm.findSonMenuByPid(MenuParent);
    }

    @Override
    public List<Menu> findParentMenuAll1() {
        return imm.findParentMenuAll1();
    }

    @Override
    public int addMenu(Menu menu) {
        return imm.addMenu(menu);
    }

    @Override
    public int removeMenu(Menu Menu) {
        return imm.removeMenu(Menu);
    }

    @Override
    public int editMenu(Menu menu) {
        return 0;
    }
}
