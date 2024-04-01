import java.util.Arrays;

class Solution {
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0; i != n; ++i) {
            nums1[m + i] = nums2[i];
        }
        Arrays.sort(nums1);

        for(int s: nums1)
            System.out.println(s);
    }

    public static void main(String[] args){

        int[] nums1 = new int[]{0}, nums2 = new int[]{1};
        int m = 0,  n = 1;

        merge1(nums1,m,nums2,n);

    }
}