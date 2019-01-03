package com.ntu.api.controller.main;

import com.ntu.api.controller.additional.AboutController;
import com.ntu.api.domain.Message;
import com.ntu.api.model.RoadConstraction;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;

public class MainController {
    @FXML
    AnchorPane main;

    public void helpOnClick(){
        helpAboutOpen("Help", "Help Error", false);
    }

    public void aboutOnClick(){
        helpAboutOpen("About", "About Error", true);
    }

    private void helpAboutOpen(String paneName, String errorMessage, boolean bool){
        Stage about = new Stage();
        about.setTitle(paneName);
        about.setResizable(false);
        AboutController.setBool(bool);
        AnchorPane aboutDlg = null;

        try {
            aboutDlg = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/additional/about.fxml"));
            about.initOwner(main.getScene().getWindow());
            about.initModality(Modality.WINDOW_MODAL);
            about.setScene(new Scene(aboutDlg));
            about.show();
        } catch (IOException e) {
            Message.errorCatch(main,"Error",errorMessage);
        }
    }

    public void newOnClick(){
        Stage input = new Stage();
        input.setTitle("Введення нової конструкції дорожнього одягу");
        input.setResizable(false);

        ScrollPane inputDlg = null;
        try {
            inputDlg = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/main/input.fxml"));
            input.initOwner(main.getScene().getWindow());
            input.initModality(Modality.WINDOW_MODAL);
            input.setScene(new Scene(inputDlg));
            input.show();
        } catch (IOException e) {
            Message.errorCatch(main, "Error", "Input Error");
        }
    }

    public void openOnClick(){
        FileChooser fileChooser = new FileChooser();
        File fileName = fileChooser.showOpenDialog(main.getScene().getWindow());
        RoadConstraction roadConstraction;

        try(FileInputStream is = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(is)){
            roadConstraction = (RoadConstraction) ois.readObject();
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();
        } catch (ClassNotFoundException e) {e.printStackTrace();
        }
    }

    public void closeOnClick(){
        System.exit(0);
    }

}
