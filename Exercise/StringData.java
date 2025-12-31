/*
* Crea un programa que analice dos palabras diferentes y realice comprobaciones
 * para descubrir si son:
 * - Palíndromos
 * - Anagramas
 * - Isogramas

 Program that accepts two words
 if palidromo
 if anagramas
 if isagramas

*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class StringData {


    public void polindromoFor (String strNew) {
        String strReverse = "";

        for (int i = strNew.length() - 1 ; i >= 0; i--) {
            strReverse = strReverse +  strNew.charAt(i);
        }

        if(strNew.equals(strReverse)){
            System.out.println(strNew  + " is palindrome");
        } else {
            System.out.println(strNew + " not is palindrome");
        }
        
    }

    public void palindromoStringBuilder (String strNew){
 
        String strReverse = new StringBuilder(strNew).reverse().toString();

        if (strReverse.equals(strNew)) {
             System.out.println(strNew  + " Is palindrome");
        } else {
            System.out.println(strNew + " Not is palindrome");
        };


    }
    
    public void checkAnagram(String str1, String str2) {
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        str2 = str2.replaceAll("\\s+", "").toLowerCase();

        if (str1.length() != str2.length()) {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
            return;
        }

        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) {
            System.out.println(str1 + " and " + str2 + " are anagrams.");
        } else {
            System.out.println(str1 + " and " + str2 + " are not anagrams.");
        }
    }


    public void checkIsogram(String str1) {
        str1 = str1.replaceAll("\\s+", "").toLowerCase();
        HashSet<Character> lettersSeen = new HashSet<>();

        for (char c : str1.toCharArray()) {
            if (lettersSeen.contains(c)) {

                System.out.println(str1 + " is not an isogram.");
                return;
            }
            lettersSeen.add(c);
        }

        System.out.println(str1 + " is an isogram.");
    }


    public void program (){
        Scanner sc = new Scanner(System.in);
        StringData stringData = new StringData();

        System.out.println("Ingres 2 String");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println("\nOptions: \n" + 
                "1 - Palindromes\n" +
                "2 - Anagram\n" +
                "3 - Ideogram\n" );
        int option = sc.nextInt();
        sc.nextLine(); 
        
        switch (option) {
            case 1:
                stringData.polindromoFor(str1);
                stringData.palindromoStringBuilder(str2);
                break;
            case 2:
                stringData.checkAnagram(str1, str2);
                break;
            case 3:
                stringData.checkIsogram(str1);
                stringData.checkIsogram(str2);
                break;
        }
        sc.close();

    }

    public static void main(String[] args) {
        StringData sData = new StringData();
        sData.program();
    }
}
