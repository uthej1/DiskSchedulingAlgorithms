import socket
import pickle 
client_socket = socket.socket() 
host_name = socket.gethostname() 
port = 12345
  
 
client_socket.connect((host_name, port)) 
  
     
print (client_socket.recv(1024).decode())
 


choice = (int(input("Enter the choice :  ")))

start_track = (int(input("Enter the starting track :  ")))

last_position = (int(input("Enter the last track no. in the disk :  ")))


print("enter the queue :  ")

queue = list(map(int,input().split()))

d = {"choice" : choice, "start_track" : start_track, "queue" : queue , "last_position" : last_position}

d = pickle.dumps(d)

client_socket.send(d)


   
client_socket.close()