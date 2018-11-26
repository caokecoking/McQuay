package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.ITreeMapper;
import com.zking.pojo.xtgl.Tree;
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
    public List<String> findPostMenuMCodeByPCode(String pcode) {
        return itm.findPostMenuMCodeByPCode(pcode);
    }

    @Override
    public String findPostMenuByPCodeAndMCode(String pcode, String mcode) {
        return itm.findPostMenuByPCodeAndMCode(pcode,mcode);
    }

    @Override
    public String findMenuMParentByMCode(String mcode) {
        return itm.findMenuMParentByMCode(mcode);
    }

    @Override
    public List<String> findSonMenuMCodeByMCode(String mcode) {
        return itm.findSonMenuMCodeByMCode(mcode);
    }

    @Override
    public String removePostMenu(String pcode, String mcode) {
        return itm.removePostMenu(pcode,mcode);
    }

    @Override
    public int findPostMenuCountByPCodeAndMParent(String pcode, String mparent) {
        return itm.findPostMenuCountByPCodeAndMParent(pcode,mparent);
    }

    @Override
    public String addPostMenu(String pcode, String mcode) {
        return itm.addPostMenu(pcode,mcode);
    }

    @Override
    public int findSonMenuCountByMParent(String mcode) {
        return itm.findSonMenuCountByMParent(mcode);
    }
}
