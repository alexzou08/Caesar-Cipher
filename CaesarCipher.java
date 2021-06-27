
/*
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class CaesarCipher {
    
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key)+alphabet.substring(0,key);
        mainKey = key;
    }
    
    public String encrypt(String input) {
        StringBuilder encrypted = new StringBuilder(input);
        //for upper cases
        for(int k = 0; k < input.length(); k++) {
            char currChar = input.charAt(k);
            int idx = alphabet.indexOf(currChar);
            if(idx != -1) {
                char newChar = shiftedAlphabet.charAt(idx);
                encrypted.setCharAt(k, newChar);
            }
        }
        //for lower cases
        for(int k = 0; k < input.length(); k++) {
            char currChar = input.charAt(k);
            int idx = alphabet.toLowerCase().indexOf(currChar);
            if(idx != -1) {
                char newChar = shiftedAlphabet.toLowerCase().charAt(idx);
                encrypted.setCharAt(k, newChar);
            }
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }
    
}
