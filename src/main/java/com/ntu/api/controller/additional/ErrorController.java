package com.ntu.api.controller.additional;

import com.ntu.api.domain.Message;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ErrorController {
    @FXML
    private AnchorPane errorDlg;
    @FXML private TextArea fldEror;

    @FXML private void initialize(){
        fldEror.setText(Message.getMessage());
    }
    @FXML private void okOnClick(){
        Stage dlg = (Stage)(errorDlg.getScene().getWindow());
        dlg.close();
    }
}
