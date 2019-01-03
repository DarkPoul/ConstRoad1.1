package com.ntu.api.controller.additional;

import com.ntu.api.domain.Lists;
import com.ntu.api.model.RoadConstraction;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class SollsController {
    @FXML
    AnchorPane sollsPane;
    public void t1OnClick(){
        RoadConstraction.setSoils(Lists.getSoilList().get(0));
        okOnClick();
    }

    public void t2OnClick(){
        RoadConstraction.setSoils(Lists.getSoilList().get(1));
        okOnClick();
    }

    public void t3OnClick(){
        RoadConstraction.setSoils(Lists.getSoilList().get(2));
        okOnClick();
    }

    public void t4OnClick(){
        RoadConstraction.setSoils(Lists.getSoilList().get(3));
        okOnClick();
 }

    public void t5OnClick(){
        RoadConstraction.setSoils(Lists.getSoilList().get(4));
        okOnClick();
    }

    public void okOnClick(){
        Stage dlg = (Stage)(sollsPane.getScene().getWindow());
        dlg.getOnCloseRequest().handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
        cancelOnClick();
    }
    public void cancelOnClick(){
        Stage dlg = (Stage)(sollsPane.getScene().getWindow());
        dlg.close();
    }
}
