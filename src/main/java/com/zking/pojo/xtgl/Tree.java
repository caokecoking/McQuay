package com.zking.pojo.xtgl;

import com.zking.pojo.BasePojo;

import java.util.ArrayList;
import java.util.List;

public class Tree  extends BasePojo {
	/**
	 * 节点id
	 */
	private String id;
	private String value;
	/**
	 * 显示节点文本(也就是名字)
	 */
	private String Name;

	private String mparent;

	private String mpath;

	private String parentId;
	/**
	 * 节点状态(open或closed 默认:open 如果为closed的时候，将不自动展开该节点)
	 */
	private String state;
	/**
	 * 表示该节点是否被选中(true和false)
	 */
	private boolean checked;
	/**
	 * 被添加到节点的自定义属性
	 */
	private String attributes;

	private String menuId;
	/**
	 * 一个节点数组声明了若干节点
	 */
	private List<Menu> children;
    private List<Tree> list;

	public Tree() {
	}

	public Tree(String id, String value, String name, String mparent, String mpath, String parentId, String state, boolean checked, String attributes, List<Menu> children, List<Tree> list) {
		this.id = id;
		this.value = value;
		Name = name;
		this.mparent = mparent;
		this.mpath = mpath;
		this.parentId = parentId;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
		this.list = list;
	}

	public String getId() {
		return id;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String getName() {
		return Name;
	}

	@Override
	public void setName(String name) {
		Name = name;
	}

	public String getMparent() {
		return mparent;
	}

	public void setMparent(String mparent) {
		this.mparent = mparent;
	}

	public String getMpath() {
		return mpath;
	}

	public void setMpath(String mpath) {
		this.mpath = mpath;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	public List<Menu> getChildren() {
		return children;
	}

	public void setChildren(List<Menu> children) {
		this.children = children;
	}

	public List<Tree> getList() {
		return list;
	}

	public void setList(List<Tree> list) {
		this.list = list;
	}
}
