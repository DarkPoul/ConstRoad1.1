package com.ntu.api.controller.additional;

import com.ntu.api.controller.main.InputController;
import com.ntu.api.domain.Message;
import com.ntu.api.domain.RoadConstraction;
import com.ntu.api.model.RoadConstractionModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class ActionChooseController {
    @FXML AnchorPane actionChoosePane;

    @FXML private void initialize(){
        RoadConstractionModel.preCalculation();
    }

    @FXML private void analysisOnClick(){
        RoadConstractionModel.setEnumerated(false);
        RoadConstractionModel.analisys(actionChoosePane);

        Stage report = new Stage();
        report.setTitle("Результати розрахунку конструкції дорожнього одягу");
        report.setResizable(false);
        AnchorPane reportPane;
        try {
            reportPane = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/additional/report.fxml"));
            report.initOwner(actionChoosePane.getScene().getWindow());
            report.initModality(Modality.WINDOW_MODAL);
            report.setScene(new Scene(reportPane));
            report.show();
        } catch (IOException e) {
            Message.errorCatch(actionChoosePane, "Error", "Analysis Error");
//            e.printStackTrace();
        }
    }

    @FXML private void editOnClick(){
        cancelOnClick();
        Stage edit = new Stage();
        edit.setTitle("Редагування конструкції дорожнього одягу");
        edit.setResizable(false);
        InputController.setEditBool(true);

        ScrollPane editDlg = null;
        try {
            editDlg = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/main/input.fxml"));
            edit.initModality(Modality.WINDOW_MODAL);
            edit.initOwner(actionChoosePane.getScene().getWindow());
            edit.setScene(new Scene(editDlg));
            edit.show();
        } catch (IOException e) {
            e.printStackTrace();
//            Message.errorCatch(actionChoosePane, "Error", "Edit Error");
        }
    }

    @FXML private void enumerationOnClick(){
        try {
            RoadConstractionModel.setEnumerated(true);
//            RoadConstractionModel.setDirectory(RoadConstractionModel.getDirectory().getParentFile());
            for (ArrayList<Double> thinckness : RoadConstractionModel.layerThinckVariation()) {
                try (FileInputStream is = new FileInputStream(RoadConstractionModel.getFile());
                     ObjectInputStream ois = new ObjectInputStream(is)) {
                    RoadConstraction roadConstraction = (RoadConstraction) ois.readObject();
                    for (int i = 0; i < RoadConstractionModel.getTotalLayerList().size(); i++) {
                        RoadConstractionModel.getTotalLayerList().get(i).setThickness(thinckness.get(i)/100);
                    }
                    initialize();
                    RoadConstractionModel.setRoadConstraction(roadConstraction);
                    RoadConstractionModel.analisys(actionChoosePane);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e) {e.printStackTrace();}
        Message.errorCatch(actionChoosePane,"Результати", "Перебір варіантів конструкції дорожнього покриття успішно завершена. Результати представлені у відповідному файлі звіту (.../report/...)");
    }

    @FXML private void optByCostOnClick(){

    }

    @FXML private void optByBitumDepthOnClick(){

    }

    @FXML private void optByFundamentDepthOnClick(){

    }

    @FXML private void optByTotalDepthOnClick(){

    }

    @FXML private void cancelOnClick(){
        Stage dlg = (Stage)(actionChoosePane.getScene().getWindow());
        dlg.close();
    }


}
