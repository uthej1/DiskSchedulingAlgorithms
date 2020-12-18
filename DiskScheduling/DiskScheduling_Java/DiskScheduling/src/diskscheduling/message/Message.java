package diskscheduling.message ;
import java.io.Serializable ;
import java.util.Arrays ;

public class Message implements Serializable {
	
	public int arr[] , headPosition , lastPosition , algorithm ;
	public boolean isValid ;
	
	public Message(int arr[] , int headPosition , int lastPosition , int algorithm) {
		this.arr = Arrays.copyOfRange(arr , 0 , arr.length) ;
		this.headPosition = headPosition ;
		this.lastPosition = lastPosition ;
		this.algorithm = algorithm ;
		isValid = true ;
	}
	
	public String toString() {
		return "" ;
	}
}
