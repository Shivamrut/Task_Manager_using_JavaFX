package com.example.task_manager;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class EditTaskController {
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    private Button editBtn,backBtn;
    @FXML
    private TextField taskName,editId;

    @FXML
    private ChoiceBox<String> statusChoice;

    private TaskManager taskManager;

    public void setTaskManager(TaskManager taskManager)
    {
        this.taskManager = taskManager;
//        System.out.println("Setting taskmanager");
    }

    public void edit(ActionEvent event)
    {
        int id =0;
        boolean correctId=false;
        try{
            id = Integer.parseInt(editId.getText());
            correctId = true;
        }
        catch (Exception e)
        {
            correctId = false;
        }
        String name = taskName.getText();
        String statusChoiceValue = statusChoice.getValue();

        if(correctId)
        {
            boolean idFound = false;
            for(Task t : taskManager.getTasks()){
                if(t.getId()==id){
                    if(!name.equals("")){
                        t.setTitle(name);
                    }
                    if(statusChoiceValue!=null)
                    {
                        boolean status = statusChoiceValue.equals("Completed");
                        t.setStatus(status);
                    }
                    idFound = true;
                    break;
                }

            }
            if(!idFound)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ID Error");
                alert.initOwner(((Node)event.getSource()).getScene().getWindow());
                alert.setHeaderText("Hey!!!");
                alert.setContentText("ID not found!!\nEnter valid Task Id!");
                alert.show();
            }
            clearfields();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ID Error");
            alert.setHeaderText("Hey!!!");
            alert.initOwner(((Node)event.getSource()).getScene().getWindow());
            alert.setContentText("Please enter a valid integer task id!!\nTask ID is a must!");
            alert.show();

        }
    }

    public void clearfields()
    {
        taskName.clear();
        editId.clear();
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
