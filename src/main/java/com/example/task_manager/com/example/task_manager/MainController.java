package com.example.task_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MainController {
    @FXML
    private Button addBtn,viewBtn,deleteBtn,editBtn;
    @FXML
    private Label welcomeLabel,optionsLabel;

    private Parent root;
    private Scene scene;
    private Stage stage;

    private TaskManager taskManager;

    public MainController()
    {


    }

    @FXML
    public void initialize()
    {
        taskManager = Main.getTaskManager();
    }

    public void setTaskManager(TaskManager taskManager)
    {
        this.taskManager = taskManager;
    }
    public void viewTasks(ActionEvent event)
    {
//        System.out.println("Viewing tasks");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("viewTasks.fxml"));
            root = fxmlLoader.load();

            // Access the controller of the loaded viewTasks.fxml
            ViewTaskController controller = fxmlLoader.getController();

            // Pass the TaskManager instance to the viewTaskController using setTaskManager
            if(taskManager==null) System.out.println("tybj");
            controller.setTaskManager(taskManager);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void addTask(ActionEvent event)
    {
//        System.out.println("Adding task");
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addTask.fxml"));
            root = fxmlLoader.load();

            AddTaskController controller = fxmlLoader.getController();
            controller.setTaskManager(taskManager);


            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void editTasks(ActionEvent event)
    {
        try
        {
            FXMLLoader loader =  new FXMLLoader(getClass().getResource("editTasks.fxml"));
            root = loader.load();

            EditTaskController controller = loader.getController();
            controller.setTaskManager(taskManager);

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void deleteTask(ActionEvent event)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("deleteTask.fxml"));
            root = loader.load();

            DeleteTaskController controller = loader.getController();
            controller.setTaskManager(taskManager);

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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