class Question{
    // LC-1046
    /*
    You are given an array of integers stones where stones[i] is the weight of the ith stone.

We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:

If x == y, both stones are destroyed, and
If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.
At the end of the game, there is at most one stone left.

Return the weight of the last remaining stone. If there are no stones left, return 0.



Example 1:

Input: stones = [2,7,4,1,8,1]
Output: 1
Explanation:
We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
Example 2:

Input: stones = [1]
Output: 1


Constraints:

1 <= stones.length <= 30
1 <= stones[i] <= 1000
    */
}

class Solution {
    public int lastStoneWeight(int[] stones) {

        //Har time mujhe top 2 elements chahiye  therefore we gotta use priority queue

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0 ; i<stones.length ; i++){

            pq.offer(stones[i]);
        }

        while(true){

            if(pq.isEmpty()) return 0 ;
            int top1 = pq.poll();
            if(pq.isEmpty()) return top1 ;
            int top2 = pq.poll();

            if(top1==top2){
                continue ; // skip the iteration
            }
            else{
                pq.offer(top1-top2);
            }
        }


    }
}