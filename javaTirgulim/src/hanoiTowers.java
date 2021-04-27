public class hanoiTowers {
    static void towerOfHanoi (int n,String rodStart,String rodEnd,String rodMiddle){
        if(n==1)
        {
            System.out.println("Move disk 1 from rod " + " " + rodStart +" " + "to rod" + " " + rodEnd);
        return;
        }
        towerOfHanoi(n-1,rodStart,rodMiddle,rodEnd);
        System.out.println("move disk "  + n + " " + "from rod " + " " + rodStart + " " + "to rod " + " " + rodEnd);
        towerOfHanoi(n-1,rodMiddle,rodEnd,rodStart);


    }
    public static void main(String[]args){
        int n = 20;
        towerOfHanoi(n,"Start","End","Middle");
    }
}
