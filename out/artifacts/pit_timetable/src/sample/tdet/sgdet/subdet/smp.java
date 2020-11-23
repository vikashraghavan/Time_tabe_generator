package sample.tdet.sgdet.subdet;

import javafx.beans.property.SimpleStringProperty;

public class smp {

    public SimpleStringProperty subn;
    public SimpleStringProperty reqh;

    public smp() {

    }

    public smp(String  subn, String reqh) {
        this.subn =new SimpleStringProperty(subn);
        this.reqh =new SimpleStringProperty(reqh);
    }

    public String getSubn() {
        return subn.get();
    }

    public void setSubn(String subn) {
        this.subn=new SimpleStringProperty(subn);
    }

    public String getReqh() {
        return reqh.get();
    }

    public void setReqh(String reqh) {
        this.reqh=new SimpleStringProperty(reqh);
    }
}
