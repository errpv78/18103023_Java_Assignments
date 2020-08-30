// Considering lowercase and uppercase characters of
// same type as acc to unicode occurence ie, A is
// considered to be smaller than a, and will come first.

// However as all capital chars appear earlier than small
// so therefore Z should not be smaller that a, therefore
// when both characters are from lowercase or uppercase abc
// it is treated seperately.

import java.util.Scanner;
public class p1{
    public static void main(String args[]){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter two strings (line-seperated): ");
        String s1, s2;
        s1 = obj.nextLine();
        s2 = obj.nextLine();

        boolean equal = true;
        int n1 = s1.length(),n2 = s2.length(), n;
        if(n1<n2){
            n = n1;
        }
        else{
            n = n2;
        }

        int i = 0;
        while(i<n){

            int one = s1.charAt(i), two = s2.charAt(i);
            // case when both chars from strings are in abc lower or uppercase
            if(((65<=one && one<=90) || (97<=one && one<=120)) && ((65<=two && two<=90) || (97<=two && two<=120))){
                if(one-two==32 || two-one==32 || one==two){
                   i+=1;
                   continue;
                }
                else if(one-two<32 || two-one>32){
                    equal = false;
                    System.out.println("Smaller string: "+s1);
                    System.out.println("Larger string: "+s2);
                    break;
                }
                else{
                equal = false;
                System.out.println("Smaller string: "+s2);
                System.out.println("Larger string: "+s1);
                break;
                }
            }

            else if(one<two){
                equal = false;
                System.out.println("Smaller string: "+s1);
                System.out.println("Larger string: "+s2);
                break;
            }

            else if(two<one){
                equal = false;
                System.out.println("Smaller string: "+s2);
                System.out.println("Larger string: "+s1);
                break;
            }
            i+=1;
        }

        if(equal){
            if(n1>n){
                System.out.println("Smaller string: "+s2);
                System.out.println("Larger string: "+s1);
            }
            else if(n2>n){
                System.out.println("Smaller string: "+s1);
                System.out.println("Larger string: "+s2);
            }
            else{
                System.out.println(s1 +" and "+ s2 +" are equal");
            }
        }

    }
}

