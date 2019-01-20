package com.ntu.api.controller.additional;

import com.ntu.api.domain.Lists;
import com.ntu.api.domain.Message;
import com.ntu.api.model.RoadConstraction;
import com.ntu.api.domain.listCreate.Objects.Layers.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class AddLayerController {
    @FXML AnchorPane addLayerPane;
    @FXML ComboBox<String> layerType;
    @FXML ComboBox<String> layerConstraction;
    @FXML ComboBox<String> layerDepth;

    private static ObservableList<String> layerTypeList;
    private static ObservableList<String> layerConstractionList;
    private static ObservableList<String> layerDepthList;

    private static Layer layerConstractList;

    @FXML public void initialize(){
        RoadConstraction.layers();

        layerTypeList = FXCollections.observableArrayList();
        layerConstractionList = FXCollections.observableArrayList();
        layerDepthList = FXCollections.observableArrayList();

        layerTypeList.addAll(Lists.getRoadLayersName());
        layerConstractionList.addAll(Lists.getLayersList().get(0));
        layerConstractionList.addAll(Lists.getLayersList().get(1));
        layerConstractionList.addAll(Lists.getLayersList().get(2));
        layerConstractionList.addAll(Lists.getLayersList().get(3));
        layerConstractionList.addAll(Lists.getLayersList().get(4));

        layerType.setEditable(false);
        layerConstraction.setEditable(false);
        layerDepth.setEditable(true);

        layerType.getItems().setAll(layerTypeList);
        layerConstraction.getItems().setAll(layerConstractionList);
    }

    @FXML public void layerTypeOnClick(){
        try {
            boxClear(layerConstraction);
            boxClear(layerDepth);
            layerDepth.getItems().setAll(new ArrayList<>());
            layerConstraction.getItems().setAll(Lists.getLayersList().get(layerType.getSelectionModel().getSelectedIndex()));
        }
        catch (RuntimeException e){}
    }

    @FXML public void layerConstractionOnClick() {
        try{
        boxClear(layerDepth);
        layerDepth.getItems().setAll(depthList());}
        catch (RuntimeException e){}
    }

    @FXML public void layerDepthOnClick(){
        if(Double.parseDouble(layerDepth.getSelectionModel().getSelectedItem())<
                Lists.getRoadLayers().get(layerType.getSelectionModel().getSelectedIndex()).
                getLayers().get(layerConstraction.getSelectionModel().getSelectedIndex()).getMinThickness() ||
                Double.parseDouble(layerDepth.getSelectionModel().getSelectedItem())>
                        Lists.getRoadLayers().get(layerType.getSelectionModel().getSelectedIndex()).
                        getLayers().get(layerConstraction.getSelectionModel().getSelectedIndex()).getMaxThickness()){
            Message.errorCatch(addLayerPane,"Error", "Введена товщина шару дорожнього одягу є " +
                    "недопустимою для даної конструкції шару дорожнього одягу.");
        }
    }

    @FXML public void addOnClick() {
        try {
            if (Double.parseDouble(layerDepth.getSelectionModel().getSelectedItem()) <
                    Lists.getRoadLayers().get(layerType.getSelectionModel().getSelectedIndex()).
                            getLayers().get(layerConstraction.getSelectionModel().getSelectedIndex()).getMinThickness() ||
                    Double.parseDouble(layerDepth.getSelectionModel().getSelectedItem()) >
                            Lists.getRoadLayers().get(layerType.getSelectionModel().getSelectedIndex()).
                                    getLayers().get(layerConstraction.getSelectionModel().getSelectedIndex()).getMaxThickness()) {
                Message.errorCatch(addLayerPane, "Error", "Введена товщина шару дорожнього одягу є " +
                        "недопустимою для даної конструкції шару дорожнього одягу.");
            } else {
                try {
                    Layer temp = Lists.getRoadLayers().get(layerType.getSelectionModel().getSelectedIndex()).
                            getLayers().get(layerConstraction.getSelectionModel().getSelectedIndex());
                    temp.setThickness(Double.parseDouble(layerDepth.getSelectionModel().getSelectedItem()));
                    if (layerType.getSelectionModel().getSelectedIndex() == 0) {
                        temp.setThicknessVariationCoeficient(2.84 / (10.2 + temp.getThickness()));
                        RoadConstraction.getBituminous().add((Bituminous) temp);
                    } else {
                        temp.setThicknessVariationCoeficient(2.84 / (5.6 + temp.getThickness()));
                        if (layerType.getSelectionModel().getSelectedIndex() == 1) {
                            RoadConstraction.getStrengthenedMaterials().add((StrengthenedMaterial) temp);
                        } else if (layerType.getSelectionModel().getSelectedIndex() == 2) {
                            RoadConstraction.getUnstrengthenedMaterialsCover().add((UnstrengthenedMaterial) temp);
                        } else if (layerType.getSelectionModel().getSelectedIndex() == 3) {
                            RoadConstraction.getUnstrengthenedMaterialsBase().add((UnstrengthenedMaterial) temp);
                        } else if (layerType.getSelectionModel().getSelectedIndex() == 4) {
                            RoadConstraction.getSands().add((Sand) temp);
                        }
                    }
                    RoadConstraction.layers();
                    okOnClick();
                } catch (RuntimeException e) {
                }
            }
        }
        catch (NumberFormatException e){
            Message.errorCatch(addLayerPane,"Error", "Невірно введені дані. Перевірте введені дані.");
        }
    }


    @FXML public void cancelOnClick(){
        Stage dlg = (Stage)addLayerPane.getScene().getWindow();
        dlg.close();
    }

    private void boxClear(ComboBox<String> box){
        box.promptTextProperty().setValue(null);
        box.setValue(null);
    }

    private ArrayList<String> depthList(){
        Double start = Lists.getRoadLayers().get(layerType.getSelectionModel().getSelectedIndex()).
                getLayers().get(layerConstraction.getSelectionModel().getSelectedIndex()).getMinThickness();
        Double finish = Lists.getRoadLayers().get(layerType.getSelectionModel().getSelectedIndex()).
                getLayers().get(layerConstraction.getSelectionModel().getSelectedIndex()).getMaxThickness();
        return RoadConstraction.depthList(start, finish);
    }

    private void okOnClick(){
        try{
            Stage dlg = (Stage)(addLayerPane.getScene().getWindow());
            dlg.getOnCloseRequest().handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
            dlg.close();}
        catch (RuntimeException e){}
    }

}
