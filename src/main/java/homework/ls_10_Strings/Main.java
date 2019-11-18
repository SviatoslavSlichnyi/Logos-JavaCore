package homework.ls_10_Strings;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("word: ");
        String word = in.next();
        in.nextLine();

        System.out.println("Is word palindrome? " + StringTools.isPalindrome(word));
        System.out.println("Without loud: " + StringTools.replaceLoud(word));


        System.out.println();
        System.out.print("text: ");
        String text = in.nextLine();
        System.out.println();

        String[] words = text.split(" ");
        String[] sentences = text.split("\\. ");

        System.out.println("amount of words: " + words.length);
        System.out.println("amount of sentences: " + sentences.length);


        String popular;

        //The most popular word in text;
        popular = TextTools.findPopular(text);
        System.out.println("The most popular word is " + popular);

        for(int i = 0; i < sentences.length; ++i) {

            popular = TextTools.findPopular(sentences[i]);
            System.out.println("Popular word in "+(i+1)+" sentence: " + popular);

        }


    }



}
