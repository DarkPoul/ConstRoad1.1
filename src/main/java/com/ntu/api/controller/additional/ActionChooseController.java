package com.ntu.api.controller.additional;

import com.ntu.api.domain.Message;
import com.ntu.api.domain.RoadConstraction;
import com.ntu.api.model.RoadConstractionModel;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class ActionChooseController {
    @FXML AnchorPane actionChoosePane;
    @FXML private void initialize(){
        RoadConstractionModel.preCalculation();
        RoadConstractionModel.minElasticModuleChoose();

    }

    @FXML private void analysisOnClick(){
        RoadConstractionModel.bendingTensionCalculation();
        RoadConstractionModel.bendingTensionReliabilityCalculation();
        System.out.println(RoadConstractionModel.getElasticTensionCoefficient());
        RoadConstractionModel.movementSubGradeCalculation();
        RoadConstractionModel.movementSubGradeReliabilityCalculation();
        System.out.println(RoadConstractionModel.getMovementSubGradeCoefficient());
        RoadConstractionModel.movementInviscidLayerCalculation();
        RoadConstractionModel.movementInviscidLayerReliabilityCalculation();
        System.out.println(RoadConstractionModel.getMovementInviscidLayerCoefficient());
        if(RoadConstractionModel.getRoadConstraction().getDesigionLoad().getName().equals("A1")){
            Message.errorCatch(actionChoosePane,"Попередження", "Для розрахункового навантаження А1 " +
                    "розрахунок конструкції нежорсткого одягу за критерієм загального молудя пружності не виконується");
        }
        else {
            RoadConstractionModel.elasticDeflectionCalculation();
            RoadConstractionModel.elasticDeflectionReliabilityCalculation();
            System.out.println(RoadConstractionModel.getElasticDeflectionCoefficient()); }

    }

    @FXML private void editOnClick(){

    }

    @FXML private void enumerationOnClick(){

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

    }
}
