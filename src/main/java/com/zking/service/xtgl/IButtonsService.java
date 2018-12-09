package com.zking.service.xtgl;

import com.zking.pojo.xtgl.Buttons;
import com.zking.pojo.xtgl.Tree;

import java.util.List;

public interface IButtonsService {
    public int addButtons(Buttons buttons);

    public int editButtons(Buttons buttons);

    public int removeButtons(Buttons buttons);

    public int addButtonMenu(Buttons buttons);

    public int removeButtonMenu(Buttons buttons);

    public Tree findonly(Buttons buttons);
    public int editButtonMenu(Buttons buttons);

    public List<Buttons> findButtonsByPersCoding(String PersCoding);
}
