import socket
import math
import matplotlib.pyplot as plt
import pickle
import bisect

def graph(x_value):
    delay = 2 #2ms
    
    y_value = [0 for i in range(len(x_value))]
    for i in range(1 , len(x_value)):
        y_value[i] = abs(x_value[i] - x_value[i - 1]) * delay + y_value[i - 1]

    plt.plot(x_value , y_value , marker='o' , markersize=12)    
    plt.xlabel('Track No.s')
    plt.ylabel('Time taken')
    plt.title('Disk-Scheduling') 
      
    plt.show()      

# First Come First Serve Disk Scheduling algorithm.
def fcfs(disk_requests , head_position , last_position):
    order = [head_position]
    order.extend(disk_requests)
    graph(order)

    
# SCAN Disk Scheduling algorithm
def scan(disk_requests, head_position , last_position):
    disk_requests.sort()
    idx = bisect.bisect_left(disk_requests , head_position , 0 , len(disk_requests)) 
    
    order = [head_position]
    order.extend(disk_requests[idx : ])
    
    if (disk_requests[-1] != last_position):
        order.append(last_position)
    
    order.extend(disk_requests[idx - 1:: -1])
    graph(order)    

# CSCAN Disk Scheduling algorithm
def cscan(disk_requests, head_position , last_position):
    disk_requests.sort()
    idx = bisect.bisect_left(disk_requests , head_position , 0 , len(disk_requests)) 
    
    order = [head_position]
    order.extend(disk_requests[idx : ])
    
    if (disk_requests[-1] != last_position):
        order.append(last_position)
    if (disk_requests[0] != 0):
        order.append(0)
    order.extend(disk_requests[:idx])
    graph(order) 
    

# LOOK Disk Scheduling algorithm
def look(disk_requests, head_position , last_position):
    disk_requests.sort()
    idx = bisect.bisect_left(disk_requests , head_position , 0 , len(disk_requests)) 
    
    order = [head_position]
    order.extend(disk_requests[idx : ])
  
    order.extend(disk_requests[idx - 1:: -1])
    graph(order)   


# CLOOK Disk Scheduling algorithm
def clook(disk_requests, head_position , last_position):
    disk_requests.sort()
    idx = bisect.bisect_left(disk_requests , head_position , 0 , len(disk_requests)) 
    
    order = [head_position]
    order.extend(disk_requests[idx : ])
    
    order.extend(disk_requests[:idx])
    graph(order) 


#Shortest Seek Time First Disk Scheduling algorithm
def sstf(disk_requests , head_position , last_position):
    order = []
    disk_requests.append(head_position)
    disk_requests.sort()
    last = bisect.bisect_left(disk_requests , head_position , 0 , len(disk_requests))
    
    while (len(disk_requests) > 0):
        if (last == 0):
            order.append(disk_requests[0])
            disk_requests.pop(0)
        elif (last == len(disk_requests)):
            last -= 1
            order.append(disk_requests[-1])
            disk_requests.pop()
        else:
            order.append(disk_requests[last])
            last_prev = last
            if ((disk_requests[last] - disk_requests[last - 1]) <= (disk_requests[last + 1] - disk_requests[last])):
                last -= 1
            disk_requests.pop(last_prev) 
     
    graph(order)



def valid(disk_requests , last_position):
    for i in disk_requests:
        if (i > last_position or i < 0):
            return False
    return True
    
    


if __name__ == "__main__" :

    server_socket = socket.socket()      
    host_name = socket.gethostname()   
    port = 12345
         
    server_socket.bind((host_name, port))    
    server_socket.listen(5)
    
    print("waiting for the connections.....")
    
    menu_msg = """
        Choose the disk scheduling algorithm:
        1. First Come First Serve
        2. Shortest Seek Time First
        3. SCAN
        4. CSCAN
        5. LOOK
        6. CLOOK 
        
      """   
            
    while (True): 
    
       client_socket , client_addr = server_socket.accept()         
       print ('Connected to : ', client_addr) 
       
       client_socket.send(menu_msg.encode()) 
       
       data=  client_socket.recv(4096)
       
       data = pickle.loads(data)
       
       choice = data.get("choice")
       
       start_track = data.get("start_track")
       
       queue = data.get("queue")   
       
       last_position = data.get("last_position")
       
       if (not valid(queue , last_position)):
            print("inValid track no.s")
       elif (choice == 1):
            fcfs(queue , start_track , last_position)
       elif (choice == 2):
            sstf(queue , start_track , last_position)
       elif (choice == 3):
            scan(queue , start_track , last_position)
       elif (choice == 4):
            cscan(queue , start_track , last_position)
       elif (choice == 5):
            look(queue , start_track , last_position)
       elif (choice == 6):
            clook(queue , start_track , last_position)
       else:
            print("invalid")
       
       client_socket.close() 
