package diskscheduling.algorithms ;
import java.util.Arrays ;
import java.util.ArrayList ;

public class CScan {
	
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
	
	public static int[] cscan(int diskRequests[] , int headPosition , int lastPosition) {
		ArrayList<Integer> orderAl = new ArrayList<Integer>() ;
		orderAl.add(headPosition) ;
		Arrays.sort(diskRequests) ;
		int idx = lowerBound(diskRequests , headPosition) ;
		
		for (int i = idx ; i < diskRequests.length ; i++) {
			orderAl.add(diskRequests[i]) ;
		}

		if (diskRequests[diskRequests.length - 1] != lastPosition) {
			orderAl.add(lastPosition) ;
		}

		if (diskRequests[0] != 0) {
			orderAl.add(0) ;
		}
		for (int i = 0;  i < idx ; i++) {
			orderAl.add(diskRequests[i]) ;
		}

		int order[] = new int[orderAl.size()] ;

		for (int i = 0 ; i < orderAl.size() ; i++) {
			order[i] = orderAl.get(i) ;
		}
		return order ;
	}
}
