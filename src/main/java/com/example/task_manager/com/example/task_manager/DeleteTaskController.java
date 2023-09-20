package com.example.task_manager;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.Optional;

public class DeleteTaskController {

    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button deleteBtn,backBtn,deleteAllBtn;
    @FXML
    private TextField deleteId;

    private TaskManager taskManager;

    public void setTaskManager(TaskManager taskManager)
    {
        this.taskManager = taskManager;
//        System.out.println("Setting taskmanager");
    }

    public void delete(ActionEvent event)
    {
        int id = 0;
        boolean correctId=false;
        try{
            id = Integer.parseInt(deleteId.getText());
            correctId = true;
        }
        catch (Exception e)
        {
            correctId = false;
        }
        if(correctId)
        {
            int index=0;
            boolean indexFound = false;
            for(Task t: taskManager.getTasks())
            {
                if(t.getId()==id){
                    indexFound = true;
                    break;
                }
                index++;
            }
            if(indexFound)
            {
                taskManager.getTasks().remove(index);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Id Error");
                alert.setHeaderText("Hey!!");
                alert.setContentText("Id not found!!\nEnter valid ID");
                alert.show();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Id Error");
            alert.initOwner(((Node)event.getSource()).getScene().getWindow());
            alert.setHeaderText("Hey!!");
            alert.setContentText("Id of Task must be valid!!");
            alert.show();
        }
        clearfields();
    }

    public void clearfields()
    {
        deleteId.clear();
    }

    public void deleteAllTasks(ActionEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("ALERT");
        alert.initOwner(((Node)event.getSource()).getScene().getWindow());
        alert.setHeaderText("Do you want to delete all tasks permanently?");
        alert.setContentText("Please confirm your choice.");

        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK)
        {
            taskManager.getTasks().clear();
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Delete All");
            success.initOwner(((Node)event.getSource()).getScene().getWindow());
            success.setHeaderText("You opted for deletion of all saved tasks.");
            success.setContentText("All tasks were successfully cleared");
            success.show();
        }
        else{
            Alert error = new Alert(Alert.AlertType.INFORMATION);
            error.setTitle("Delete All");
            error.setHeaderText("Deletion Failed");
            error.initOwner(((Node)event.getSource()).getScene().getWindow());
            error.setContentText("You rejected confirmation!");
            error.show();
        }

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
