

[[_TOC_]]


# Spring Boot

Spring Boot is an open source Java-based framework used to create a micro Service. It is developed by Pivotal Team and is used to build stand-alone and production ready spring applications.

Spring Boot automatically configures your application based on the dependencies you have added to the project by using @EnableAutoConfiguration annotation. For example, if MySQL database is on your classpath, but you have not configured any database connection, then Spring Boot auto-configures an in-memory database.

The entry point of the spring boot application is the class contains @SpringBootApplication annotation and the main method.

Spring Boot automatically scans all the components included in the project by using @ComponentScan annotation. 


# Creating a new Spring Boot application/project using product Catalog

1.  You may create a new Spring boot project using the Spring boot catalog. 

Note: You must be having rights to create the project.
    


# Cloning and Working on a spring boot application

1. Open a terminal window.

2. Create a local directory to hold your Spring Boot application by typing mkdir SpringBoot

3. Change to that directory by typing cd SpringBoot.

5. Clone the Spring Boot Getting Started sample project into the directory you created following any of the below method.
    a. Using Command line GIT 
      by typing 
      ``````````````````````````````
      git clone https://netapp-ngdc@dev.azure.com/netapp-ngdc/devexp/_git/<Project>
      `````````````````````````````````

    b. Using Visual Studio Code
       
      ```
    1. Click on the View->Command Palatte
    
    2. Type/Choose Git: Clone from the menu shown
    
    3. Type the URL to be cloned (URL can be got the Azure Devops terminal)
    
    4. If asked for the password, provide the token generated from Azure devops.
    
      ```
    c. From Azure Devops Terminal
        by

        
        1. Choose your desired workspace and the repository that need to be cloned

        2. Click Repos from the side menu.

        3. Click on "Clone" Shown on Top Right corner.

        4. Choose the IDE from the list provided in the IDE tab.

    Note: This repository provides boilerplate code to kick start development of web application.



6. Build the application either by using command line 
```
 mvn clean install 
 ```

or by using any of the IDE.

7. When the web app has been created, run the application

8. Test it locally by either visiting 
```
http://localhost:8080
```
 or typing
 ```
curl http://localhost:8080 
```
from another terminal window.

9. You should see the following message displayed:
```
 Hello from Spring Boot! 
```

10. You may start creating APIs based on your requirement as you do for any spring boot application build any spring boot application.

<h2 id="commit"> Committing the code.</h2>

Once you have made all the neccessary changes to the boilerplate code that you cloned, you may now commit the changes to the repository.

For commiting the changes you may use any of the following method.

1.  Using Git command: 
````````
type
git add -A && git commit -m "Your commit message"
``````````

2. Using Visual Studio Code
`````````````
1. Click on the "Source Control" icon on the left pane of Visual studio.

2.  Type your commit message in the message box at the top.

3.  You may stage all the files to be committed by clicking on the file and clicking on the stage icon, shown against that file.

4. Once you have staged all the files that you needs to be committed click on the tick mark shown on the top.

5. Make sure about the commit by visitng Azure devops terminal.
`````````````````````````

<h2 id="env_var"> Configuring and Using azure environment variables</h2>

In any spring boot application, if we need to configure/use any of the environment variables, we have a practise of configuring the same in a file named application.properties.

If a spring boot application is intended for cloud deployment using Azure platform then the enviroment variables can be configured in a file named application.yml.


<h2 id="build"> Passing through the build pipeline</h2>

The build definition in Azure DevOps automatically executes all the tasks in the build each time there’s a commit in the Java source application. 
Based on our configation done, Azure DevOps will use Maven to build a Java Spring Boot project.

Click at Pipeline->Build from the side menu and ensure if all the steps in build pipeline has been successfully passed.
If you find any issues, you may look into the logs by clicking on the link and resolve the issue and trigger the build pipeline again.

<h2 id="release"> Passing through the Release pipeline</h2>

Once the build is successfully completed, Click on the Pipeline->Release from the side menu, to check the status of deployment.

Based on the our configuration we have three environment into which the application can be deployed

1.  Workspace
2.  Stage
3.  Production



