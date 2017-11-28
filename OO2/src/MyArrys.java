public class MyArrys {
    public static String toString(int[] arr){
        String result = "";
        for(int i = 0;i<arr.length;i++){
            if(i ==0){
                result += "[" +arr[i]+",";
            }else if(i == arr.length-1){
                result += arr[i]+"]";
            }else{
                result += arr[i]+",";
            }
        }
        return result;
    }

    public static  void sort(int[] arr){
        // 冒泡
        for(int i = 0;i<arr.length-1;i++){
            for(int j = 0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr = {11,3,4,9,7,5};
        System.out.println(MyArrys.toString(arr));
        MyArrys.sort(arr);
        System.out.println(MyArrys.toString(arr));
    }
}
