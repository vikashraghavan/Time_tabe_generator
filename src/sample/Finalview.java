package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.*;
import javafx.scene.transform.Scale;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

import static java.lang.Double.min;

public class Finalview implements Initializable {

    @FXML
    WebView wv;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        WebEngine engine=wv.getEngine();
        try {
            engine.load(String.valueOf(new File("tst.html").toURI().toURL()));
            System.out.println(String.valueOf(new File("\\tst.html").toURI().toURL()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
    @FXML
    void ps(ActionEvent event) {

        PrinterJob job = PrinterJob.createPrinterJob();
        if (job != null) {
            WebEngine e=wv.getEngine();
            e.print(job);
            job.endJob();
        }
    }
}
