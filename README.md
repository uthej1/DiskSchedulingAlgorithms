# Disk Scheduling Algorithms

Client-server application for disk scheduling algorithms.<br>

This application supports 6 disk scheduling algorithms.<br>
1.First Come First Serve<br>
2.Shortest Seek Time First<br>
3.SCAN<br>
4.CSCAN<br>
5.LOOK<br>
6.CLOOK<br>

# How this works?<br>
At the Client-side:<br>
At the client side, head initial position, last track number, type of algorithm and the requests are sent to the server. Server sends back the order in which the requests are processed. A graph is plotted then displaying the order in which the requests are processed.<br>
At the Server-side:<br>
According to the type of algorithm, the order of evaluation is calculated and sent to the server.

# What packages/ Modules did we use?
Python: Socket, Matplotlib <br>
Java: Java.net, JavaFX<br> <br>

# Examples 
SSTF using Python<br>
![alt text](https://github.com/uthej1/DiskSchedulingAlgorithms/blob/main/DiskScheduling/Images/sstf%20cmd.PNG)<br>
Plot<br>
![alt text](https://github.com/uthej1/DiskSchedulingAlgorithms/blob/main/DiskScheduling/Images/sstf.PNG)<br><br>
LOOK using Java<br>
![alt text](https://github.com/uthej1/DiskSchedulingAlgorithms/blob/main/DiskScheduling/Images/scan%20eclipse.PNG)<br>
Plot<br>
![alt text](https://github.com/uthej1/DiskSchedulingAlgorithms/blob/main/DiskScheduling/Images/scan.PNG)

# Done by
J Uday Kumar Reddy, 1602-18-737-055<br>
T Uthej, 1602-18-737-056
