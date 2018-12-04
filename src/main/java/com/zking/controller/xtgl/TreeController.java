package com.zking.controller.xtgl;

import com.zking.pojo.xtgl.Tree;
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
    public List<Tree> findMenuTree(){
        return its.findMenuTree();
    }



}
