package diskscheduling.client ;
import javafx.application.Application ; 
import java.io.ObjectOutputStream ;
import java.io.ObjectInputStream ;
import java.net.* ;
import java.util.Scanner ;
import diskscheduling.graph.Graph;
import diskscheduling.message.Message ;

public class Client {
	
	public static void main(String args[]) throws Exception {
		
		Scanner ip = new Scanner(System.in) ;
		System.out.println("Welcome client") ;
		int port = 3378 ;
		
		System.out.println("Enter\n1.First Come First Server\n2.Shortest Seek Time First\n3.SCAN\n4.CSCAN\n5.LOOK\n6.CLOOK") ;
		int type = ip.nextInt() ;
		System.out.println("Enter the head initial position") ;
		int head = ip.nextInt() ;
		System.out.println("Enter the last track no.") ;
		int last = ip.nextInt() ;
		System.out.println("Enter the requests") ;
		String c = ip.nextLine() ;
		String str[] = ip.nextLine().split(" ") ;
		
		int arr[] = new int[str.length] ;
		for (int i = 0 ; i < str.length ; i++) {
			arr[i] = Integer.parseInt(str[i]) ;
		}
		
		Message obj = new Message(arr , head , last , type) ;
		Socket client = new Socket("localhost" , port) ;
		ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream()) ;
		ObjectInputStream ois = new ObjectInputStream(client.getInputStream()) ;
		
		oos.writeObject(obj) ;
		obj = (Message) ois.readObject() ;
		
		if (obj.isValid) {
			int x[] = Arrays.copyOfRange(obj.arr, 0, obj.arr.length) ; 
			int y[] = new int[x.length] ;
			for (int i = 1 ; i < x.length ; i++) {
				y[i] = y[i - 1] + Math.abs(x[i] - x[i - 1]) ;
			}
			Graph.x = x ;
			Graph.y = y ;
			String temp[] = new String[0] ;
			Application.launch(Graph.class , temp) ;
			
		} else {
			System.out.println("The data you entered is incorrect") ;
		}
		client.close() ;
		ip.close() ;

	}
}
