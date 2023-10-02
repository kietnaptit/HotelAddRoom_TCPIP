# Hotel reservation management application - Add Room Function 

# Requirement
* Client Side: A GUI uses Java Swing that have Room ID, Room Name, Room Type (Normal, VIP), Room price
* Server Side: Connect with MySQL JDBC to add information to Database. Before add new room to database, server must check is room exisited or not (Two Room must not have same ID or Room Name)
* Client and Server connect through TCP/IP protocol (DataInput/OutputStream, ObjectInput/OutputStream)

# DEMO Image
* Client Slide GUI
![](https://i.imgur.com/99S7Qtr.png)

# Tools
* Java IDE (Netbeans, Eclipse)
* MySQL Server & MySQL Workbench
* JDBC Driver (mysql-connector-j-8.1.0.jar)

# CREATE TABLE Command
```
CREATE TABLE room(
	id int PRIMARY KEY,
    name VARCHAR(255),
    type VARCHAR(255),
    price int

)
```