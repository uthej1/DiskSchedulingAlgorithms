package diskscheduling.server ;
import diskscheduling.algorithms.* ;
import diskscheduling.message.* ;
import java.net.* ;
import java.io.* ;
import java.util.* ;
public class Server {
	//Checks whether the disk requests has a valid order.
	private static boolean isValid(int arr[] , int headPosition , int lastPosition) {
		if (lastPosition < 0 || (headPosition > lastPosition || headPosition < 0)) {
			return false ;
		}
		for (int i = 0 ; i < arr.length ; i++) {
			if (arr[i] > lastPosition || arr[i] < 0) {
				return false ;
			}
		}
		return true ;
	}
	public static void main(String args[]) throws Exception {
		int port = Integer.praseInt(args[0]) ;
		
		System.out.println("Server waiting for connection") ;
		ServerSocket server = new ServerSocket(port) ;
		Socket client = server.accept() ;
		System.out.println("Client connected to the server") ;
		
		ObjectOutputStream os = new ObjectOutputStream(client.getOutputStream()) ;
		ObjectInputStream is = new ObjectInputStream(client.getInputStream()) ;
		
		Message obj = (Message)is.readObject() ;
		
		int type = obj.algorithm ;
		int diskRequests[] = Arrays.copyOfRange(obj.arr , 0 , obj.arr.length) ;
		int head = obj.headPosition ;
		int last = obj.lastPosition ;
		
		if (!isValid(diskRequests , head , last)) {
			obj.isValid = false ;
			os.writeObject(obj) ;
			client.close() ;
			server.close() ;
			return ;
		}
		
		switch (type) {
			case 1 : obj.arr = Fcfs.fcfs(diskRequests , head , last) ;
					break ; 
			case 3 : obj.arr = Scan.scan(diskRequests , head , last) ;
					break ;
			case 4 : obj.arr = CScan.cscan(diskRequests , head , last) ;
					break ;
			case 5 : obj.arr = Look.look(diskRequests , head , last) ;
					break ;
			case 6 : obj.arr = CLook.clook(diskRequests , head , last) ;
					break ;
			default : System.out.println("Wrong choice") ;
		}

		os.writeObject(obj) ;
		client.close() ;
		server.close() ;
	}
}
