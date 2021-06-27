
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class CaesarCipherTwo {
    
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    private int mainKey1;
    private int mainKey2;
    public CaesarCipherTwo(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1)+alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2)+alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        // for upper cases string1
        for(int k = 0; k < input.length(); k+=2) {
            char currChar = input.charAt(k);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1) {
                char newChar = shiftedAlphabet1.charAt(idx);
                encrypted.setCharAt(k, newChar);
            }
        }
        //for lower cases string1
        for(int k = 0; k < input.length(); k+=2) {
            char currChar = input.charAt(k);
            int idx = alphabet.toLowerCase().indexOf(currChar);
            if(idx != -1) {
                char newChar = shiftedAlphabet1.toLowerCase().charAt(idx);
                encrypted.setCharAt(k, newChar);
            }
        }
        // for upper cases string2
        for(int k = 1; k < input.length(); k+=2) {
            char currChar = input.charAt(k);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1) {
                char newChar = shiftedAlphabet2.charAt(idx);
                encrypted.setCharAt(k, newChar);
            }
        }
        // for lower cases string2
        for(int k = 1; k < input.length(); k+=2) {
            char currChar = input.charAt(k);
            int idx = alphabet.toLowerCase().indexOf(currChar);
            if(idx != -1) {
                char newChar = shiftedAlphabet2.toLowerCase().charAt(idx);
                encrypted.setCharAt(k, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipherTwo cct = new CaesarCipherTwo(26 - mainKey1, 26 - mainKey2);
        return cct.encrypt(input);
    }
}
