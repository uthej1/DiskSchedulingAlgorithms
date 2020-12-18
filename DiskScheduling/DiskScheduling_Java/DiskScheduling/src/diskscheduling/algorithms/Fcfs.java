package diskscheduling.algorithms ;
public class Fcfs {
	
	public static int[] fcfs(int diskRequests[] , int headPosition , int lastPosition) {
		int order[] = new int[diskRequests.length + 1] ;
		order[0] = headPosition ;
		
		for (int i = 0 ;  i < diskRequests.length ; i++) {
			order[i + 1] = diskRequests[i] ;
		}
		
		return order ;
	}
	
}
