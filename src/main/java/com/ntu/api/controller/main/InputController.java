package com.ntu.api.controller.main;

import com.ntu.api.domain.LayerT;
import com.ntu.api.domain.Lists;
import com.ntu.api.domain.Message;
import com.ntu.api.domain.RoadConstraction;
import com.ntu.api.domain.listCreate.Objects.*;
import com.ntu.api.model.RoadConstractionModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.*;
import java.util.ArrayList;

public class InputController {
    @FXML
    ScrollPane input;
    @FXML AnchorPane inputPane;
    @FXML private ComboBox<String> rbczBox;
    @FXML private ComboBox<String> roadBox;
    @FXML private ComboBox<String> sollsBox;
    @FXML private ComboBox<String> groundTypeBox;
    @FXML private ComboBox<String> groundBox;
    @FXML private ComboBox<String> roadTypeBox;
    @FXML private ComboBox<String> dessigionLoadBox;
    @FXML private ComboBox<String> roadLinesBox;
    @FXML private ComboBox<String> groundCorrectionBox;
    @FXML private TextField passageNumber;
    @FXML private TextField operationTerm;

    @FXML private TableView<LayerT> layerTable;
    @FXML private TableColumn<LayerT, Integer> clnId;
    @FXML private TableColumn<LayerT, String> clnType;
    @FXML private TableColumn<LayerT, String> clnConstr;
    @FXML private TableColumn<LayerT, Double> clnSize;

    private ObservableList<LayerT> layers;

    private static ObservableList<String> rbczList;
    private static ObservableList<String> roadList;
    private static ObservableList<String> sollsList;
    private static ObservableList<String> groundList;
    private static ObservableList<String> roadTypeList;
    private static ObservableList<String> groudTypeList;
    private static ObservableList<String> dessigionList;
    private static ObservableList<String> roadLinesList;
    private static ObservableList<String> groundCorrectionList;

    private static ArrayList<Ground> grounds = new ArrayList();
    private static ArrayList<RoadType> roadTypes = new ArrayList<>();
    private static ArrayList<DesigionLoad> desigionLoads = new ArrayList<>();
    private static ArrayList<String> newRoadTypeList = new ArrayList<>();
    private static ArrayList<String> newLoadTypeList = new ArrayList<>();

    public ObservableList<LayerT> getLayers() {
        return layers;
    }

    public static RoadConstraction roadConstraction;

    public static RoadConstraction getRoadConstraction() {
        return roadConstraction;
    }
    public static void setRoadConstraction(RoadConstraction roadConstraction) {
        InputController.roadConstraction = roadConstraction;
    }

    @FXML public void initialize(){
        Lists.listReader();
        rbczList = FXCollections.observableArrayList();
        roadList = FXCollections.observableArrayList();
        sollsList = FXCollections.observableArrayList();
        groundList = FXCollections.observableArrayList();
        roadTypeList = FXCollections.observableArrayList();
        groudTypeList = FXCollections.observableArrayList();
        dessigionList = FXCollections.observableArrayList();
        roadLinesList = FXCollections.observableArrayList();
        groundCorrectionList = FXCollections.observableArrayList();

        rbczList.addAll(Lists.getRbczName());
        roadList.addAll(Lists.getRoadName());
        sollsList.addAll(Lists.getSoilName());
        groundList.addAll(Lists.getGroundsName());
        roadTypeList.addAll(Lists.getRoadTypeName());
        groudTypeList.addAll(Lists.getGroundType());
        dessigionList.addAll(Lists.getRoadGroundLoad());
        roadLinesList.addAll(Lists.getRoadLinesName());
        groundCorrectionList.addAll(Lists.getGroundCorrectionName());

        rbczBox.setEditable(false);
        roadBox.setEditable(false);
        sollsBox.setEditable(false);
        groundTypeBox.setEditable(false);
        groundBox.setEditable(false);
        roadTypeBox.setEditable(false);
        dessigionLoadBox.setEditable(false);
        roadLinesBox.setEditable(false);
        groundCorrectionBox.setEditable(false);

        rbczBox.getItems().setAll(rbczList);
        roadBox.getItems().setAll(roadList);
        sollsBox.getItems().setAll(sollsList);
        groundTypeBox.getItems().setAll(groudTypeList);
        groundBox.getItems().setAll(groundList);
        roadTypeBox.getItems().setAll(roadTypeList);
        dessigionLoadBox.getItems().setAll(dessigionList);
        roadLinesBox.getItems().setAll(roadLinesList);
        groundCorrectionBox.getItems().setAll(groundCorrectionList);

        layers = FXCollections.observableArrayList();
        clnId.setCellValueFactory(new PropertyValueFactory<LayerT, Integer>("id"));
        clnType.setCellValueFactory(new PropertyValueFactory<LayerT, String>("type"));
        clnConstr.setCellValueFactory(new PropertyValueFactory<LayerT, String>("construction"));
        clnSize.setCellValueFactory(new PropertyValueFactory<LayerT,Double>("thickness"));
        layerTable.setItems(layers);

        roadConstraction = new RoadConstraction();
    }

    public AnchorPane getInputPane() {
        return inputPane;
    }

    public void rbczOnView(){
        Stage rbcz = new Stage();
        rbcz.setTitle("Дорожньо-кліматична карта України");
        rbcz.setResizable(false);

        AnchorPane rbczPane = null;
        try {
            rbczPane = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/additional/rbcz.fxml"));
            rbcz.initOwner(input.getScene().getWindow());
            rbcz.initModality(Modality.WINDOW_MODAL);
            rbcz.setScene(new Scene(rbczPane));
            rbcz.show();
            rbcz.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    rbczBox.setValue(null);
                    rbczBox.promptTextProperty().set(roadConstraction.getRbcz().getName());
                }
            });
        } catch (IOException e) {
            Message.errorCatch(inputPane, "Error", "Input Error");
        }
    }

    public void sollsOnView(){
        Stage solls = new Stage();
        solls.setTitle("Тип земляного полотна");
        solls.setResizable(false);

        AnchorPane sollsPane = null;
        try {
            sollsPane = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/additional/solls.fxml"));
            solls.initOwner(input.getScene().getWindow());
            solls.initModality(Modality.WINDOW_MODAL);
            solls.setScene(new Scene(sollsPane));
            solls.show();
            solls.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event){
                    sollsBox.setValue(null);
                    sollsBox.promptTextProperty().set(roadConstraction.getSoils().getName());
                }
            });
        } catch (IOException e) {
            Message.errorCatch(inputPane, "Error", "Input Error");
        }
    }

    public void groundTypeOnView(){
        Stage groundType = new Stage();
        groundType.setTitle("Карта дорожнього районування України за грунтово-геологічними умовами");
        groundType.setResizable(false);

        AnchorPane groundTypePane = null;
        try {
            groundTypePane = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/additional/groundType.fxml"));
            groundType.initOwner(input.getScene().getWindow());
            groundType.initModality(Modality.WINDOW_MODAL);
            groundType.setScene(new Scene(groundTypePane));
            groundType.show();
            groundType.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    groundTypeBox.setValue(null);
                    groundBox.setValue(null);
                    groundTypeBox.promptTextProperty().set(roadConstraction.getGroundType().getName());
                    groundCheck();
                }
            });
        } catch (IOException e) {
           Message.errorCatch(inputPane,"Error", "Input Error");
        }
    }

    public void addRoadLayer(){
        Stage addLayer = new Stage();
        addLayer.setTitle("Додавання шару конструкції дорожнього одягу");
        addLayer.setResizable(false);
        AnchorPane addLayerPane = null;
        try{
            addLayerPane = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/additional/addRoadLayer.fxml"));
            addLayer.initOwner(input.getScene().getWindow());
            addLayer.initModality(Modality.WINDOW_MODAL);
            addLayer.setScene(new Scene(addLayerPane));
            addLayer.show();
            addLayer.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    layers.clear();
                    layers.setAll(roadConstraction.layerTableList());
                }
            });
        } catch (IOException e) {
            Message.errorCatch(inputPane,"Error", "Input Error");
        }

    }

    public void correctRoadLayer(){
        Stage correctLayer = new Stage();
        correctLayer.setTitle("Редагування шару конструкції дорожнього одягу");
        correctLayer.setResizable(false);

        AnchorPane correctLayerPane;
        try {
            correctLayerPane = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/additional/changeRoadLayer.fxml"));
            correctLayer.initOwner(input.getScene().getWindow());
            correctLayer.initModality(Modality.WINDOW_MODAL);
            correctLayer.setScene(new Scene(correctLayerPane));
            correctLayer.show();
            correctLayer.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    layers.clear();
                    layers.setAll(roadConstraction.layerTableList());
                }
            });
        } catch (IOException e) {
            Message.errorCatch(inputPane,"Error", "InputError");
        }
    }

    public void deleteRoadLayer(){
        Stage deleteLayer = new Stage();
        deleteLayer.setTitle("Видалення шару конструкції дорожнього одягу");
        deleteLayer.setResizable(false);

        AnchorPane deleteLayerPane;
        try{
            deleteLayerPane = FXMLLoader.load(getClass().getResource("/com/ntu/api/fx/model/additional/deleteRoadLayer.fxml"));
            deleteLayer.initOwner(input.getScene().getWindow());
            deleteLayer.initModality(Modality.WINDOW_MODAL);
            deleteLayer.setScene(new Scene(deleteLayerPane));
            deleteLayer.show();
            deleteLayer.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    layers.clear();
                    layers.setAll(roadConstraction.layerTableList());
                }
            });
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void passageCalculation(){

    }

    public void operationTimeOnClick(){

    }

    public void addOnClick(){
        try {
            RoadConstractionModel.setRoadConstraction(roadConstraction);
            roadConstraction.setOperationTime(Double.parseDouble(operationTerm.getText()));
            roadConstraction.setPassageNumber(Double.parseDouble(passageNumber.getText()));
            roadConstraction.setTotalLayersThickness(RoadConstractionModel.totalLayersThickness(roadConstraction));
            RoadConstractionModel.preCalculation();
            RoadConstractionModel.minElasticModuleChoose();

            FileChooser chooser = new FileChooser();
            File fileName = chooser.showSaveDialog(inputPane.getScene().getWindow());

            try(FileOutputStream fos = new FileOutputStream(fileName)){
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(roadConstraction);
                oos.flush();
            }
            catch (FileNotFoundException e) {e.printStackTrace();}
            catch (IOException e) {e.printStackTrace();}
            cancelOnClick();
            MainController.actionChooser(inputPane);
        }
        catch (NumberFormatException e) {
            Message.errorCatch(inputPane,"Error", "Помилка введення. Перевірте правильність введених даних");
        }
    }

    public void cancelOnClick(){
        Stage dlg = (Stage)(inputPane.getScene().getWindow());
        dlg.close();
    }


    public void rsczOnClick(){
        try{
        roadConstraction.setRbcz(Lists.getRbczList().get(rbczBox.getSelectionModel().getSelectedIndex()));}
        catch (RuntimeException e){}
    }
    public void roadOnClick(){
        ArrayList<Integer> newRoadLinesList = new ArrayList<>();
        boxClear(roadTypeBox);
        boxClear(dessigionLoadBox);
        boxClear(roadLinesBox);

        listNameClear(newLoadTypeList);
        listNameClear(newRoadTypeList);
        listObjectClear(roadTypes);
        listObjectClear(desigionLoads);

        roadConstraction.setRoad(Lists.getRoadList().get(roadBox.getSelectionModel().getSelectedIndex()));
        newRoadLinesList.addAll(roadConstraction.getRoad().getLanesNumber());
        roadLinesBox.getItems().setAll(listToString(newRoadLinesList));

        if(newRoadLinesList.size()==1){
            roadLinesBox.promptTextProperty().set(newRoadLinesList.get(0).toString());
            roadConstraction.setRoadLines(roadConstraction.checkRoadLines(roadConstraction.getRoad().getLanesNumber()).get(0));
        }

        for(RoadType roadType: roadConstraction.getRoad().getRoadType()){
            newRoadTypeList.add(roadType.getName());
            roadTypes.add(roadType);
            for(DesigionLoad desigionLoad: roadType.getLoadType()){
                        newLoadTypeList.add(desigionLoad.getName());
                        desigionLoads.add(desigionLoad);
            }
        }
        roadTypeBox.getItems().setAll(newRoadTypeList);

        if(newRoadTypeList.size()==1){
            roadTypeBox.promptTextProperty().set(newRoadTypeList.get(0));
            roadConstraction.setRoadType(roadConstraction.getRoad().getRoadType().get(0));
        }
        else{
            for(int i = 1; i<newLoadTypeList.size(); i++){
                if (newLoadTypeList.get(i).equals(newLoadTypeList.get(i-1))){
                    newLoadTypeList.remove(i);
                }
            }
        }
        if(newLoadTypeList.size()==1){
            dessigionLoadBox.promptTextProperty().set(newLoadTypeList.get(0));
        }
        dessigionLoadBox.getItems().setAll(newLoadTypeList);
    }

    public void sollsOnClick(){
        try {
            roadConstraction.setSoils(Lists.getSoilList().get(sollsBox.getSelectionModel().getSelectedIndex()));
        }
        catch (RuntimeException e){}
    }

    public void groundTypeOnClick(){
        try {
            boxClear(groundBox);
            roadConstraction.setGroundType(roadConstraction.getSoils().getSoilTypes().get(groundTypeBox.getSelectionModel().getSelectedIndex()));
            groundCheck();
        }
        catch (RuntimeException e){}
    }

    public void groundOnClick(){
        try{
        roadConstraction.setGround(grounds.get(groundBox.getSelectionModel().getSelectedIndex()));
        }
    catch (RuntimeException e){}}

    public void roadTypeOnClick(){
        try{
            listNameClear(newLoadTypeList);
            listObjectClear(desigionLoads);
            roadConstraction.setRoadType(roadTypes.get(roadTypeBox.getSelectionModel().getSelectedIndex()));
            for(DesigionLoad desigionLoad: roadConstraction.getRoadType().getLoadType()){
                desigionLoads.add(desigionLoad);
                newLoadTypeList.add(desigionLoad.getName());
            }
            dessigionLoadBox.getItems().setAll(newLoadTypeList);
            if(roadConstraction.getRoadType().getLoadType().size()==1){
                dessigionLoadBox.promptTextProperty().set(desigionLoads.get(0).getName());
                roadConstraction.setDesigionLoad(roadConstraction.getRoadType().getLoadType().get(0));
            }
        }
        catch (RuntimeException e){}
    }

    public void dessigionLoadOnClick(){
        try {
            roadConstraction.setDesigionLoad(desigionLoads.get(dessigionLoadBox.getSelectionModel().getSelectedIndex()));
        }
        catch (RuntimeException e){}
    }

    public void roadLinesOnClick(){
        try{
            roadConstraction.setRoadLines(roadConstraction.checkRoadLines(roadConstraction.getRoad().getLanesNumber()).get(roadLinesBox.getSelectionModel().getSelectedIndex()));
        }
        catch (RuntimeException e){}
    }

    public void groundCorrectionOnClick(){
        try{
            roadConstraction.setGroundCorection(Lists.getGroundCorrection().get(groundCorrectionBox.getSelectionModel().getSelectedIndex()));
        }
        catch (RuntimeException e){
            Message.errorCatch(inputPane,"Error", "Ground correction error");
        }
    }

    private void groundCheck(){
        String[] groundsName = roadConstraction.getGroundType().getTypicalSoil().split(", ");
        ArrayList<String > groundName = new ArrayList<>();
        for(Ground ground: Lists.getGrounds()){
            for(int i = 0; i<groundsName.length; i++){
                if(ground.getName().toLowerCase().contains(groundsName[i].toLowerCase())){
                    grounds.add(ground);
                    groundName.add(ground.getName());
                }
            }
        }
        boxClear(groundBox);
        groundBox.getItems().setAll(groundName);
    }

    private void listObjectClear(ArrayList<? extends Element> list){
        for(int i = list.size()-1; i>=0; i--){
            list.remove(i);
        }
    }

    private void listNameClear(ArrayList<String> list){
        for(int i = list.size()-1; i>=0; i--){
            list.remove(i);
        }
    }

    private void boxClear(ComboBox<String> box){
        box.promptTextProperty().setValue(null);
        box.setValue(null);
    }

    private ArrayList<String> listToString(ArrayList<Integer> list){
        ArrayList<String> stringList = new ArrayList<>();
        for(Integer el:list){
            stringList.add(el.toString());
        }
        return stringList;
    }
}
