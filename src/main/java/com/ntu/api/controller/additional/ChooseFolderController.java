package com.ntu.api.controller.additional;

import com.ntu.api.domain.Lists;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class ChooseFolderController {
    @FXML
    AnchorPane choosePane;
    @FXML
    TextArea folder;

    private static String fileFolder = Lists.getRoot();

    @FXML public void chooseOnClick(){
        DirectoryChooser chooser = new DirectoryChooser();
        File file = chooser.showDialog(choosePane.getScene().getWindow());
        fileFolder = file.getAbsolutePath();
        folder.setText(fileFolder);
    }

    @FXML public void okOnClick(){
        Lists.setRoot(fileFolder);
        exit();
    }


    private void exit(){
        Stage dlg = (Stage)choosePane.getScene().getWindow();
        dlg.close();
    }

}
