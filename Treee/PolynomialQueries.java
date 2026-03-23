import java.io.BufferedWriter;
import java.io.IOException;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
class PolynomialQueries{
    static int n;
    static long[] tree;
    static long[] lazy1;
    static long[] lazy2;
    public static void main(String[] args) throws IOException{
        FastScanner sc=new FastScanner(System.in);
        n=sc.nextInt();
        int q=sc.nextInt();
        long[] arr=new long[n];
        lazy1=new long[4*n];
        lazy2=new long[4*n];
        tree=new long[4*n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLong();
        }
        build(0,0,n-1,arr);
        StringBuilder sb=new StringBuilder();
        while(q-- > 0){
            int type=sc.nextInt();
            int left=sc.nextInt();
            int right=sc.nextInt();
            if(type==1){
                update(0, 0, n-1, left-1, right-1);
            }else{
                long ans=query(0,0,n-1, left-1, right-1);
                sb.append(ans).append("\n");
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        pw.print(sb);
        pw.flush();    
    }
    public static void build(int node,int leftR,int rightR,long[] arr){
        if(leftR==rightR){
            tree[node]=arr[leftR];
            return;
        }
        int mid=leftR+((rightR-leftR)>>1);
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        build(leftChild, leftR, mid, arr);
        build(rightChild, mid+1, rightR, arr);
        tree[node]=tree[leftChild]+tree[rightChild];
    }
    public static long query(int node,int leftR,int rightR,int querySt,int queryEnd){
        if(leftR>queryEnd || rightR<querySt){
            return 0;
        }
        if(leftR>=querySt && rightR<=queryEnd){
            return tree[node];
        }
        push(node,leftR,rightR);
        int mid=leftR+((rightR-leftR)>>1);
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        long left=query(leftChild, leftR, mid, querySt, queryEnd);
        long right=query(rightChild, mid+1, rightR, querySt, queryEnd);
        return left+right;
    }
    public static void update(int node,int leftR,int rightR,int querySt,int queryEnd){
        if(leftR>queryEnd || rightR<querySt){
            return;
        }
        if(leftR>=querySt && rightR<=queryEnd){
            long a=leftR-querySt+1;
            tree[node]+=Sum((rightR-leftR+1),a,1);
            lazy1[node]+=a;
            lazy2[node]+=1;
            return;
        }
        push(node, leftR, rightR);
        int mid=leftR+((rightR-leftR)>>1);
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        update(leftChild, leftR, mid, querySt, queryEnd);
        update(rightChild, mid+1, rightR, querySt, queryEnd);
        tree[node]=tree[leftChild]+tree[rightChild];
    }
    public static long Sum(long n,long a,long d){
        return (n*((2*a)+(n-1)*d))/2;
    }
    public static void push(int node,int leftR,int rightR){
        if(lazy1[node]==0 && lazy2[node]==0) return;
        int mid=leftR+((rightR-leftR)>>1);
        int leftLength=mid-leftR+1;
        int leftChild=2*node+1;
        int rightChild=2*node+2;
        // left child
        tree[leftChild]+=Sum(leftLength, lazy1[node], lazy2[node]);
        lazy1[leftChild]+=lazy1[node];
        lazy2[leftChild]+=lazy2[node];
        //  right Child
        long newA= lazy1[node]+leftLength*lazy2[node];
        tree[rightChild]+=Sum(rightR-mid, newA, lazy2[node]);
        lazy1[rightChild]+=newA;
        lazy2[rightChild]+=lazy2[node];

        lazy1[node]=0;
        lazy2[node]=0;
    }
    static class FastScanner {
        private static final int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        FastScanner(InputStream is) {
            din = new DataInputStream(is);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                bytesRead = din.read(buffer, 0, BUFFER_SIZE);
                bufferPointer = 0;
            }
            return buffer[bufferPointer++];
        }

        int nextInt() throws IOException {
            int ret = 0;
            byte b = read();
            while (b <= ' ') b = read();
            boolean neg = (b == '-');
            if (neg) b = read();
            while (b >= '0' && b <= '9') {
                ret = ret * 10 + (b - '0');
                b = read();
            }
            return neg ? -ret : ret;
        }

        long nextLong() throws IOException {
            long ret = 0;
            byte b = read();
            while (b <= ' ') b = read();
            boolean neg = (b == '-');
            if (neg) b = read();
            while (b >= '0' && b <= '9') {
                ret = ret * 10 + (b - '0');
                b = read();
            }
            return neg ? -ret : ret;
        }
    }
}