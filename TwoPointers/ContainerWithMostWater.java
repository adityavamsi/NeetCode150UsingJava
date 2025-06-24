class Question{
    //LC - 11
     /*
     * You are given an integer array heights where heights[i] represents the height of the
     * ith bar.

    You may choose any two bars to form a container. Return the maximum amount of water a container can store.

    Example 1:

    Input: height = [1,7,2,5,4,7,3,6]
    Output: 36

    Example 2:

    Input: height = [2,2,2]
    Output: 4

    Constraints:

    2 <= height.length <= 1000
    0 <= height[i] <= 1000*/
}


class Solution {
    public int maxArea(int[] height) {
        int s=0,e=height.length-1;
        int ans=0;
        while(s<e){
            ans = Math.max(ans,(e-s)*Math.min(height[e],height[s]));
            if(height[s]<height[e]) s++;
            else e--;
        }
        return ans;
    }

}