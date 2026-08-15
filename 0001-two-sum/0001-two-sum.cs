public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int,int> map=new Dictionary<int,int>();
        map.TryAdd(nums[0],0);
        for(int i=1;i<nums.Length;i++){
            if(map.TryGetValue(target-nums[i],out int index)){
                return new int[]{i,index};
            }
            map.TryAdd(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}