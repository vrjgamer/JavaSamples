package project4;

public class Project4 {

    public static void main(String[] args) {
        int[] array = {3, 1, 2, 2, 1, 2, 3, 3};       
        System.out.println(" "+FindPeak(array, array.length, 0));        
    }

   private static int FindPeak(int [] arr, int top, int bottom){
       if(bottom < top){
        if(arr[top/2] < arr[top/2 - 1]){
            FindPeak(arr, top/2-1, bottom);
        }else if (arr[top/2] < arr[top/2 + 1]) {
            FindPeak(arr, top, bottom/2 +1);
       }else{
            return arr[top/2];
        }
       }
       return -1;
   }
}
