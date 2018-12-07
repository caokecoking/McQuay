package com.zking.mapper.xtgl;

import com.zking.pojo.xtgl.Jop;

import java.util.List;

public interface IJopMapper {
    // 请假岗位表邦定
    public List<Jop> findLeaveJopId();

    public List<Jop> findAllByJop(Jop jop);

    public Jop findOnlybyJop(Jop jop);

    public int getMax(Jop jop);

    public int addJop(Jop jop);

    public int editJop(Jop jop);

    public int removeJop(Jop jop);

    public List<Jop> findAllByDeptid(Jop jop);
}
