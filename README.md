﻿# Task_Manager_using_JavaFX

 
 ***

## Application Overview
* This is what the application looks like when it is opened.

![Screenshot (93)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/8deeaba2-2168-4af1-a955-7eb4fc251e3c)
* If this is the first time using the application after installation, when you click view tasks, this is how it will look like with empty tasks.<br> If you already used the application before, then the saved tasks will appear here, which we will see in next few steps.

![Screenshot (94)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/c293b7af-5ccf-48b3-8b6c-4f26f43f5000)
* When you click add tasks button, the window will change to this.<br> Here you need to mention task name and task status i.e, whether it is pending or completed. <br>If you do not mention either of task name or tast status an error alert will pop up. 

![Screenshot (96)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/ce71f06e-1cea-4f91-b756-e8fa26f24cbd)
* After addition of a task, when you click view tasks button, you can see that the task which you added is now visible.

![Screenshot (97)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/18a75899-673d-47bd-aa23-d9db4db30dff)
* You can keep on adding tasks, it will assign them proper ids.<br> **Note**: The id will not be same everytime.<br> Ids are for reference to use during editing and deleting, so they are relative to the list at that point.

![Screenshot (99)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/6c38c915-d74d-4ad2-a7cc-30fbe77833e8)
* Lets look at the edit functionality. <br> The only thing you must mention here is the valid Id.<br> You can leave either of name or status or even both empty. <br>
But you must mention Id, else it will give error dialogbox. <br> Now say from the tasks we added before, petting my cat task was pending. <br> Lets say after some time I did pet my cat and now I want to update it.<br> I can simply give the Id from view tasks and select the status as completed leaving task name empty. <br> This will work properly.

![Screenshot (101)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/b37ce741-f7a8-4996-93be-2ecc8bfc5880)
* You can see that the tasks got updated.

![Screenshot (102)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/5d3f044e-013a-4b4f-8b44-17e2df8cc1fb)
* Again lets add one more task for sake of more examples.

![Screenshot (103)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/c8625326-de2f-4b89-abdf-bf29fcf9456a)
* Lets explore delete functionality now.<br>
When you click delete task button in main window, you will see two options.<br>
Delete and Delete All Tasks.<br>
If you click the Delete button, you need to mention the id of the tast that you want to delete.<br>

![Screenshot (104)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/568f623c-7fe8-424f-a1d1-296d5325e0f2)
* You can see the updated list with deleted task.

![Screenshot (105)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/f0693680-2b8c-4ee3-afe8-faab1cb5331d)
* If you select Delete All Tasks button then you will be asked again for confirmation.<br>
This is because once deleted you cant get back the deleted tasks.

![Screenshot (106)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/635ee6ed-7600-42c5-b446-ecc4971e0d10)
* After deletion of all tasks, Successfull Deletion message will be shown.

![Screenshot (107)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/048492fc-93c6-451d-878a-f3129a3f5a77)
* You can view tasks list, it will be empty.

![Screenshot (108)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/2ae613b7-98c9-44f3-941f-339e018ef388)
* Now if you want to close the program, a dialogue box will appear.<br>
It will ask for your confirmation to whether save the changes made or not.<br>
If you select not to save changes, all the changes you made since starting the application will be restored.<br>
So please be carefull while closing the program.
![Screenshot (109)](https://github.com/Shivamrut/Task_Manager_using_JavaFX/assets/49057156/ce512914-d2ee-4096-a49a-13748589c8e8)
