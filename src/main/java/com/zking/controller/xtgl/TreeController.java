package com.zking.controller.xtgl;

import com.zking.pojo.xtgl.*;
import com.zking.service.xtgl.IMenuService;
import com.zking.service.xtgl.ITreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("tree")
public class TreeController {

    @Autowired
    private ITreeService its;

    @Autowired
    private IMenuService ims;

    @ResponseBody
    @RequestMapping("findMenuTree")
    public List<Tree> findMenuTree() {
        return its.findMenuTree();
    }

    @ResponseBody
    @RequestMapping("findParentMenuByJop")
    public List<Tree> findParentMenuByJop(Jop Jop) {
        List<Tree> lt = its.findMenuTree();
        List<Menu> lt1 = ims.findParentMenuByJop(Jop);
        List<Buttons> lt2 = its.findButtonsAll(Jop);
        for (Tree tree : lt) {
            for (Menu tree1 : lt1) {
                if (tree.getId().equals(tree1.getMenuId())) {
                    tree.setChecked(true);
                }
                for (Tree menu : tree.getList()) {
                    if (menu.getId().equals(tree1.getMenuId())) {
                        menu.setChecked(true);
                    }
                    for (Tree tree2 : menu.getList()) {
                        for (Buttons buttons : lt2) {
                            if (tree2.getId().equals(buttons.getBid())){
                                tree2.setChecked(true);
                            }
                        }
                    }
                }
            }
        }
        return lt;
    }

    @ResponseBody
    @RequestMapping("addMenuByJop")
    public int addMenuByJop(jopmenu jopmenu) {
        Menu menu = new Menu();
        JopButtons jopButtons = new JopButtons();
        jopButtons.setBid(jopmenu.getMenuId());
        jopButtons.setJobid(jopmenu.getJobid());
        menu.setMenuId(jopmenu.getMenuId());
        if (its.findOnly(menu) != null) {
            its.addMenuByJop(jopmenu);
        } else {
            its.addJopButtons(jopButtons);
        }
        return 1;
    }

    @ResponseBody
    @RequestMapping("removeMenuByJop")
    public int removeMenuByJop(jopmenu jopmenu) {
        JopButtons jopButtons = new JopButtons();
        jopButtons.setBid(jopmenu.getMenuId());
        jopButtons.setJobid(jopmenu.getJobid());
        Menu menu = new Menu();
        menu.setMenuId(jopmenu.getMenuId());
        if (its.findOnly(menu) != null) {
            its.removeMenuByJop(jopmenu);
        } else {
            its.removeJopButtons(jopButtons);
        }
        return 1;
    }
}
