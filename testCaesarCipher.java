
/**
 * Write a description of testCaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.FileResource;

public class testCaesarCipher {
    
    public int[] countLetters(String input) {
        //FileResource resource = new FileResource();
        //String input = resource.asString();
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
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String input = fr.asString();
        System.out.println("input is " + input);
        CaesarCipher cc = new CaesarCipher(18);
        String encrypted = cc.encrypt(input);
        System.out.println("encrypted is " + encrypted);
        String decrypted = cc.decrypt(encrypted);
        System.out.println("decrypted is " + decrypted);
        String broke = breakCaesarCipher(encrypted);
        System.out.println("decrypted auto is " + broke);
    }
    
    public String breakCaesarCipher(String input) {
        int[] frequencies = countLetters(input);
        int maxDex = maxIndex(frequencies);
        int dkey = maxDex - 4;
        if (maxDex < 4) {
            dkey = 26 - (4 - maxDex);
        }
        CaesarCipher cc = new CaesarCipher(dkey);
        return cc.decrypt(input);
    }
    
}
