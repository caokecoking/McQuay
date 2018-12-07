package com.zking.service.zlgl;

import com.zking.pojo.zlgl.x_customermessage;

import java.util.List;

public interface ICustomermessageService {
    public List<x_customermessage> FindDateBind();

    public List<x_customermessage> FindCustomermessageAll(x_customermessage customermessage);

    public int FindCustomermessageCount(x_customermessage customermessage);

    public int FindCustomermessageadd(x_customermessage customermessage);

    public int FindCustomermessageEdit(x_customermessage customermessage);

    public int FindCustomermessagereomve(x_customermessage customermessage);

    public x_customermessage FindCustomermessageDateBind(x_customermessage customermessage);

    public List<x_customermessage> FindCustomermessageDateAll();

    public x_customermessage FindCustomermessagesDate(x_customermessage customermessage);
}
