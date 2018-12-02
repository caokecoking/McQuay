package com.zking.service.impl.xtgl;

import com.zking.mapper.xtgl.IJopMapper;
import com.zking.pojo.xtgl.Jop;
import com.zking.service.xtgl.IJopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("JopServiceImpl")
public class JopServiceImpl implements IJopService{

    @Autowired
    private IJopMapper ijm;

    @Override
    public List<Jop> findLeaveJopId() {
        return ijm.findLeaveJopId();
    }

    @Override
    public List<Jop> findAllByJop(Jop jop) {
        return ijm.findAllByJop(jop);
    }

    @Override
    public Jop findOnlybyJop(Jop jop) {
        return ijm.findOnlybyJop(jop);
    }

    @Override
    public int getMax(Jop jop) {
        return ijm.getMax(jop);
    }

    @Override
    public int addJop(Jop jop) {
        return ijm.addJop(jop);
    }

    @Override
    public int editJop(Jop jop) {
        return ijm.editJop(jop);
    }

    @Override
    public int removeJop(Jop jop) {
        return ijm.removeJop(jop);
    }

    @Override
    public List<Jop> findAllByDeptid(Jop jop) {
        return ijm.findAllByDeptid(jop);
    }
}
