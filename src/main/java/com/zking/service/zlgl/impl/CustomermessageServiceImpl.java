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
    @Resource(name = "ICustomermessageMapper")
    private CustomermessageMapper cm;

    @Override
    public List<x_customermessage> FindDateBind() {
        return cm.FindDateBind();
    }

    @Override
    public List<x_customermessage> FindCustomermessageAll(x_customermessage customermessage) {
        return cm.FindCustomermessageAll(customermessage);
    }

    @Override
    public int FindCustomermessageCount(x_customermessage customermessage) {
        return cm.FindCustomermessageCount(customermessage);
    }

    @Override
    public int FindCustomermessageadd(x_customermessage customermessage) {
        return cm.FindCustomermessageadd(customermessage);
    }

    @Override
    public int FindCustomermessageEdit(x_customermessage customermessage) {
        return cm.FindCustomermessageEdit(customermessage);
    }

    @Override
    public int FindCustomermessagereomve(x_customermessage customermessage) {
        return cm.FindCustomermessagereomve(customermessage);
    }

    public x_customermessage FindCustomermessageDateBind(x_customermessage customermessage) {
        return cm.FindCustomermessageDateBind(customermessage);
    }
}
