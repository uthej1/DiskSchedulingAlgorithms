package diskscheduling.algorithms ;
import java.util.Arrays ;
import java.util.ArrayList ;
public class Look {
	
	private static int lowerBound(int arr[] , int val) {
		int ans = arr.length , left = 0 , right = arr.length - 1 ;
		
		while (left <= right) {
			int mid = (left + right) / 2 ;
			if (arr[mid] < val) {
				left = mid + 1 ;
			} else {
				right = mid - 1 ;
				ans = mid ;
			}
		}
		
		return ans ;
	}
	
	public static int[] look(int diskRequests[] , int headPosition , int lastPosition) {
		ArrayList<Integer> orderAl = new ArrayList<Integer>() ;
		orderAl.add(headPosition) ;
		Arrays.sort(diskRequests) ;
		int idx = lowerBound(diskRequests , headPosition) ;
		
		for (int i = idx ; i < diskRequests.length ; i++) {
			orderAl.add(diskRequests[i]) ;
		}

		for (int i = idx - 1 ;  i >= 0 ; i--) {
			orderAl.add(diskRequests[i]) ;
		}

		int order[] = new int[orderAl.size()] ;

		for (int i = 0 ; i < orderAl.size() ; i++) {
			order[i] = orderAl.get(i) ;
		}

		return order ;
	}
	
}
