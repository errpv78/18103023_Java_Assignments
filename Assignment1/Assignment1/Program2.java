// Read a para and replace specific words in given
// format

import java.util.Scanner;

public class Program2{
    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);
        System.out.print("Enter paragraph(only lower and upper case letters): ");
        String para = obj.nextLine();
        String[] para_words = para.split("\\s+");

        System.out.print("Enter number of words: ");
        int n = obj.nextInt();
        String [] words = new String[n];

        System.out.print("Enter words (line separated): ");
        Scanner obj1 = new Scanner(System.in);
        for(int i=0; i<n; i++){
            words[i] = obj1.nextLine();
        }

        for(int i=0; i<para_words.length; i++){
            for(int j=0; j<n; j++){
                if(para_words[i].equals(words[j])){
                    int temp = para_words[i].length();
                    String temp1;
                     temp1 = String.valueOf(para_words[i].charAt(0));
                    for(int k=0; k<temp-1; k++){
                        temp1 += '*';
                    }
                    para_words[i] = temp1;
                }
            }
        }

        System.out.println("Modified paragraph: ");
        for(int i=0; i<para_words.length; i++){
            System.out.print(para_words[i]);
            System.out.print(" ");
        }
    }
}