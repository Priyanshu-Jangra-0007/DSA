public class Solution {
    public int FindDuplicate(int[] nums) {
        Dictionary<int,int> map=new Dictionary<int,int>();
        for(int i=0;i<nums.Length;i++){
            if(map.ContainsKey(nums[i])){
                map[nums[i]]++;
            }
            else{
                map[nums[i]]=1;
            }
        }
        foreach(var item in map){
            if(item.Value>1){
                return item.Key;
            }
        }
        return -1;
    }
}