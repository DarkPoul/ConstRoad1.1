package com.ntu.api.controller.main;

import com.ntu.api.controller.additional.AboutController;
import com.ntu.api.controller.additional.ActionChooseController;
import com.ntu.api.domain.Message;
import com.ntu.api.domain.RoadConstraction;
import com.ntu.api.model.RoadConstractionModel;
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
    private AnchorPane main;
    private RoadConstraction roadConstraction;

    public RoadConstraction getRoadConstraction() {
        return roadConstraction;
    }
    public void setRoadConstraction(RoadConstraction roadConstraction) {
        this.roadConstraction = roadConstraction;
    }

    @FXML public void helpOnClick(){
        helpAboutOpen("Help", "Help Error", false);
    }

    @FXML public void aboutOnClick(){
        helpAboutOpen("About", "About Error", true);
    }

    @FXML private void helpAboutOpen(String paneName, String errorMessage, boolean bool){
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

    @FXML public void newOnClick(){
        InputController.setEditBool(false);
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

    @FXML public void openOnClick(){
        FileChooser fileChooser = new FileChooser();
        File fileName = fileChooser.showOpenDialog(main.getScene().getWindow());
        RoadConstractionModel.setDirectory(fileName.getParentFile());
        RoadConstractionModel.setFile(fileName);

        try(FileInputStream is = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(is)){
            roadConstraction = (RoadConstraction) ois.readObject();
            RoadConstractionModel.setRoadConstraction(roadConstraction);
            actionChooser(main);
        } catch (FileNotFoundException e) {e.printStackTrace();
        } catch (IOException e) {e.printStackTrace();
        } catch (ClassNotFoundException e) {e.printStackTrace();
        }
    }

    @FXML public void closeOnClick(){
        System.exit(0);
    }


    @FXML public static void actionChooser(AnchorPane pane){
        Stage actionChoose = new Stage();
        actionChoose.setTitle("Дії з конструкцією дорожнього одягу");
        actionChoose.setResizable(false);

        AnchorPane actionChoosePane;
        try {
            actionChoosePane = FXMLLoader.load(MainController.class.getResource("/com/ntu/api/fx/model/main/actionChoose.fxml"));
            actionChoose.initOwner(pane.getScene().getWindow());
            actionChoose.initModality(Modality.WINDOW_MODAL);
            actionChoose.setScene(new Scene(actionChoosePane));
            actionChoose.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
