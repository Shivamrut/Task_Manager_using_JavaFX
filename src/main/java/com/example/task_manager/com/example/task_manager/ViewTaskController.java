package com.example.task_manager;


import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class ViewTaskController {

    @FXML
    private Button back;
    @FXML
    private Label title;
    @FXML
    private ScrollPane scroll;
    @FXML
    private ListView<Task> listview;
    private Parent root;
    private Scene scene;
    private Stage stage;

    private TaskManager taskManager;

    public void setTaskManager(TaskManager taskManager)
    {
        this.taskManager = taskManager;
//        System.out.println("Setting taskmanager");
    }

    @FXML
    public void initialize(){
        Platform.runLater(()->{
            if(taskManager!=null){
//                System.out.println("Not null");
                ObservableList<Task> tasks = taskManager.getTasks();
                listview.setItems(tasks);
            }
            else {
                System.out.println("Null TaskManager");

            }
        });

    }
    public void backToMainMenu(ActionEvent event)
    {
        try{
            root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
