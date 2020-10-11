// check if 2 strings are anagrams of each other

import java.util.Scanner;
public class Program4{
    public static void main(String[] args){
        Scanner obj = new Scanner(System.in);
        System.out.print("Enter string 1 (lowercase letters only): ");
        String s1 = obj.nextLine();
        System.out.print("Enter string 2 (lowercase letters only): ");
        String s2 = obj.nextLine();
        int n1 = s1.length(), n2 = s2.length();
        int[] d_s1 = new int[26] , d_s2 = new int[26];

        for(int i=0; i<n1; i++){
            d_s1[s1.charAt(i)-'a']++;
        }
        for(int i=0; i<n2; i++){
            d_s2[s2.charAt(i)-'a']++;
        }
        boolean ans = true;
        for(int i=0;i<26;i++){
            if(d_s1[i]!=d_s2[i]){
                ans = false;
                break;
            }
        }
        if(ans){
            System.out.println("Yes strings are anagrams!");
        }
        else{
            System.out.println("No strings are not anagrams!");
        }
    }
}