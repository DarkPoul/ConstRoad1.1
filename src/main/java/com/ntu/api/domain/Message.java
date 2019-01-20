package com.ntu.api.domain;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

//клас формування повідомлення-помилки
public class Message {
    private static String message;

    public static String getMessage() {
        return message;
    }

    public static void setMessage(String message) {
        Message.message = message;
    }

//    метод формування повідомлення-помилки
    public static void errorCatch(AnchorPane pane, String name, String message){
        setMessage(message);
        Stage error = new Stage();
        error.setTitle(name);
        error.setResizable(false);

        AnchorPane errorDlg = null;
        try {
            errorDlg = FXMLLoader.load(Message.class.getResource("/com/ntu/api/fx/model/additional/error.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        error.initOwner(pane.getScene().getWindow());
        error.initModality(Modality.WINDOW_MODAL);
        error.setScene(new Scene(errorDlg));
        error.show();
    }
}
