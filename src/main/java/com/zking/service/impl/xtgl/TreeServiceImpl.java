package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.ITreeMapper;
import com.zking.pojo.xtgl.*;
import com.zking.service.xtgl.ITreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("TreeServiceImpl")
public class TreeServiceImpl implements ITreeService{

    @Autowired
    private ITreeMapper itm;

    @Override
    public List<Tree> findMenuTree() {
        return itm.findMenuTree();
    }

    @Override
    public int removeMenuByJop(jopmenu jopmenu) {
        return itm.removeMenuByJop(jopmenu);
    }

    @Override
    public int addMenuByJop(jopmenu jopmenu) {
        return itm.addMenuByJop(jopmenu);
    }

    @Override
    public List<Tree> findSonMenuTreeByMCode(String MenuId) {
        return itm.findSonMenuTreeByMCode(MenuId);
    }

    @Override
    public List<Tree> findSonMenuButtonByMenuId(String MenuId) {
        return itm.findSonMenuButtonByMenuId(MenuId);
    }

    @Override
    public int removeJopButtons(JopButtons JopButtons) {
        return itm.removeJopButtons(JopButtons);
    }

    @Override
    public int addJopButtons(JopButtons JopButtons) {
        return itm.addJopButtons(JopButtons);
    }

    @Override
    public Menu findOnly(Menu menu) {
        return itm.findOnly(menu);
    }

    @Override
    public List<Buttons> findButtonsAll(Jop jop) {
        return itm.findButtonsAll(jop);
    }


}
