import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length+nums2.length)%2 == 0)
            return find(nums1,nums2,(nums1.length+nums2.length)/2);
        return ((double)find(nums1,nums2,(nums1.length+nums2.length)/2)+find(nums1,nums2,(nums1.length+nums2.length)/2+1))/2;
    }
    public int find(int[] nums1, int[] nums2, int k){
        if (nums1.length == 0)
            return nums2[k];
        if (nums2.length == 0)
            return nums1[k];
        if (k == 1){
            return Math.min(nums1[0],nums2[0]);
        }
        if (nums1.length<k/2)
            return find(nums1,Arrays.copyOfRange(nums2, k/2, nums2.length),k/2);
        if (nums2.length<k/2)
            return find(Arrays.copyOfRange(nums1, k/2, nums1.length),nums2,k/2);
        if (nums1[k/2]<=nums2[k/2])
            return find(nums1,Arrays.copyOfRange(nums2, k/2, nums2.length),k/2);
        return find(Arrays.copyOfRange(nums1, k/2, nums1.length),nums2,k/2);
    }
}