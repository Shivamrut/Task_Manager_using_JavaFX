package com.example.task_manager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class TaskManager {

    private ObservableList<Task> tasks;

    public TaskManager(){

        tasks = FXCollections.observableArrayList();

    }

    public void add(Task task)
    {
        tasks.add(task);
    }
    public void deleteTask(Task task)
    {
        tasks.remove(task);
    }

    public void edit(int index, Task task)
    {
        tasks.set(index, task);
    }

    public ObservableList<Task> getTasks() {
        return tasks;
    }

    public void readTasksFromFile(String filepath)
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(filepath)))
        {
            String line;
            int i=1;
            while((line= reader.readLine())!=null)
            {
                String[] parts = line.split(",");
                if(parts.length==2)
                {
                    String taskName = parts[0];
                    boolean tastStatus = Boolean.parseBoolean(parts[1]);
                    Task task = new Task(taskName,tastStatus,i);
                    i++;
                    tasks.add(task);
                }
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public int getCurId()
    {
        if(tasks.size()==0)
            return 1;
        return tasks.get(tasks.size()-1).getId()+1;
    }
    public void writeTasksToFile(String filepath)
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath)))
        {
            for(Task t : tasks)
            {
                writer.write(t.getTitle() + "," + t.isStatus() + "\n");
            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
