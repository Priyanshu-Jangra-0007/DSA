public class Solution {
    public bool IsAnagram(string s, string t) {
        char []arr1=s.ToCharArray();
        char []arr2=t.ToCharArray();
        Array.Sort(arr1);
        Array.Sort(arr2);
        if(arr1.Length!=arr2.Length){
            return false;
        }
        int i=0;
        int n=arr1.Length;
        while(i<n){
            if(arr1[i]==arr2[i]){
                i++;
            }
            else{
                return false;
            }
        }
        return true;
    }
}