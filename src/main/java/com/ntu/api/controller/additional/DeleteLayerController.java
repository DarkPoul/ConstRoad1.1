package com.ntu.api.controller.additional;

import com.ntu.api.domain.Lists;
import com.ntu.api.domain.listCreate.Objects.Layers.RoadLayers;
import com.ntu.api.model.RoadConstraction;
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

    @FXML public void initialize(){
        layerList = FXCollections.observableArrayList();
        layerList.addAll(RoadConstraction.layerTableStringList());
        layer.getItems().setAll(layerList);
    }

    @FXML private void layerOnClick(){
        layerType.setText("");
        layerConstraction.setText("");
        layerDepth.setText("");
        layerPosition.setText("");

        layerType.setText(RoadConstraction.layerTableList().get(layer.getSelectionModel().getSelectedIndex()).getType());
        layerConstraction.setText(RoadConstraction.layerTableList().get(layer.getSelectionModel().getSelectedIndex()).getConstruction());
        layerDepth.setText(RoadConstraction.layerTableList().get(layer.getSelectionModel().getSelectedIndex()).getThickness().toString());
        layerPosition.setText(RoadConstraction.layerTableList().get(layer.getSelectionModel().getSelectedIndex()).getId().toString());
    }

    @FXML private void cancelOnClick(){
        Stage dlg = (Stage)deleteLayerPane.getScene().getWindow();
        dlg.close();
    }

    @FXML private void deleteOnClick(){
        ArrayList<String> position = RoadConstraction.positionCheck(layerType.getText());
        int roadLayerskod = Lists.getRoadLayers().indexOf(RoadConstraction.roadLayersCheck(layerType.getText()));
        RoadConstraction.getRoadLayers().get(roadLayerskod).getLayers().remove(position.indexOf(layerPosition.getText()));
        okOnClick();
    }

    private void okOnClick(){
        Stage dlg = (Stage)deleteLayerPane.getScene().getWindow();
        dlg.getOnCloseRequest().handle(new WindowEvent(dlg,WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();
    }





}
