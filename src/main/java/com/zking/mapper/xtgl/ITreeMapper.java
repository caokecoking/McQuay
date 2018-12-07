package com.zking.mapper.xtgl;

import com.zking.pojo.xtgl.*;

import java.util.List;

public interface ITreeMapper {
    /**
     * 查询所有的父菜单
     *
     * @return
     */
    public List<Tree> findMenuTree();

    /**
     * 删除职位菜单中间表
     */
    public int removeMenuByJop(jopmenu jopmenu);

    /**
     * 增加职位菜单中间表
     */
    public int addMenuByJop(jopmenu jopmenu);

    public List<Tree> findSonMenuTreeByMCode(String MenuId);

    /**
     * 查询子菜单的按钮
     */
    public List<Tree> findSonMenuButtonByMenuId(String a);

    /**
     * 删除职位按钮中间表
     */
    public int removeJopButtons(JopButtons JopButtons);

    /**
     * 增加职位按钮中间表
     */
    public int addJopButtons(JopButtons JopButtons);

    /**
     * 查询menu表单个信息
     */
    public Menu findOnly(Menu menu);

    /**
     * 查询角色表与按钮表所有关系
     */
    public List<Buttons> findButtonsAll(Jop jop);
}
