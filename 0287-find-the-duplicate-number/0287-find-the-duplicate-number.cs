public class Solution {
    public int FindDuplicate(int[] nums) {
        int n = nums.Length;
        var freq = new int[n + 1];
        int result = 0;
        for(int i = 0; i < nums.Length; i++){
            freq[nums[i]]++;
        }
        for(int i = 0; i < freq.Length; i++){
            if(freq[i] > 1){
                result = i;
                break;
            }           
        }

        return result;
    }
}