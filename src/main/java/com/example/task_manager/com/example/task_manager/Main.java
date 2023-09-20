package com.example.task_manager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.util.Optional;

public class Main extends Application {

    private static TaskManager taskManager;
    private String filepath ;
    public Main()
    {
        try {
            filepath = this.getClass().getResource("userData.txt").toURI().getPath();
            this.taskManager = new TaskManager();
            this.taskManager.readTasksFromFile(filepath);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public static TaskManager getTaskManager()
    {
        return taskManager;
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Task Manager");

        stage.setScene(scene);
        stage.setResizable(false);
        Image icon = new Image(Main.class.getResourceAsStream("todo.png"));

        stage.getIcons().add(icon);
        stage.show();


        stage.setOnCloseRequest((event)->{
            try {
                closeApp(stage);
                event.consume();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {

        launch();
    }

    public void closeApp(Stage stage) throws  Exception
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Closing app");
        alert.initOwner(stage);
        alert.setHeaderText("Closing TaskManager");
        alert.setContentText("Do you want to save before exit?");


        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK)
        {

            taskManager.writeTasksToFile(filepath);
            stage.close();
        }
        else{
            stage.close();
        }


    }
}