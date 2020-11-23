package sample.tdet.sgdet.subdet;

import javafx.beans.property.SimpleStringProperty;

public class fdethld {

    public SimpleStringProperty cls;

    public SimpleStringProperty pno;
    public SimpleStringProperty sub;

    public fdethld(String cls,  String pno, String sub) {
        this.cls =new SimpleStringProperty(cls);

        this.pno =new SimpleStringProperty(pno);
        this.sub =new SimpleStringProperty(sub);
    }

    public fdethld() {
    }

    public String getCls() {
        return cls.get();
    }

    public void setCls(String cls) {
        this.cls=new SimpleStringProperty(cls);
    }



    public String getPno() {
        return pno.get();
    }

    public void setPno(String pno) {
        this.pno=new SimpleStringProperty(pno);
    }

    public String getSub() {
        return sub.get();
    }

    public void setSub(String sub) {
        this.sub=new SimpleStringProperty(sub);
    }
}
