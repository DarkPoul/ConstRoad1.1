package com.ntu.api.model;

import com.ntu.api.domain.Message;
import com.ntu.api.domain.RoadConstraction;
import com.ntu.api.domain.listCreate.Objects.Layers.Layer;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

public class Report {
    private boolean excellentBool = true;

    private String tensionResult;
    private String tensionConclusion;
    private String tensionMargin;
    private String tensionReliability;

    private String deflectionResult;
    private String deflectionConclusion;
    private String deflectionMargin;
    private String deflectionReliability;

    private String subGradeMovementResult;
    private String subGradeMovementConclusion;
    private String subGradeMovementMargin;
    private String subGradeMovementReliability;

    private ArrayList<String> inviscLayerMovemmentResult = new ArrayList<>();
    private ArrayList<String> inviscLayerMovemmentConclusion = new ArrayList<>();
    private ArrayList<String> inviscLayerMovemmentMargin = new ArrayList<>();
    private ArrayList<String> inviscLayerMovemmentReliability = new ArrayList<>();

    private String roadCost;

    private static FileWriter resultWriter;
    private static FileWriter excellentResultWriter;
    private static File directoryForReport;

    public void reportMake(File directory, RoadConstraction roadConstraction, boolean bool){
        directoryForReport = new File(directory, "reports");
        if(!directoryForReport.exists()) {
            directoryForReport.mkdir();
        }
        prepeare();
        write(directoryForReport, roadConstraction, bool);
    }

    private void prepeare(){
        excellentBool = true;
//        розрахунок на згин
        if(RoadConstractionModel.getRoadConstraction().getBituminous().size()>0) {
            tensionResult = "Розрахунковий показник міцності за критерієм опору шарів з монолітних матеріалів розтягу при згині = " + RoadConstractionModel.getElasticTensionCoefficient() + " .\n";
            if (RoadConstractionModel.getElasticTensionCoefficient() >= RoadConstractionModel.getRoadConstraction().getRoad().getrBend()) {
                tensionConclusion = "Вибрана конструкція задовольняє умову міцності за критерієм опору шарів з монолітних матеріалів розтягу при згині.\n";
                tensionMargin = "Розрахунковий показник міцності за критерієм опру розтягу при згині більший за необхідний на " + RoadConstractionModel.getTension() + " %.\n";
            } else {
                excellentBool = false;
                tensionConclusion = "Вибрана конструкція незадовольняє умову міцності за критерієм опору шарів з монолітних матеріалів розтягу при згині.\n";
                tensionMargin = "Розрахунковий показник міцності за критерієм опру розтягу при згині менший за необхідний на " + RoadConstractionModel.getTension() + " %.\n";
            }
            String reliabilityT = "Розрахунковий показник надійності за критерієм опору шарів з монолітних матеріалів розтягу при згині = " + RoadConstractionModel.getBendingTensionReliability() + " .\n";
            if (RoadConstractionModel.getBendingTensionReliability() >= RoadConstractionModel.getRoadConstraction().getRoad().getkN()) {
                tensionReliability = reliabilityT + "Вибрана конструкція задовольняє вимогу надійності за критерієм опору шарів з монолітних матеріалів розтягу при згині.\n";
            } else {
                excellentBool = false;
                tensionReliability = reliabilityT + "Вибрана конструкція незадовольняє вимогу надійності за критерієм опору шарів з монолітних матеріалів розтягу при згині.\n";
            }
        }
        else{
            tensionResult = "В конструкції дорожнього одягу відсутні шари з монолітних матеріалів. Тому розрахунок показника міцності за критерієм опору шарів з монолітних матеріалів розтягу при згині не проводитися.\n";
            tensionConclusion = " ";
            tensionMargin = " ";
            tensionReliability = " ";
        }
//        розрахунок на прогин
        if(RoadConstractionModel.getRoadConstraction().getDesigionLoad().getName().equals("A1")){
            deflectionResult = "Для розрахункового навантаження А1 розрахунок конструкції нежорсткого одягу за критерієм загального модуля пружності не виконується.\n ";
            deflectionConclusion = " ";
            deflectionMargin = " ";
            deflectionReliability = " ";
        }
        else {
            deflectionResult = "Розрахунковий показник міцності за критерієм пружного прогину = " + RoadConstractionModel.getElasticDeflectionCoefficient() + " .\n";
            if(RoadConstractionModel.getElasticDeflectionCoefficient()>=RoadConstractionModel.getRoadConstraction().getRoad().getrDefl()){
                deflectionConclusion = "Вибрана конструкція задовольняє умову міцності за критерієм допустимого пружниого прогину.";
                deflectionMargin = "Розрахунковий показник міцності за критерієм допустимого пружного прогину більший за необхідний на " + RoadConstractionModel.getDeflection() + " %.\n";
            }
            else{
                excellentBool = false;
                deflectionConclusion = "Вибрана конструкція незадовольняє умову міцності за критерієм допустимого пружного прогину.\n";
                deflectionMargin = "Розрахунковий показник міцності за критерієм допустимого пружного прогину менший за необхідний на " + RoadConstractionModel.getDeflection() + " %.\n";
            }
            String reliabilityD = "Розрахунковий показник надійності за критерієм допустимого пружного прогину = " + RoadConstractionModel.getElasticDeflectionReliability() + " .\n";
            if(RoadConstractionModel.getElasticDeflectionReliability()>=RoadConstractionModel.getRoadConstraction().getRoad().getkN()){
                deflectionReliability = reliabilityD + "Вибрана конструкція задовольняє вимогу надійності за критерієм допустимого пружного прогину.\n";
            }
            else{
                excellentBool = false;
                deflectionReliability = reliabilityD + "Вибрана конструкція незадовольняє вимогу надійності за критерієм допустимого пружного прогину.\n";
            }
        }
//        розрахунок по зсуву грунту земляного покриття;;
        subGradeMovementResult = "Розрахунковий показник міцності за критерієм зсуву у в грунті земляного полотна = " + RoadConstractionModel.getMovementSubGradeCoefficient() + " .\n";
        if(RoadConstractionModel.getMovementSubGradeCoefficient()>=RoadConstractionModel.getRoadConstraction().getRoad().getrOffset()){
            subGradeMovementConclusion = "Вибрана конструкція задовольняє умову міцності за критерієм зсуву в грунті земляного полотна.";
            subGradeMovementMargin = "Розрахунковий показник міцності за критерієм зсуву в грунті земляного полотна більший за необхідний на " + RoadConstractionModel.getSubGradeMovement() + " %.\n";
        }
        else{
            excellentBool = false;
            subGradeMovementConclusion = "Вибрана конструкція незадовольняє умову міцності за критерієм зсуву в грунті земляного полотна.\n";
            subGradeMovementMargin = "Розрахунковий показник міцності за критерієм зсуву в грунті земляного полотна менший за необхідний на " + RoadConstractionModel.getSubGradeMovement() + " %.\n";
        }
        String reliabilityS = "Розрахунковий показник надійності за критерієм зсуву в грунті земляного полотна = " + RoadConstractionModel.getMovementSubGradeReliability() +" .\n";
        if(RoadConstractionModel.getMovementSubGradeReliability()>=RoadConstractionModel.getRoadConstraction().getRoad().getkN()){
            subGradeMovementReliability = reliabilityS + "Вибрана конструкція задовольняє вимогу надійності за критерієм зсуву в грунті земляного полотна.\n";
        }
        else{
            excellentBool = false;
            subGradeMovementReliability = reliabilityS + "Вибрана конструкція незадовольняє вимогу надійності за критерієм зсуву в грунті земляного полотна.\n";
        }
//        розрахунок по зсуву у нев'язких матеріалах
        if(RoadConstractionModel.getRoadConstraction().getSands().size()>0){
            for(int i = 0; i<RoadConstractionModel.getRoadConstraction().getSands().size(); i++){
                Double element = RoadConstractionModel.getMovementInviscidLayerCoefficient().get(i);
                inviscLayerMovemmentResult.add("Розрахунковий показник міцності за критерієм зсуву в нев'язких матеріалах:\n"
                        + RoadConstractionModel.getRoadConstraction().getSands().get(i).getName() + " = " + element + " .\n");
                if(element>=RoadConstractionModel.getRoadConstraction().getRoad().getrOffset()){
                    inviscLayerMovemmentConclusion.add("Вибрана конструкція задовольняє умову міцності за критерієм зсуву в нев'язких матеріалах.\n");
                    inviscLayerMovemmentMargin.add("Розрахунковий показник міцності за критерієм зсуву в нев'язких матеріалах більший за необхідний на " + RoadConstractionModel.getInviscLayerMovement().get(i) + " %.\n");
                }
                else{
                    excellentBool = false;
                    inviscLayerMovemmentConclusion.add("Вибрана конструкція незадовольняє умову міцності за критерієм зсуву в нев'язких матеріалах.\n");
                    inviscLayerMovemmentMargin.add("Розрахунковий показник міцності за критерієм зсуву в нев'язких матеріалах менший за необхідний на " + RoadConstractionModel.getInviscLayerMovement().get(i) + " %.\n");
                }
                String reliabilityI = "Розрахунковий показник надійності за критерієм зсуву в нев'язких матеріалах = " + RoadConstractionModel.getMovementInviscidLayerReliability().get(i) + "\n";
                if(RoadConstractionModel.getMovementInviscidLayerReliability().get(i)>=RoadConstractionModel.getRoadConstraction().getRoad().getkN()){
                    inviscLayerMovemmentReliability.add(reliabilityI + "Вибрана конструкція задовольняє вимогу надійності за критерієм зсуву в нев'язких матеріалах.\n");
                }
                else{
                    excellentBool = false;
                    inviscLayerMovemmentReliability.add(reliabilityI + "Вибрана конструкція незадовольняє вимогу надійності за критерієм зсуву в нев'язких матеріалах.\n");
                }
            }
        }
        else{
            inviscLayerMovemmentResult.add("В конструкції дорожнього одягу відсутні шари з нев'язких матеріалів. Тому розрахунок показника міцності за критерієм зсуву в нев'язких матеріалах не проводитися.\n");
            inviscLayerMovemmentConclusion.add(" ");
            inviscLayerMovemmentMargin.add(" ");
            inviscLayerMovemmentReliability.add(" ");
        }
        roadCost = "\nВартість однієї одиниці площі дорожнього покриття = " + RoadConstractionModel.roadCost() + " .";
    }

    private void write(File directory, RoadConstraction roadConstraction, boolean bool){
        try {
            File fileForReport = new File(directory, "report"+ Calendar.getInstance().getTime() +".dat");
            File fileExcReport = new File(directory, "excellentReport"+ Calendar.getInstance().getTime() + ".dat");
            if(bool){
                if (excellentBool == true) {
                    excellentResultWriter = new FileWriter(fileExcReport, true);
                    print(excellentResultWriter, roadConstraction);

                    File directoryForRoadConstr = new File(directory.getParentFile(), "road constraction");
                    if(!directoryForRoadConstr.exists()) {
                        directoryForRoadConstr.mkdir();
                    }
                    String dirName = Calendar.getInstance().getTime().toString();
                    File dir = new File(directoryForRoadConstr,dirName);
                    dir.mkdir();

                    StringBuilder fileName = new StringBuilder();
                    for (Layer layer : RoadConstractionModel.getRoadConstraction().getTotalLayerList()) {
                        fileName.append(layer.getThickness() + " ");
                    }

                    File fileForWrite = new File(dir, fileName.toString());
                    fileForWrite.createNewFile();
                    try (FileOutputStream fos = new FileOutputStream(fileForWrite);
                         ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                        oos.writeObject(RoadConstractionModel.getRoadConstraction());
                        oos.flush();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                if (excellentBool == true) {
                    excellentResultWriter = new FileWriter(fileExcReport, true);
                    print(excellentResultWriter, roadConstraction);
                } else {
                    resultWriter = new FileWriter(fileForReport, true);
                    print(resultWriter, roadConstraction);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(FileWriter fileWriter, RoadConstraction roadConstraction){
        try {
            fileWriter.write(roadConstraction.toString() + "\n");
            fileWriter.write(tensionResult);
            fileWriter.write(tensionConclusion);
            fileWriter.write(tensionMargin);
            fileWriter.write(tensionReliability + "\n");
            fileWriter.write(deflectionResult);
            fileWriter.write(deflectionConclusion);
            fileWriter.write(deflectionMargin);
            fileWriter.write(deflectionReliability + "\n");
            fileWriter.write(subGradeMovementResult);
            fileWriter.write(subGradeMovementConclusion);
            fileWriter.write(subGradeMovementMargin);
            fileWriter.write(subGradeMovementReliability + "\n");
            for (int i = 0; i<inviscLayerMovemmentResult.size(); i++) {
                fileWriter.write(inviscLayerMovemmentResult.get(i));
                fileWriter.write(inviscLayerMovemmentConclusion.get(i));
                fileWriter.write(inviscLayerMovemmentMargin.get(i));
                fileWriter.write(inviscLayerMovemmentReliability.get(i));
            }
            fileWriter.write(roadCost);
            fileWriter.write("\n\n");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
