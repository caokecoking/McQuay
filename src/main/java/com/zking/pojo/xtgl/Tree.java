package com.zking.pojo.xtgl;

import com.zking.pojo.BasePojo;

import java.util.ArrayList;
import java.util.List;

public class Tree  extends BasePojo {
	/**
	 * 节点id
	 */
	private String id;
	/**
	 * 显示节点文本(也就是名字)
	 */
	private String Name;

	private String mparent;

	private String mpath;
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
	/**
	 * 一个节点数组声明了若干节点
	 */
	private List<Menu> children = new ArrayList<>();

	public Tree() {
	}

	public Tree(String id, String name, String mparent, String mpath, String state, boolean checked, String attributes, List<Menu> children) {
		this.id = id;
		Name = name;
		this.mparent = mparent;
		this.mpath = mpath;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

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
}
