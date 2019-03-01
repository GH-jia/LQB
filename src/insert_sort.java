public class insert_sort {
    public void insertSort(int[] arr){
        int preIndex;
        for (int i=1,len=arr.length;i<len;i++){
            preIndex = i-1;
            int current = arr[i];
            while (preIndex >=0 && arr[preIndex]>arr[i]){
                arr[preIndex+1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex+1] = current;
        }
    }
    public static void main(String[] args){
        int[] arr = {1,2,5,3,4};
        new insert_sort().insertSort(arr);
        for (int i : arr){
            System.out.print(i+" ");
        }


    }
}
