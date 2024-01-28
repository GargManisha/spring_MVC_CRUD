# Spring_MVC_CRUD
In this project, I have used spring MVC, thyme leaf for creating Employee directory for performing CRUD operations. For DB, SQL server is used.

For running this project - 
 - Need to import project in any IDE that supports Maven dependencies.
 - Need to change database connections in application.properties file.
 - This project is running on Java 17.  

In this project, I have created **two controller classes**. 
 -  **EmployeeMVCController** class is used in case of **spring MVC**.
 -  **EmployeeController** class is used for simple **JpaRepository project**.

The **main difference** in both the file is the annotation.
For **spring MVC**, must use **@Controller annotation**. And do not use @RestController annotation.
@RestController annotation is the combination of @Rest and @Controller annotation and it return the data in the form of ResponseEntity.

So, if you want to return your html file name from controller class, then you must use only @Controller anntation.
