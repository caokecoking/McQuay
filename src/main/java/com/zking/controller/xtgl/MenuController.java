package com.zking.controller.xtgl;

import com.zking.pojo.xtgl.*;
import com.zking.service.xtgl.IButtonsService;
import com.zking.service.xtgl.IMenuService;
import com.zking.service.xtgl.ITreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
@RequestMapping("Menu")
public class MenuController {

    @Autowired
    private IMenuService ims;

    @Autowired
    private ITreeService its;

    @Autowired
    private IButtonsService ibs;

    @ResponseBody
    @RequestMapping("findMenuTree")
    public Map findMenuTree(Menu menu) {
        Map<String, Object> map = new HashMap<>();
        List<Tree> lm = ims.findParentMenuAll(menu);
        map.put("data", lm);
        map.put("code", 0);
        map.put("msg", "获取成功");
        return map;
    }

    @ResponseBody
    @RequestMapping("findMenuTree1")
    public Map findMenuTree1(Menu menu) {
        Map<String, Object> map = new HashMap<>();
        List<Tree> lm = ims.findParentMenuAll(menu);
        List<Tree> lm1 = new ArrayList<>();
        for (Tree menu1 : lm) {
            List<Tree> lt = its.findSonMenuButtonByMenuId(menu1.getId());
            if (lt.size() > 0) {
                for (Tree tree : lt) {
                    lm1.add(tree);
                }
            }
        }
        for (Tree menu1 : lm1) {
            lm.add(menu1);
        }
        map.put("data", lm);
        map.put("code", 0);
        map.put("msg", "获取成功");
        return map;
    }

    @ResponseBody
    @RequestMapping("findParentMenuAll1")
    public Map findParentMenuAll1() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", ims.findParentMenuAll1());
        map.put("code", 0);
        return map;
    }

    @ResponseBody
    @RequestMapping("findAllSonMenu")
    public Map findAllSonMenu() {
        Map<String, Object> map = new HashMap<>();
        map.put("data", ims.findAllSonMenu());
        map.put("code", 0);
        return map;
    }

    @ResponseBody
    @RequestMapping("findOnly")
    public Map findOnly(Menu menu) {
        Map<String, Object> map = new HashMap<>();
        map.put("Menu", ims.findOnlyMenu(menu.getMenuId()));
        return map;
    }

    @ResponseBody
    @RequestMapping("addMenu")
    public int addMenu(Menu menu) {
        return ims.addMenu(menu);
    }

    @ResponseBody
    @RequestMapping("removeMenu")
    public int removeMenu(Menu menu) {
        Menu menu1 = ims.findOnlyMenu(menu.getMenuId());
        if (menu1.getMenuParent() == "-1") {
            List<Tree> lt = its.findSonMenuTreeByMCode(menu1.getMenuId());
            for (Tree tree : lt) {
                menu.setMenuId(tree.getId());
                ims.removeMenu(menu);
            }
        }
        return ims.removeMenu(menu1);
    }

    @ResponseBody
    @RequestMapping("editMenu")
    public int editMenu(Menu menu) {
        Menu menu1 = ims.findOnlyMenu(menu.getMenuId());
        if (menu1.getMenuParent().equals("-1") && (!menu.getMenuParent().equals("-1"))) {
            return 0;
        }
        if ((!menu1.getMenuParent().equals("-1")) && menu.getMenuParent().equals("-1")) {
            return 2;
        }
        return ims.editMenu(menu);
    }

    @ResponseBody
    @RequestMapping("pdMenuButton")
    public Map pdMenuButton(String id){
        Map<String, Object> map = new HashMap<>();
        Menu menu=new Menu();
        menu.setMenuId(id);
        if(its.findOnly(menu)!=null){
            map.put("int",0);
        }else{
            map.put("int",1);
        }
        map.put("a",id);
        return map;
    }
}
