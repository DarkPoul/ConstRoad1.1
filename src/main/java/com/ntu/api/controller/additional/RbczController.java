package com.ntu.api.controller.additional;

import com.ntu.api.controller.main.InputController;
import com.ntu.api.domain.Lists;
import com.ntu.api.domain.RoadConstraction;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class RbczController {
    @FXML
    AnchorPane rbczPane;
    private RoadConstraction roadConstraction = InputController.getRoadConstraction();

    @FXML public void oneOnClick(){
        roadConstraction.setRbcz(Lists.getRbczList().get(0));
        close();
    }
    @FXML public void twoOnClick(){
        roadConstraction.setRbcz(Lists.getRbczList().get(1));
        close();
    }
    @FXML public void treeOnClick(){
        roadConstraction.setRbcz(Lists.getRbczList().get(2));
        close();
    }
    @FXML public void fourWestOnClick(){
        roadConstraction.setRbcz(Lists.getRbczList().get(3));
        close();
    }

    @FXML public void fourSouthOnClick(){
        roadConstraction.setRbcz(Lists.getRbczList().get(4));
        close();
    }

    @FXML public void cancelOnClick(){
        Stage dlg = (Stage)(rbczPane.getScene().getWindow());
        dlg.close();
    }

    private void close(){
        Stage dlg = (Stage)(rbczPane.getScene().getWindow());
        dlg.getOnCloseRequest().handle(new WindowEvent(dlg, WindowEvent.WINDOW_CLOSE_REQUEST));
        cancelOnClick();
    }
}
