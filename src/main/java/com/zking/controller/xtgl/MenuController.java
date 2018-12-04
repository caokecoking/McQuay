package com.zking.controller.xtgl;

import com.zking.pojo.xtgl.Jop;
import com.zking.pojo.xtgl.Menu;
import com.zking.pojo.xtgl.Personnel;
import com.zking.service.xtgl.IMenuService;
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


    @ResponseBody
    @RequestMapping("findMenuTree")
    public Map findMenuTree1(Menu menu){
        Map<String,Object> map=new HashMap<>();
        map.put("data",ims.findParentMenuAll(menu));
        map.put("code",0);
        map.put("msg","获取成功");
        return map;
    }
    @ResponseBody
    @RequestMapping("findParentMenuAll1")
    public Map findParentMenuAll1(){
        Map<String,Object> map=new HashMap<>();
        map.put("data",ims.findParentMenuAll1());
        map.put("code",0);
        return map;
    }


    @ResponseBody
    @RequestMapping("findOnly")
    public Map findOnly(Menu menu){
        Map<String,Object> map=new HashMap<>();
        map.put("Menu",ims.findSonMenuByPid(menu.getMenuId()));
        return map;
    }
    @ResponseBody
    @RequestMapping("addMenu")
    public int addMenu(Menu menu){
        return ims.addMenu(menu);
    }

    @ResponseBody
    @RequestMapping("removeMenu")
    public int removeMenu(Menu menu){
        if(menu.getMenuParent()==null||menu.getMenuParent()=="") {
            List<Menu> lm = ims.findSonMenuByPid(menu.getMenuParent());
            lm.add(menu);
            for (Menu menu1 : lm) {
                Set<Jop> mp = menu1.getSj();
            }
        }
        return ims.removeMenu(menu);
    }

    @ResponseBody
    @RequestMapping("editMenu")
    public int editMenu(Menu menu){
        return ims.editMenu(menu);
    }
}
