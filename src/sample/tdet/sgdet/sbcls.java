package sample.tdet.sgdet;

import javafx.beans.property.SimpleStringProperty;

public class sbcls {

    public SimpleStringProperty sgn;
    public SimpleStringProperty nos;

    public sbcls() {

    }


    public sbcls(String sgn, String  nos) {
        this.sgn = new SimpleStringProperty(sgn);
        this.nos = new SimpleStringProperty(nos);
    }

    public String getSgn() {
        return sgn.get();
    }


    public void setSgn(String sgn) {
        this.sgn=new SimpleStringProperty(sgn);
    }

    public String getNos() {
        return nos.get();
    }

    public void setNos(String nos) {
        this.nos=new SimpleStringProperty(nos);
    }

}
