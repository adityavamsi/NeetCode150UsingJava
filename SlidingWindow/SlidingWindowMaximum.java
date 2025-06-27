class Question{
    //LC - 239
    /*
    You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window.
    Each time the sliding window moves right by one position.
    Return the max sliding window.

    Example 1:

    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]

    Explanation:
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7       3
     1 [3  -1  -3] 5  3  6  7       3
     1  3 [-1  -3  5] 3  6  7       5
     1  3  -1 [-3  5  3] 6  7       5
     1  3  -1  -3 [5  3  6] 7       6
     1  3  -1  -3  5 [3  6  7]      7

    Example 2:

    Input: nums = [1], k = 1
    Output: [1]


    Constraints:

    1 <= nums.length <= 105
    -104 <= nums[i] <= 104
    1 <= k <= nums.length
    */
}

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];
        Deque<Integer> q = new LinkedList();
        int l=0,r=0;
        while(r<n){
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) q.removeLast();

            q.addLast(r);

            if (l > q.getFirst()) q.removeFirst();

            if ((r + 1) >= k) {
                ans[l] = nums[q.getFirst()];
                l++;
            }

            r++;
        }
        return ans;

    }
}