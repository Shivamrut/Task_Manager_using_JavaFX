package com.example.task_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;



public class AddTaskController {
    @FXML
    private Button addBtn, backBtn;
    @FXML
    private TextField taskName;
    @FXML
    private ChoiceBox<String> statusChoice;

    private Parent root;
    private Scene scene;
    private Stage stage;
    private TaskManager taskManager;


    public void setTaskManager(TaskManager taskManager)
    {
        this.taskManager = taskManager;

//        System.out.println("reset cur id");
    }
    public void add(ActionEvent event)
    {
//        System.out.println("Adding");
        String name = taskName.getText();
        String selectedStatus = statusChoice.getValue();

        if (name != null && !name.isEmpty() && selectedStatus != null) {
            boolean status = selectedStatus.equals("Completed");
            taskManager.add(new Task(name, status,taskManager.getCurId()));

            clearFields(); // Optionally, clear the input fields after adding
        } else {
            // Handle the case where either the task name or status is not selected
//            System.out.println("Please enter a task name and select a status.");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Selection Error");
            alert.setHeaderText("Hey!!!");
            alert.initOwner(((Node)event.getSource()).getScene().getWindow());
            alert.setContentText("Please enter a task name and select a status.");
            alert.show();
        }
    }

    private void clearFields() {
        taskName.clear();
        statusChoice.getSelectionModel().clearSelection();
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
