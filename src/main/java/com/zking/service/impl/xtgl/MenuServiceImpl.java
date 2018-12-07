package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.IMenuMapper;
import com.zking.pojo.xtgl.Jop;
import com.zking.pojo.xtgl.Menu;
import com.zking.pojo.xtgl.Tree;
import com.zking.service.xtgl.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("MenuServiceImpl")
public class MenuServiceImpl implements IMenuService{

    @Autowired
    private IMenuMapper imm;

    @Override
    public List<Menu> findParentMenuByJop(Jop Jop) {
        return imm.findParentMenuByJop(Jop);
    }

    @Override
    public List<Menu> findSonMenuByParent(Menu menu) {
        return imm.findSonMenuByParent(menu);
    }

    @Override
    public List<Tree> findParentMenuAll(Menu menu) {
        return imm.findParentMenuAll(menu);
    }

    @Override
    public Menu findOnlyMenu(String MenuParent) {
        return imm.findOnlyMenu(MenuParent);
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
        return imm.editMenu(menu);
    }

    @Override
    public List<Menu> findAllSonMenu() {
        return imm.findAllSonMenu();
    }
}
