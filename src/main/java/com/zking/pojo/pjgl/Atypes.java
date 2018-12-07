package com.zking.pojo.pjgl;

import java.io.Serializable;

public class Atypes  implements Serializable {
    private String Atid;
    private String Atname;

    public Atypes() {
        super();
    }

    public String getAtid() {
        return Atid;
    }

    public void setAtid(String atid) {
        Atid = atid;
    }

    public String getAtname() {
        return Atname;
    }

    public void setAtname(String atname) {
        Atname = atname;
    }


}
