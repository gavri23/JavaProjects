public class world {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0)
            return "";
        String prefix = strs[0];
        for(int i = 1;i < strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        System.out.println(prefix);
        return prefix;

    }
    public static void OneFiveSeven(int n){
        int counter = 0;
        counter = OneFiveSeven(n,counter);
        System.out.println(counter);
    }

    private static int OneFiveSeven(int n, int counter) {
        if (n == 0)
            return counter;
        int countSeven = n - 7 >= 0 ? OneFiveSeven(n - 7, counter + 1) : Integer.MAX_VALUE;
        int countFive = n - 5 >= 0 ? OneFiveSeven(n - 5, counter + 1) : Integer.MAX_VALUE;
        int countOne = n - 1 >= 0 ? OneFiveSeven(n - 1, counter + 1) : Integer.MAX_VALUE;
        return Math.min(countSeven,Math.min(countFive,countOne));
    }

    public static void main(String args[]){
        OneFiveSeven(70);
    }
}
