# LAB-BOOKING-ATTENDANCE

Some other links for functionality which do not have buttons on the main html webpage to get to yet:
/bookings/all - will display all bookings
/bookings/book - will allow for booking a seat, no link with student as there is no login yet
/id - where id is a number, this will display the details of the student with that id. Will display all details as null or 0 if there is no such student
/students - will display a json list of students, the proper way to view all students is via the display all students button
/id/deleteuser - where id is a number you enter and it is the id of the student you want to delete. It will immediately delete a student. eg /5/deleteuser

**How to Setup local MYSQL for the web application for Local Testing** 
MYSQL configurations : follow the table name, user name and password is all on *application.properties* file. Run the application using *springbootLrun* option. (Maven clean install is recommended). Then access the website through [here] (http://localhost:8080)

Example setup in application.properties 

```java
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/db_amigos
spring.datasource.username=spring
spring.datasource.password=ThePassword
```
