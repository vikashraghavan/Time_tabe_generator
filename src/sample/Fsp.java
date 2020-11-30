package sample;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Fsp implements Initializable {
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("\nini\n");
    }

    @FXML
    AnchorPane rot;


    @FXML
    Label fllb;


    ProgressIndicator PI=new ProgressIndicator();

    public void upbtn(ActionEvent event) {
        FileChooser fc=new FileChooser();
        fc.setInitialDirectory(new File("\\"));
        File sf=fc.showOpenDialog(null);
        if(sf!=null){
            fllb.setText("Uploaded successfully "+sf.getName());
            readexcel.pth=sf.getAbsolutePath();
        }else{
            fllb.setText("Please try again");
        }
    }

    public void btnclick(ActionEvent event) {

        //setdet.hoursperday=nop.getText();
        //i.noteacher=Integer.parseInt(not.getText());
        //setdet.nocl=Integer.parseInt(noc.getText());
        //System.out.println(i.hoursperday+" "+i.noteacher+" "+i.nostudentgroup);



        Task<Integer> task = new Task<Integer>() {
            @Override
            public Integer call() {
                // process long-running computation, data retrieval, etc...

               readexcel.inv();// result of computation
                return 0 ;
            }
        };
        task.setOnRunning((e) -> {ProgressIndicator pi = new ProgressIndicator();
        VBox box = new VBox(pi);
        box.setAlignment(Pos.CENTER);
        // Grey Background
        rot.setDisable(true);
        rot.getChildren().add(box);});
        task.setOnSucceeded(es -> {
            rot.setDisable(false);
            AnchorPane mpane = null;
            try {
                mpane = FXMLLoader.load(getClass().getResource("/sample/finalview.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rot.getChildren().setAll(mpane);
           // SomeKindOfResult result = task.getValue();
            // update UI with result
        });

        new Thread(task).start();





        //readexcel r=new readexcel();
       // readexcel.inv();
    }


}
