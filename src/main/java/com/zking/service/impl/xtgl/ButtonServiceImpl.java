package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.IButtons;
import com.zking.pojo.xtgl.Buttons;
import com.zking.pojo.xtgl.Tree;
import com.zking.service.xtgl.IButtonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ButtonServiceImpl")
public class ButtonServiceImpl implements IButtonsService{

    @Autowired
    private IButtons ibs;

    @Override
    public int addButtons(Buttons buttons) {
        return ibs.addButtons(buttons);
    }

    @Override
    public int editButtons(Buttons buttons) {
        return ibs.editButtons(buttons);
    }

    @Override
    public int removeButtons(Buttons buttons) {
        return ibs.removeButtons(buttons);
    }

    @Override
    public int addButtonMenu(Buttons buttons) {
        return ibs.addButtonMenu(buttons);
    }

    @Override
    public int removeButtonMenu(Buttons buttons) {
        return ibs.removeButtonMenu(buttons);
    }

    @Override
    public Tree findonly(Buttons buttons) {
        return ibs.findonly(buttons);
    }

    @Override
    public int editButtonMenu(Buttons buttons) {
        return ibs.editButtonMenu(buttons);
    }

    @Override
    public List<Buttons> findButtonsByPersCoding(String PersCoding) {
        return ibs.findButtonsByPersCoding(PersCoding);
    }
}
