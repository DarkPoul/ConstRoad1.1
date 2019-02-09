package com.ntu.api.controller.additional;

import com.ntu.api.controller.main.InputController;
import com.ntu.api.domain.Lists;
import com.ntu.api.domain.RoadConstraction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

public class DeleteLayerController {
    @FXML
    AnchorPane deleteLayerPane;
    @FXML
    ComboBox<String> layer;
    @FXML
    TextArea layerType;
    @FXML
    TextArea layerConstraction;
    @FXML
    TextArea layerDepth;
    @FXML
    TextArea layerPosition;

    private static ObservableList<String> layerList;
    private RoadConstraction roadConstraction = InputController.getRoadConstraction();

    @FXML public void initialize(){
        layerList = FXCollections.observableArrayList();
        layerList.addAll(roadConstraction.layerTableStringList());
        layer.getItems().setAll(layerList);
    }

    @FXML private void layerOnClick(){
        layerType.setText("");
        layerConstraction.setText("");
        layerDepth.setText("");
        layerPosition.setText("");

        layerType.setText(roadConstraction.layerTableList().get(layer.getSelectionModel().getSelectedIndex()).getType());
        layerConstraction.setText(roadConstraction.layerTableList().get(layer.getSelectionModel().getSelectedIndex()).getConstruction());
        layerDepth.setText(roadConstraction.layerTableList().get(layer.getSelectionModel().getSelectedIndex()).getThickness().toString());
        layerPosition.setText(roadConstraction.layerTableList().get(layer.getSelectionModel().getSelectedIndex()).getId().toString());
    }

    @FXML private void cancelOnClick(){
        Stage dlg = (Stage)deleteLayerPane.getScene().getWindow();
        dlg.close();
    }

    @FXML private void deleteOnClick(){
        ArrayList<String> position = roadConstraction.positionCheck(layerType.getText());
        int roadLayerskod = Lists.getRoadLayers().indexOf(roadConstraction.roadLayersCheck(layerType.getText()));
        roadConstraction.getRoadLayers().get(roadLayerskod).getLayers().remove(position.indexOf(layerPosition.getText()));
        okOnClick();
    }

    private void okOnClick(){
        Stage dlg = (Stage)deleteLayerPane.getScene().getWindow();
        dlg.getOnCloseRequest().handle(new WindowEvent(dlg,WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();
    }





}
