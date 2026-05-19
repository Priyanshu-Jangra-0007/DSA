public class ZerosOnes {
    public static int findSubarray(int[] A){
        int i=0; 
        int j=1;
        int maxLen = 1;
        int trans = 0;
        while (j < A.length) {
            if(A[j] != A[j-1]){
                trans++;
            }
            if(trans <= 1){
                maxLen = Math.max(maxLen, j-i+1);
            }else{
                i = j;
                trans = 0;
            }
            j++;
        }

        return maxLen;
    }
    public static void main(String[] args) {
        int[] A = {0,0,0};
        int m = 2;
        int[] B = {1,2};
        int prod = 1;

        for(int i=0; i<m; i++){
            A[B[i]-1] = A[B[i]-1] == 0 ? 1 : 0;
            prod *= findSubarray(A);
        }

        System.out.println(prod);
    }
}