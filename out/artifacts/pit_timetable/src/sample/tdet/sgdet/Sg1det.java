package sample.tdet.sgdet;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import sample.setdet;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.setdet.*;

import javafx.fxml.FXML;


public class Sg1det implements Initializable {

        @FXML
        AnchorPane grdroot;


    @FXML
    TableView<sbcls> tbv;

    @FXML
    TableColumn<sbcls,String> sgn;

    @FXML
    TableColumn<sbcls,String> nos;

    @FXML
    TextField sg;

    @FXML
    TextField no;



        @FXML
        public void btnclick(ActionEvent event) {


            sbcls t = new sbcls();

            for(int i=0;i<tbv.getItems().size();i++) {
                t=tbv.getItems().get(i);
                studentgroup.add(t.sgn.get());
                nosubject.add(t.nos.get());
                System.out.println(studentgroup.get(i));
            }



            //setdet.studentgroup.add(cn1.getText());
            //setdet.nosubject.add(nsc1.getText());


            //System.out.println(temp.name);
            AnchorPane mmpane = null;
            String smp = setdet.nosubject.get(0);
            String smp1 = "/sample/tdet/sgdet/subdet/s1sub4det.fxml";
            try {
                mmpane = FXMLLoader.load(getClass().getResource(smp1));
            } catch (IOException e) {
                e.printStackTrace();
            }
            grdroot.getChildren().setAll(mmpane);

        }

    public void addact(ActionEvent event) {

        sbcls t=new sbcls(sg.getText(),no.getText());
        tbv.getItems().add(t);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        sgn.setCellValueFactory(new PropertyValueFactory<>("Sgn"));
        nos.setCellValueFactory(new PropertyValueFactory<>("Nos"));

    }
}



