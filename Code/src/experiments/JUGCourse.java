package experiments;

import java.util.HashMap;
import java.util.Map;

public class JUGCourse {

    public static void main(String[] args) {
        binary(4);
    }

    static void binary(int num){
        StringBuilder result = new StringBuilder();
        int current = num;
        while(current >= 1){
            int temp = current % 2;
            current = current/2;
            result.insert(0,temp);
        }
        System.out.println(result);
    }

    static void isAnagram(String first, String second){

        long firstProduct = product(first);
        long secondProduct = product(second);

        if(firstProduct == secondProduct){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

    }
    static long product(String str){
        long result = 1;
        char[] letters = new char[28];
        letters[0] = '$';
        letters[1] = '#';
        char currentChar = 'a';
        int[] primes = new int[letters.length];
        primes[0] = 2;
        int counter = 1;
        int currentNumber = 3;
        while (counter < primes.length) {
            if (isPrime(currentNumber)) {
                primes[counter++] = currentNumber;
            }
            currentNumber++;
        }
        for (int i = 2; i < letters.length; i++) {
            letters[i] = currentChar++;
        }
        for (int i = 0; i < str.length(); i++) {
            char character = str.charAt(i);
            for (int j = 0; j < letters.length; j++) {
                if(letters[j]==character){
                    result *= primes[j];
                }
            }
        }
        return result;
    }
    static void isAnagram1(String first, String second){
        Map<Character,Integer> letterMapPrime = generateMap();
        long firstProduct = 1;
        long secondProduct = 1;
        for (int i = 0; i < first.length(); i++) {
            firstProduct *= letterMapPrime.get(first.charAt(i));
        }
        for (int i = 0; i < second.length(); i++) {
            secondProduct *= letterMapPrime.get(second.charAt(i));
        }
        if(firstProduct == secondProduct){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }

    static Map<Character,Integer> generateMap() {
        Map<Character, Integer> letterToPrime = new HashMap<>();
        char currentChar = 'a';
        int[] primes = generatePrimeSet();
        for (int i = 0; i < 26; i++) {
            letterToPrime.put(currentChar++, primes[i]);
        }
        return letterToPrime;
    }

    static void generateAlphabet() {
        char[] alphabet = new char[26];
        char currentChar = 'a';
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = currentChar++;
        }
        for (int i = 0; i < alphabet.length; i++) {
            System.out.println(alphabet[i]);
        }
    }

    static int[] generatePrimeSet() {
        int[] primes = new int[26];
        primes[0] = 2;
        int counter = 1;
        int currentNumber = 3;
        while (counter < primes.length) {
            if (isPrime(currentNumber)) {
                primes[counter++] = currentNumber;
            }
            currentNumber++;
        }
        return primes;

    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void isPowerOf2(int num) {
        while (num != 1) {
            if (num % 2 != 0) {
                System.out.println("false");
                return;
            }
            num = num / 2;
        }
        System.out.println("true");

    }

    static void isPalindrome(String test) {
        StringBuilder result = new StringBuilder();
        char[] chars = test.toCharArray();

        for (int index = test.length() - 1; index >= 0; index--) {
            System.out.println(chars[index]);
            if (chars[index] != ' ') {

                result.append(chars[index]);
            }

        }
        String reverse = result.toString();
        String noSpaces = test.replaceAll(" ", "");
        if (reverse.equals(noSpaces)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }


}
