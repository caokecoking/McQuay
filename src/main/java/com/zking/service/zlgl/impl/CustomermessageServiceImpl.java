package com.zking.service.zlgl.impl;

import com.zking.service.zlgl.ICustomermessageService;
import com.zking.mapper.zlgl.CustomermessageMapper;
import com.zking.pojo.zlgl.x_customermessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("ICustomermessageServiceImpl")
public class CustomermessageServiceImpl implements ICustomermessageService {
    @Autowired
    private CustomermessageMapper cm;

    @Override
    public List<x_customermessage> FindDateBind() {
        return cm.FindDateBind();
    }
}
