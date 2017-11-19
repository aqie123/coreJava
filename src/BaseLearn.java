public class BaseLearn {
    // 声明int数组变量

    // 创建大小为7数组,并赋值
    void learn(){

        char[] helloArray = {'h','e','l','l','o'};
        // string类实例化
        String helloString = new String(helloArray);
        System.out.println(helloString);
        int[] nums = new int[] {1,2,3,4,5};
        for(int i = 0;i<nums.length;i++){
            System.out.println(nums[i] + " ");
        }

        // foreach
        double[] myList = {5,4,3,2,1};
        for(double emelent:myList){
            System.out.println(emelent);
        }

        // 多维数组
        String str[][] = new String[2][3];
        str[0][0] = "Good";
        str[0][1] = "luck";
        str[1][0] = "to";
        str[1][1] = "you";
        str[1][2] = "!";
        System.out.println(str.length);
        System.out.println(str[0].length);
        // 00 01 02  10 11 12
        for (int x=0; x<str.length;x++){
            for(int y = 0;y<str[x].length;y++){
                System.out.println(str[x][y]);
            }
        }
    }

}
