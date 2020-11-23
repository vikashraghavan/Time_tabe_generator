package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class Controller {

    @FXML
    AnchorPane root;

    @FXML
    TextField not;

    @FXML
    TextField nop;

    @FXML
    TextField noc;

    @FXML
    public void btnclick(ActionEvent event) {
        setdet s=new setdet();
        s.mf();
        /*setdet.hoursperday=nop.getText();
        //i.noteacher=Integer.parseInt(not.getText());
        setdet.nocl=Integer.parseInt(noc.getText());
        //System.out.println(i.hoursperday+" "+i.noteacher+" "+i.nostudentgroup);
        AnchorPane mpane = null;
        try {
            mpane = FXMLLoader.load(getClass().getResource("/sample.tdet/tdet4.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        root.getChildren().setAll(mpane);*/

    }
    

}
