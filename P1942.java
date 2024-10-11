class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int totalFriends = times.length;
        int arrivalLookup = times[targetFriend][0];

        Arrays.sort(times, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<Integer[]> chairDepartures = new ArrayList<>();
        Map<Integer, Integer> arrivalChair = new HashMap<>();
        for(int i=0; i<totalFriends; i++) {
            int chairId = chairAvailable(chairDepartures,times[i]);

            arrivalChair.put(times[i][0], chairId);
        }
        return arrivalChair.get(arrivalLookup);
    }
    

    public int chairAvailable(List<Integer[]> chairDepartures, int[] time) {
        for(int i =0; i< chairDepartures.size(); i++) {
            if(chairDepartures.get(i)[1]<=time[0]) {
                chairDepartures.set(i,new Integer[]{time[0], time[1]});
                return i;
            }
        }
        chairDepartures.add(new Integer[]{time[0], time[1]});
        return chairDepartures.size()-1;
    }
}

public class P1942 {
  public static void main(String[] args) {
    
  }
}
