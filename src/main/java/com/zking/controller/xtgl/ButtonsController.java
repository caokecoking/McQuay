package com.zking.controller.xtgl;

import com.zking.mapper.xtgl.IButtons;
import com.zking.pojo.xtgl.Buttons;
import com.zking.pojo.xtgl.Tree;
import com.zking.service.xtgl.IButtonsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Button")
public class ButtonsController {

    @Autowired
    private IButtonsService ibs;

    @Autowired
    private IButtons ibm;

    @ResponseBody
    @RequestMapping("add")
    public int add(Buttons buttons){
        ibs.addButtons(buttons);
        buttons.setBid(ibm.findNew());
        ibs.addButtonMenu(buttons);
        return 1;
    }

    @ResponseBody
    @RequestMapping("edit")
    public int edit(Buttons buttons){
        ibs.editButtonMenu(buttons);
        return ibs.editButtons(buttons);
    }

    @ResponseBody
    @RequestMapping("findOnly")
    public Tree findonly(Buttons buttons){
        return ibs.findonly(buttons);
    }
}
