package sample.tdet;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static sample.setdet.*;


public class Tdet1 implements Initializable {

    @FXML
    AnchorPane t4root;

    @FXML
    TableView<tvteacher> tbv;

    @FXML
    TableColumn<tvteacher,String> tnc;

    @FXML
    TableColumn<tvteacher,String> snc;

    @FXML
    TextField tn;

    @FXML
    TextField sn;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tnc.setCellValueFactory(new PropertyValueFactory<>("Tchn"));
        snc.setCellValueFactory(new PropertyValueFactory<>("Subn"));
        //tbv.setItems(observableList);

    }


    ObservableList<tvteacher> observableList= FXCollections.observableArrayList(
            new tvteacher("tn","sn")
    );


    @FXML
    public void btnclick(ActionEvent event) {

                tvteacher t = new tvteacher();

                for(int i=0;i<tbv.getItems().size();i++) {
                    t=tbv.getItems().get(i);
                    String s=t.subn.get();
                    String[] sa=s.split(",",0);
                    teacher.add(t.tchn.get());
                        teachersubject.add(sa);

                    //System.out.println(teacher.get(i));
                }


              /*  for (int k=0;k<teachersubject.size();k++){
                    for (int l=0;l<teachersubject.get(k).size();l++){
                        System.out.println(teachersubject.get(k).get(l));
                    }
                    System.out.println("\n");
                }  */
                /*    teacher.add(t1n.getText());
                    teachersubject.add(ts1n.getText());


                    teacher.add(t2n.getText());
                    teachersubject.add(ts2n.getText());


                    teacher.add(t3n.getText());
                    teachersubject.add(ts3n.getText());

                    teacher.add(t4n.getText());
                    teachersubject.add(ts4n.getText());*/



        //System.out.println(i.teacher[3].getName());
        AnchorPane mmpane = null;
        //String smp =Integer.toString(nocl);
        String smp1 = "/sample/tdet/sgdet/sg1det.fxml";
        System.out.println(smp1);
        try {
            mmpane = FXMLLoader.load(getClass().getResource(smp1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        t4root.getChildren().setAll(mmpane);

    }

    public void addact(ActionEvent event) {

        tvteacher t=new tvteacher(tn.getText(),sn.getText());
        tbv.getItems().add(t);

    }
}
