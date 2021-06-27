
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class TestCaesarCipherTwo {
    
    public int[] countLetters(String input) {
        StringBuilder message = new StringBuilder(input);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int k=0; k < message.length(); k++) {
            char ch = Character.toLowerCase(message.charAt(k));
            int index = alphabet.indexOf(ch);
            if(index != -1) {
                counts[index] += 1;
            }
        }
        return counts;
    }
    
    public int maxIndex(int[] values) {
        int maxDex = 0;
        for(int k=0; k < values.length; k++) {
            if(values[k] > values[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public int getKey(String s) {
        int[] counts = countLetters(s);
        return maxIndex(counts);
    }    
    
    public String halfOfString(String message, int start) {
        // start = 0, halfstring starting with first character
        // start = 1, halfstring starting with second character
        StringBuilder result = new StringBuilder();
        for (int k = start; k < message.length(); k += 2) {
            char ch = message.charAt(k);
            result.append(ch);
        }
        return result.toString();
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String input = fr.asString();
        System.out.println("input is " + input);
        CaesarCipherTwo cct = new CaesarCipherTwo(17,3);
        String encrypted = cct.encrypt(input);
        System.out.println("encrypted is " + encrypted);
        String decrypted = cct.decrypt(encrypted);
        System.out.println("decrypted is " + decrypted);
        String decryptedAuto = breakCaesarCipher(encrypted);
        System.out.println("decrypted auto is " + decrypted);
    }
    
    public String breakCaesarCipher(String input) {
        String input1 = halfOfString(input,0);
        String input2 = halfOfString(input,1);
        StringBuilder decryptedSB = new StringBuilder();
        // deal with first half
        int[] frequencies1 = countLetters(input1);
        int maxDex1 = maxIndex(frequencies1);
        int dkey1 = maxDex1 - 4;
        if (maxDex1 < 4) {
            dkey1 = 26 - (4 - maxDex1);
        }
        // deal with second half
        int[] frequencies2 = countLetters(input2);
        int maxDex2 = maxIndex(frequencies2);
        int dkey2 = maxDex2 - 4;
        if (maxDex2 < 4) {
            dkey2 = 26 - (4 - maxDex2);
        }
        // create a CaesarCipherTwo object with dkey1 and dkey2
        CaesarCipherTwo cct = new CaesarCipherTwo(dkey1,dkey2);
        return cct.decrypt(input);
    }
    
}
