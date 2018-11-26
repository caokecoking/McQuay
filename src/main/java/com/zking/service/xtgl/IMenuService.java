package com.zking.service.xtgl;

import com.zking.pojo.xtgl.Menu;

import java.util.List;

public interface IMenuService {
    public List<Menu> findParentMenuByJop(String Jop);

    public List<Menu> findSonMenuByParent(Menu menu);

    public List<Menu> findParentMenuAll(String query);

    public List<Menu> findSonMenuByPid(String MenuParent);
    /**
     * 查询所有的父级菜单
     *
     * @return
     */
    public List<Menu> findParentMenuAll1();

    /**
     * 添加一个menu菜单对象
     *
     * @param menu
     * @return
     */
    public int addMenu(Menu menu);

    /**
     * 判断mparent是否为空来判断它是不是父菜单,如果是就要连带着子菜单一起删除不是的话就只要删除这一个菜单
     *
     * @param mcode
     *            要删除的菜单编号
     * @return
     */
    public int removeMenu(Menu Menu);

    /**
     * 根据判断parentId是否为空来判断编辑的菜单是父菜单还是子菜单
     *
     * @param menu
     *            编辑的菜单对象
     * @return
     */
    public int editMenu(Menu menu);
}
