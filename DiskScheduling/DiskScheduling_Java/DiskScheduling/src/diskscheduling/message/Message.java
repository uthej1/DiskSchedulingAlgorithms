package diskscheduling.message ;
import java.io.* ;
public class Message implements Serializable {
	public int arr[] , headPosition , lastPosition , algorithm ;
	public boolean isValid ;
	public Message(int arr[] , int headPosition , int lastPosition , int algorithm) {
		this.arr = new int[arr.length] ;
		System.out.println(arr.length) ;
		for (int i = 0 ; i < arr.length ; i++) {
			this.arr[i] = arr[i] ;
		}
		this.headPosition = headPosition ;
		this.lastPosition = lastPosition ;
		this.algorithm = algorithm ;
		isValid = true ;
	}
	public String toString() {
		return "" ;
	}
}