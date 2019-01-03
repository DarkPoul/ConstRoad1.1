package com.ntu.api.controller.additional;

import com.ntu.api.model.RoadConstraction;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GroundTypeController {
    @FXML
    AnchorPane groundTypePane;

    public void g1OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(0));
        okOnClick();
    }

    public void g2OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(1));
        okOnClick();
    }

    public void g3OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(2));
        okOnClick();
    }

    public void g4OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(3));
        okOnClick();
    }

    public void g5OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(4));
        okOnClick();
    }

    public void g6OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(5));
        okOnClick();
    }

    public void g7OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(6));
        okOnClick();
    }

    public void g8OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(7));
        okOnClick();
    }

    public void g9OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(8));
        okOnClick();
    }

    public void g10OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(9));
        okOnClick();
    }

    public void g11OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(10));
        okOnClick();
    }

    public void g12OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(11));
        okOnClick();
    }

    public void g13OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(12));
        okOnClick();
    }

    public void g14OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(13));
        okOnClick();
    }

    public void g15OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(14));
        okOnClick();
    }

    public void g16OnClick(){
        RoadConstraction.setGroundType(RoadConstraction.getSoils().getSoilTypes().get(15));
        okOnClick();
    }

    public void okOnClick(){
        try{
        Stage dlg = (Stage)(groundTypePane.getScene().getWindow());
        dlg.getOnCloseRequest().handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
        dlg.close();}
        catch (RuntimeException e){}
    }

    public void cancelOnClick(){
        Stage dlg = (Stage)(groundTypePane.getScene().getWindow());
        dlg.close();
    }
}
