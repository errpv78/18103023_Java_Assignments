import java.util.Scanner;
public class p6{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = obj.nextInt();

        System.out.println("Hailstone sequence: " + n);
        int c = 0;
        while(n!=1 && c<Integer.MAX_VALUE && n<Integer.MAX_VALUE && n>0){
            if(n%2!=0){
                n*=3;
                n++;
            }
            else{
                n/=2;
            }
            System.out.println(n);
            c++;
        }
        if(n==1){
            System.out.println("No of steps: "+c);
        }
        else if(n==Integer.MAX_VALUE || n<0){
            System.out.println("Integer overflow reached");
        }
        else{
            System.out.println("No of steps maxed out.");
        }
    }
}