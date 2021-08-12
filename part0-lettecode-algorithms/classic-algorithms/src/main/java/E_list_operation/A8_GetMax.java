package E_list_operation;

public class A8_GetMax {

    public static int getMax(int[] arr, int L ,int R){
        if (L == R){
            return arr[L];
        }
        int mid = L + ((R - L) >> 1);
        int leftMax = getMax(arr,L,mid);
        int rightMax = getMax(arr,mid+1,R);
        return Math.max(leftMax,rightMax);
    }


    public static void main(String[] args) {
        int testTimes = 1000000;
        int maxLen = 100;

        while (testTimes-->0) {
            int tempmax=0;
            int tempmin=0;
            int[] arr = new int[maxLen];
            int size = 0;
            while (size < maxLen){
                int value = (int) (Math.random() * 100000);
                if (tempmax<value) tempmax = value;
                if (tempmin>value) tempmin = value;
                arr[size] =value;
                size ++;
            }
            if (testTimes %5000 ==0) {
                System.out.println("insert finished ,Max is :" + tempmax+"Min is :" + tempmin);
            }
            int L = 0;
            int R = arr.length - 1;
            int mymax = getMax(arr, L, R);
            if (tempmax != mymax){
                throw new RuntimeException("Ops");
            }
        }
        System.out.println("finished");



    }

}
