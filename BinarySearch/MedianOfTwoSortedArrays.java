class Question{
    //LC - 4
    /*
    Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
    */
}

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        if(n1>n2) return findMedianSortedArrays(nums2,nums1);
        int n = n1+n2;
        int left = (n1+n2+1)/2;
        int s=0,e=n1;
        while(s<=e){
            int mid1 = (s+e)/2;
            int mid2 = left-mid1;
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE, r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;
            if(mid1<n1) r1 = nums1[mid1];
            if(mid2<n2) r2 = nums2[mid2];
            if(mid1-1>=0) l1 = nums1[mid1-1];
            if(mid2-1>=0) l2 = nums2[mid2-1];
            if(l1<=r2 && l2<=r1){
                if(n%2==1) return Math.max(l1,l2);
                return (double)(Math.max(l1,l2)+Math.min(r1,r2))/2.0;
            }
            else if(l1>r2) e=mid1-1;
            else s=mid1+1;

        }
        return 0;
    }
}