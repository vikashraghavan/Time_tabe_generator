package sample.tdet;

import javafx.beans.property.SimpleStringProperty;

public class tvteacher {
    public SimpleStringProperty tchn;
    public SimpleStringProperty subn;

    public tvteacher() {

    }

    public tvteacher(String tchn, String subn) {
        this.tchn = new SimpleStringProperty(tchn) ;
        this.subn = new SimpleStringProperty(subn);
    }


    public String getSubn() {
        return subn.get();
    }

    public void setSubn(String subn) {
        this.subn = new SimpleStringProperty(subn);
    }

    public String getTchn() {
        return tchn.get();
    }

    public void setTchn(String tchn) {
        this.tchn = new SimpleStringProperty(tchn);
    }

}
