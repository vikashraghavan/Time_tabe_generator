package sample.tdet.sgdet.subdet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.setdet.*;

public class Sub4det implements Initializable {
    @FXML
    AnchorPane ap;

    @FXML
    Label lb;

    @FXML
    TableView<smp> tbv;

    @FXML
    TableColumn<smp,String> subnc;

    @FXML
    TableColumn<smp,String> reqhc;

    @FXML
    TextField subn;

    @FXML
    TextField reqh;

    @FXML
    public void btnclick(ActionEvent event) {




        smp t = new smp();

        for(int i=0;i<tbv.getItems().size();i++) {
            t = tbv.getItems().get(i);
            stgrpsubject.add(t.subn.get());
            subjecttime.add(t.reqh.get());
        }

            //int i=0;
            if(nosubject.size()!=setdet.k+1){
                lb.setText("Enter"+nosubject.get(setdet.k+1));

                subn.setPromptText("enter"+nosubject.get(setdet.k+1));
                tbv.getItems().clear();
                System.out.println(setdet.k+" "+nosubject.size());
                setdet.k++;
            //System.out.println(studentgroup.get(i));
        }else {

        /*for (int j = 0; j < 4; j++) {

            switch(j) {
                case 0:
                    setdet.stgrpsubject.add(sn1.getText());
                    setdet.subjecttime.add(s1h.getText());

                case 1:
                    setdet.stgrpsubject.add(sn2.getText());
                    setdet.subjecttime.add(s2h.getText());

                case 2:
                    setdet.stgrpsubject.add(sn3.getText());
                    setdet.subjecttime.add(s3h.getText());

                case 3:
                    setdet.stgrpsubject.add(sn4.getText());
                    setdet.subjecttime.add(s4h.getText());

            }


        }*/


               // setdet s = new setdet();
               // s.putdata();


                AnchorPane mmpane = null;


                try {
                    mmpane = FXMLLoader.load(getClass().getResource("/sample/tdet/sgdet/subdet/fdet.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ap.getChildren().setAll(mmpane);
            }

    }


    public void addact(ActionEvent event) {

        smp t=new smp(subn.getText(),reqh.getText());
        tbv.getItems().add(t);

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        subnc.setCellValueFactory(new PropertyValueFactory<>("Subn"));
        reqhc.setCellValueFactory(new PropertyValueFactory<>("Reqh"));

        lb.setText("Enter"+nosubject.get(0));
        subn.setPromptText("Enter"+nosubject.get(0));


    }

}
