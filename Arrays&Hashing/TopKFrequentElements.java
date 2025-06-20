class Question {
    //LC - 347
    /*Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    * Example 1:
    * Input: nums = [1,1,1,2,2,3], k = 2
    * Output: [1,2]
    *
    * Example 2:
    * Input: nums = [1], k = 1
    * Output: [1]
    *
    * Constraints:
    * 1 <= nums.length <= 105
    * k is in the range [1, the number of unique elements in the array].
    * It is guaranteed that the answer is unique.
    *
    * Follow-up : The time complexity of this function may be better than O(n log n) where n is the array's size.
    */
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n=nums.length;
        Map<Integer,Integer> mp = new HashMap();
        Queue<Integer> mh = new PriorityQueue((a,b)-> mp.get(a)-mp.get(b));

        for(int i=0;i<n;i++) mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);

        for(int num: mp.keySet()){
            mh.add(num);
            if(mh.size()>k) mh.poll();
        }

        int[] ans = new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=mh.poll();
        }
        return ans;
    }
}