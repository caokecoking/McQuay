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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("Menu")
public class MenuController {

    @Autowired
    private IMenuService ims;

    @ResponseBody
    @RequestMapping("findParentMenuByJop")
    public List<Menu> findParentMenuByJop(Personnel personnel){
//        List<Menu> lm=null;
//        for (Jop jop : personnel.getSj()) {
//            lm=ims.findParentMenuByJop(jop.getJopId());
//            return lm;
//        }
//        return lm;
        return ims.findParentMenuAll1();
    }

    @ResponseBody
    @RequestMapping("findSonMenuByParent")
    public List<Menu> findSonMenuByParent(Personnel personnel,String endTime){
        List<Menu> lm=null;
        Menu menu=new Menu();
        menu.setEndTime(endTime);
        for (Jop jop : personnel.getSj()) {
            menu.setStartTime(jop.getJopId());
            lm=ims.findSonMenuByParent(menu);
            return lm;
        }
        return lm;
    }

    @RequestMapping("findMenuTreeGrid")
    public List<Menu> findMenuTreeGrid(String query){
        List<Menu> lms = new ArrayList<>();
        List<Menu> lm = ims.findParentMenuAll(query);
        for (Menu menu : lm) {
            lms.add(menu);
            List<Menu> lmm = ims.findSonMenuByPid(menu.getMenuId());
            for (Menu menu2 : lmm) {
                lms.add(menu2);
            }
        }
        return lms;
    }

    @ResponseBody
    @RequestMapping("findParentMenuAll")
    public List<Menu> findParentMenuAll(String addOrEdit){
        List<Menu> lm = ims.findParentMenuAll1();
        if (addOrEdit.equals("add")) {
            Menu m = new Menu();
            m.setMenuId("--请选择父菜单--");
            m.setMenuName("--请选择父菜单--");
            lm.add(0, m);
        }
        return lm;
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
