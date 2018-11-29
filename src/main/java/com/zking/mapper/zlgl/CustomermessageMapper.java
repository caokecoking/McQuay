package com.zking.mapper.zlgl;

import com.zking.pojo.zlgl.x_customermessage;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ICustomermessageMapper")
public interface CustomermessageMapper {

    public List<x_customermessage> FindDateBind();

    public List<x_customermessage> FindCustomermessageAll(x_customermessage customermessage);

    public int FindCustomermessageCount(x_customermessage customermessage);

    public int FindCustomermessageadd(x_customermessage customermessage);

    public int FindCustomermessageEdit(x_customermessage customermessage);

    public int FindCustomermessagereomve(x_customermessage customermessage);

    public x_customermessage FindCustomermessageDateBind(x_customermessage customermessage);
}
