package com.ntu.api.controller.additional;

import com.ntu.api.domain.Lists;
import com.ntu.api.model.RoadConstraction;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class RbczController {
    @FXML
    AnchorPane rbczPane;

    @FXML public void oneOnClick(){
        RoadConstraction.setRbcz(Lists.getRbczList().get(0));
        close();
    }
    @FXML public void twoOnClick(){
        RoadConstraction.setRbcz(Lists.getRbczList().get(1));
        close();
    }
    @FXML public void treeOnClick(){
        RoadConstraction.setRbcz(Lists.getRbczList().get(2));
        close();
    }
    @FXML public void fourWestOnClick(){
        RoadConstraction.setRbcz(Lists.getRbczList().get(3));
        close();
    }

    @FXML public void fourSouthOnClick(){
        RoadConstraction.setRbcz(Lists.getRbczList().get(4));
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
