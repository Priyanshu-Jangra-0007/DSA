public class VaultDigitAlignment {
    public static void main(String[] args){
        int n = 4;
        // int[] A = {1,3,2,1,1};
        int[] A = {9,0,1,2};
        int rotate = 0;
        for(int i=1; i<n; i++){
            if(A[i-1] > A[i]){
                rotate += (A[i-1] - A[i] + 10) % 10;
                A[i] = A[i-1];
            }
        }
        System.out.println(rotate);
    }
}