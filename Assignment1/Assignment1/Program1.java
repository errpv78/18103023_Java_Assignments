// WAP to find no of times a substring exists in given
// string if order of characters in substring is irrelevant.

import java.util.Scanner;

public class Program1{
    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);
        System.out.print("Enter string(lowercase letters only): ");
        String s = obj.nextLine();
        System.out.print("Enter substring(lowercase letters only): ");
        String sub = obj.nextLine();
        int n = s.length(), n1 = sub.length();


        if(n<n1){
            System.out.print(0);  // If substring is greater in length than original then it can't be present.
            return;
        }

        int[] d_s = new int[26] , d_sub = new int[26];   // dictionary for maintaining frequencies of chars in strings
        for(int i=0; i<n1; i++){
            d_sub[sub.charAt(i)-'a']++;
        }
        for(int i=0; i<n1; i++){
            d_s[s.charAt(i)-'a']++;
        }

        int fal = 0;  // no of distinct chars that do not have equal frequency in both strings
        int ans = 0;
        for(int i=0;i<26;i++){
            if(d_sub[i]!=d_s[i]){
                fal++;
            }
        }
        if(fal==0){
            ans++;
        }
        int ind = 0;

        for(int i=n1;i<n;i++){
            ind = s.charAt(i-n1)-'a';
            if(d_sub[ind]==d_s[ind]){
                fal++;
            }
            else if((d_sub[ind]+1)==d_s[ind]){
                fal--;
            }
            d_s[ind]--;
            ind = s.charAt(i)-'a';
            if(d_sub[ind]==d_s[ind]){
                fal++;
            }
            else if(d_sub[ind]-1==d_s[ind]){
                fal--;
            }
            d_s[ind]++;
            if(fal==0){
                ans++;
            }
        }
        System.out.print("Answer: ");
        System.out.print(ans);

    }

}