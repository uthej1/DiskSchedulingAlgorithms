package diskscheduling.algorithms ;
import java.util.Arrays ;
import java.util.ArrayList ;

public class Sstf {
	
	private static int lowerBound(ArrayList<Integer> arr , int val) {
		int ans = arr.size() , left = 0 , right = arr.size() - 1 ;
		
		while (left <= right) {
			int mid = (left + right) / 2 ;
			if (arr.get(mid) < val) {
				left = mid + 1 ;
			} else {
				right = mid - 1 ;
				ans = mid ;
			}
		}
		
		return ans ;
	}
	
	public static int[] sstf(int diskRequests[] , int headPosition , int lastPosition) {
		ArrayList<Integer> orderAl = new ArrayList<Integer>() ;
		ArrayList<Integer> diskRequestsAl = new ArrayList<Integer>() ;
		
		for (int i : diskRequests) {
			diskRequestsAl.add(i) ;
		}
		
		diskRequestsAl.add(headPosition) ;
		Collections.sort(diskRequestsAl) ;
		int last = lowerBound(diskRequestsAl , headPosition) ;
		
		while (diskRequestsAl.size() > 0) {
			if (last == 0) {
				orderAl.add(diskRequestsAl.get(0)) ;
				diskRequestsAl.remove(0) ;
			} else if (last == diskRequestsAl.size()) {
				last-- ;
				orderAl.add(diskRequestsAl.get(diskRequestsAl.size() - 1)) ;
				diskRequestsAl.remove(diskRequestsAl.size() - 1) ;
			} else {
				orderAl.add(diskRequestsAl.get(last)) ;
				int last_prev = last ;
				if ((diskRequestsAl.get(last) - diskRequestsAl.get(last - 1)) <= (diskRequestsAl.get(last + 1) - diskRequestsAl.get(last))) {
					last-- ;
				}
				diskRequestsAl.remove(last_prev) ;
			}
		}
		
		int order[] = new int[orderAl.size()] ;
		
		for (int i = 0 ; i < orderAl.size() ; i++) {
			order[i] = orderAl.get(i) ;
		}
		
		return order ;
	}
}
