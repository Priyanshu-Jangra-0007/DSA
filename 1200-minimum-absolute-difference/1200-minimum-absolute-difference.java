class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int diff=arr[1]-arr[0];
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<arr.length-1;i++){
            int curr = arr[i+1]-arr[i];
            if(curr<diff) {
                diff=curr;
                ans.clear();
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
            else if(curr==diff){
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return ans;
    }
}