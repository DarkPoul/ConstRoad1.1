package com.ntu.api.controller.additional;

import com.ntu.api.controller.main.InputController;
import com.ntu.api.domain.Message;
import com.ntu.api.domain.RoadConstraction;
import com.ntu.api.model.Report;
import com.ntu.api.model.RoadConstractionModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class ActionChooseController {
    @FXML AnchorPane actionChoosePane;

    private static File directory;
    private static File file;
    private static boolean enumerated = false;

    public static File getDirectory() {
        return directory;
    }
    public static void setDirectory(File directory) {
        ActionChooseController.directory = directory;
    }
    public static File getFile() {
        return file;
    }
    public static void setFile(File file) {
        ActionChooseController.file = file;
    }

    @FXML private void initialize(){
        RoadConstractionModel.preCalculation();
    }

    @FXML private void analysisOnClick(){
//        розрахунок на згин
        if(RoadConstractionModel.getRoadConstraction().getBituminous().size()>0) {
            RoadConstractionModel.bendingTensionCalculation();
            RoadConstractionModel.bendingTensionReliabilityCalculation();
        }
//        розрахунок на прогин
        if(RoadConstractionModel.getRoadConstraction().getDesigionLoad().getName().equals("A1")){
            Message.errorCatch(actionChoosePane,"Попередження", "Для розрахункового навантаження А1 " +
                    "розрахунок конструкції нежорсткого одягу за критерієм загального модуля пружності не виконується");
        }
        else {
            RoadConstractionModel.elasticDeflectionCalculation();
            RoadConstractionModel.elasticDeflectionReliabilityCalculation();
        }
//        розрахунок по зсуву грунту земляного покриття
        RoadConstractionModel.movementSubGradeCalculation();
        RoadConstractionModel.movementSubGradeReliabilityCalculation();
//        розрахунок по зсуву у нев'язких матеріалах
        if(RoadConstractionModel.getRoadConstraction().getSands().size()>0) {
            RoadConstractionModel.movementInviscidLayerCalculation();
            RoadConstractionModel.movementInviscidLayerReliabilityCalculation();
        }
//      розрахунок ціни покриття
        RoadConstractionModel.roadCost();
        Report report = new Report();
        report.reportMake(directory.getParentFile(), RoadConstractionModel.getRoadConstraction(), enumerated);
        cancelOnClick();
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
            Message.errorCatch(actionChoosePane, "Error", "Edit Error");
        }
    }

    @FXML private void enumerationOnClick(){
        try {
            enumerated = true;
            System.out.println("enum");
            for (ArrayList<Double> thinckness : RoadConstractionModel.layerThinckVariation()) {
                System.out.println("in");
                try (FileInputStream is = new FileInputStream(file);
                     ObjectInputStream ois = new ObjectInputStream(is)) {
                    RoadConstraction roadConstraction = (RoadConstraction) ois.readObject();
                    for (int i = 0; i < roadConstraction.getTotalLayerList().size(); i++) {
                        roadConstraction.getTotalLayerList().get(i).setThickness(thinckness.get(i)/100);
                    }
                    initialize();
                    RoadConstractionModel.setRoadConstraction(roadConstraction);
                    analysisOnClick();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }catch (IOException e) {e.printStackTrace();}
        System.out.println("finish");
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
