package sample.tdet.sgdet.subdet;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
import java.util.ArrayList;
import java.util.ResourceBundle;

import static sample.setdet.*;

public class Fdet implements Initializable {

    @FXML
    AnchorPane ap;

    @FXML
    TableView<fdethld> tbv;

    @FXML
    TableColumn<fdethld,String> clsc;



    @FXML
    TableColumn<fdethld,String> pnoc;

    @FXML
    TableColumn<fdethld,String> subc;

    @FXML
    TextField clstf;



    @FXML
    TextField pnotf;

    @FXML
    TextField subtf;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        clsc.setCellValueFactory(new PropertyValueFactory<>("Cls"));
      //  dayc.setCellValueFactory(new PropertyValueFactory<>("Day"));
        pnoc.setCellValueFactory(new PropertyValueFactory<>("Pno"));
        subc.setCellValueFactory(new PropertyValueFactory<>("Sub"));

        //lb.setText("Enter"+nosubject.get(0));
        //subn.setPromptText("Enter"+nosubject.get(0))
    }

    public void addact(ActionEvent event) {

        fdethld t=new fdethld(clstf.getText(),pnotf.getText(),subtf.getText());
        tbv.getItems().add(t);

    }


    @FXML
    public void btnclick(ActionEvent event) {


        for (int v=0;v<studentgroup.size();v++){

        }

        fdethld t = new fdethld();

        for(int i=0;i<tbv.getItems().size();i++) {
            t = tbv.getItems().get(i);
            fdet.add(new ArrayList<>());
            fdet.get(i).add(t.cls.get());
            //fdet.get(i).add(t.day.get());
            fdet.get(i).add(t.sub.get());
            fdet.get(i).add(t.pno.get());
        }

        setdet s=new setdet();
        s.putdata();

        AnchorPane mmpane = null;


            try {
                mmpane = FXMLLoader.load(getClass().getResource("/sample/finalview.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ap.getChildren().setAll(mmpane);
        }

    }


