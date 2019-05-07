package com.ntu.api.controller.additional;

import com.ntu.api.model.Report;
import com.ntu.api.model.RoadConstractionModel;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ReportController {
    @FXML private AnchorPane reportPane;
    @FXML private TextArea tensionResult;
    @FXML private TextArea tensionReliability;
    @FXML private TextArea deflectionResult;
    @FXML private TextArea deflectionReliability;
    @FXML private TextArea subGradeMovementResult;
    @FXML private TextArea subGradeMovementReliability;
    @FXML private TextArea inviscLayerMovemmentResult;
    @FXML private TextArea inviscLayerMovemmentReliability;
    @FXML private Button tensionBtn;
    @FXML private Button tensionReliabilityBtn;
    @FXML private Button deflectionBtn;
    @FXML private Button deflectionReliabilityBtn;
    @FXML private Button subGradeMovementBtn;
    @FXML private Button subGradeMovementReliabilityBtn;
    @FXML private Button inviscLayerMovemmentBtn;
    @FXML private Button inviscLayerMovemmentReliabilityBtn;

    @FXML public void initialize(){
        Report report = new Report();
        tensionResult.setText(RoadConstractionModel.getReport().getTensionResult() + "\n" +
                              RoadConstractionModel.getReport().getTensionConclusion() + "\n" +
                              RoadConstractionModel.getReport().getTensionMargin());
        tensionReliability.setText(RoadConstractionModel.getReport().getTensionReliability());
        deflectionResult.setText(RoadConstractionModel.getReport().getDeflectionResult() + "\n" +
                                 RoadConstractionModel.getReport().getDeflectionConclusion() + "\n" +
                                 RoadConstractionModel.getReport().getDeflectionMargin());
        deflectionReliability.setText(RoadConstractionModel.getReport().getDeflectionReliability());
        subGradeMovementResult.setText(RoadConstractionModel.getReport().getSubGradeMovementResult() + "\n" +
                                       RoadConstractionModel.getReport().getSubGradeMovementConclusion() + "\n" +
                                       RoadConstractionModel.getReport().getSubGradeMovementMargin());
        subGradeMovementReliability.setText(RoadConstractionModel.getReport().getSubGradeMovementReliability());
        if(RoadConstractionModel.getRoadConstraction().getSands().size()==0){
            inviscLayerMovemmentResult.setText("В конструкції дорожнього одягу відсутні шари з нев'язких матеріалів. Тому розрахунок показника міцності за критерієм зсуву в нев'язких матеріалах не проводитися.  ");
            inviscLayerMovemmentReliability.setText(" ");
            inviscLayerMovemmentBtn.setStyle("-fx-background-color: yellow");
            inviscLayerMovemmentReliabilityBtn.setStyle("-fx-background-color: yellow");
        }
        else {
            if (RoadConstractionModel.getReport().isInviscLayerMovemmentBool()) {
                inviscLayerMovemmentResult.setText("Розрахунковий показник міцності за критерієм зсуву в нев'язких матеріалах.\n" +
                                                   "Вибрана конструкція задовольняє умову міцності за критерієм зсуву в нев'язких матеріалах.\n" +
                                                   "Розрахунковий показник міцності за критерієм зсуву в нев'язких матеріалах більший за необхідний. ");
                inviscLayerMovemmentBtn.setStyle("-fx-background-color: green");
            } else {
                inviscLayerMovemmentResult.setText("Розрахунковий показник міцності за критерієм зсуву в нев'язких матеріалах.\n" +
                                                   "Вибрана конструкція незадовольняє умову міцності за критерієм зсуву в нев'язких матеріалах.\n" +
                                                   "Розрахунковий показник міцності за критерієм зсуву в нев'язких матеріалах менший за необхідний. ");
                inviscLayerMovemmentBtn.setStyle("-fx-background-color: red");
            }
            if (RoadConstractionModel.getReport().isInviscLayerMovemmentReliabilityBool()) {
                inviscLayerMovemmentReliability.setText("Вибрана конструкція задовольняє вимогу надійності за критерієм зсуву в нев'язких матеріалах. ");
                inviscLayerMovemmentReliabilityBtn.setStyle("-fx-background-color: green");
            } else {
                inviscLayerMovemmentReliability.setText("Вибрана конструкція незадовольняє вимогу надійності за критерієм зсуву в нев'язких матеріалах. ");
                inviscLayerMovemmentReliabilityBtn.setStyle("-fx-background-color: red");
            }
        }
        if(RoadConstractionModel.getRoadConstraction().getBituminous().size()==0){
            tensionBtn.setStyle("-fx-background-color: yellow");
            tensionReliabilityBtn.setStyle("-fx-background-color: yellow");
        }
        else {
            if (RoadConstractionModel.getReport().isTensionBool()) {
                tensionBtn.setStyle("-fx-background-color: green");
            }
            else {
                tensionBtn.setStyle("-fx-background-color: red");
            }
            if (RoadConstractionModel.getReport().isTensionReliabilityBool()) {
                tensionReliabilityBtn.setStyle("-fx-background-color: green");
            }
            else {
                tensionReliabilityBtn.setStyle("-fx-background-color: red");
            }
        }
        if(RoadConstractionModel.getRoadConstraction().getDesigionLoad().getName().equals("A1")){
            deflectionBtn.setStyle("-fx-background-color: yellow");
            deflectionReliabilityBtn.setStyle("-fx-background-color: yellow");
        }
        else {
            if (RoadConstractionModel.getReport().isDeflectionBool()) {
                deflectionBtn.setStyle("-fx-background-color: green");
            } else {
                deflectionBtn.setStyle("-fx-background-color: red");
            }
            if (RoadConstractionModel.getReport().isDeflectionReliabilityBool()) {
                deflectionReliabilityBtn.setStyle("-fx-background-color: green");
            } else {
                deflectionReliabilityBtn.setStyle("-fx-background-color: red");
            }
        }
        if(RoadConstractionModel.getReport().isSubGradeMovementBool()){
            subGradeMovementBtn.setStyle("-fx-background-color: green");
        }
        else{
            subGradeMovementBtn.setStyle("-fx-background-color: red");
        }
        if(RoadConstractionModel.getReport().isSubGradeMovementReliabilityBool()){
            subGradeMovementReliabilityBtn.setStyle("-fx-background-color: green");
        }
        else{
            subGradeMovementReliabilityBtn.setStyle("-fx-background-color: red");
        }

    }
    @FXML public void okOnClick(){
        Stage dlg = (Stage)reportPane.getScene().getWindow();
        dlg.close();
    }
}
