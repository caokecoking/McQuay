package com.zking.mapper.xtgl;

import com.zking.pojo.xtgl.Menu;
import com.zking.pojo.xtgl.Tree;

import java.util.List;

public interface ITreeMapper {
    /**
     * 查询所有的父菜单
     *
     * @return
     */
    public List<Tree> findMenuTree();

    /**
     * 在职位菜单表中根据职位编码查询所有的菜单编码
     *
     * @param pcode
     *            职位编码
     * @return
     */
    public List<String> findPostMenuMCodeByPCode(String pcode);

    /**
     * 根据职位编号和菜单编号来查询职位菜单表
     *
     * @param pcode
     *            职位编号
     * @param mcode
     *            菜单编号
     * @return
     */
    public String findPostMenuByPCodeAndMCode(String pcode, String mcode);

    /**
     * 根据菜单编号来查询它的父级菜单
     *
     * @param mcode
     *            菜单编码
     * @return
     */
    public String findMenuMParentByMCode(String mcode);

    /**
     * 根据菜单编码来查询它所拥有的所有的子菜单的菜单编码再加上本身的菜单编码
     *
     * @param mcode
     *            菜单编码
     * @return
     */
    public List<String> findSonMenuMCodeByMCode(String mcode);

    /**
     * 删除职位菜单中间表
     *
     * @param pcode
     *            职位编码
     * @param mcode
     *            菜单编码
     * @return
     */
    public String removePostMenu(String pcode, String mcode);

    /**
     * 查询根据父菜单为mparent和职位编码为pcode的职位菜单表中有多少条记录
     *
     * @param pcode
     *            职位编码
     * @param mparent
     *            父级菜单编码
     * @return
     */
    public int findPostMenuCountByPCodeAndMParent(String pcode, String mparent);

    /**
     * 增加职位菜单中间表
     *
     * @param pcode
     *            职位编码
     * @param mcode
     *            菜单编码
     * @return
     */
    public String addPostMenu(String pcode, String mcode);

    /**
     * 查询该mcode父菜单编号是否拥有子菜单
     *
     * @param mcode
     * @return
     */
    public int findSonMenuCountByMParent(String mcode);

    public List<Menu> findSonMenuTreeByMCode(String MenuId);
}
