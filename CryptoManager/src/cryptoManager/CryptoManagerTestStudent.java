package cryptoManager;
/*

 * Class: CMSC203 

 * Instructor:

 * Description: The Caesar Cipher is the first method, and it is an example of a straightforward substitution cipher. 
 * This type of encryption simply substitutes characters in a message with a different character. 
 * The Bellaso Cipher is the second method, and it employs the usage of a key word to determine the offset for each letter in the message that is being encrypted.

 * Due: 03/24/2023

 * Platform/compiler:

 * I pledge that I have completed the programming

 * assignment independently. I have not copied the code

 * from a student or any source. I have not given my code

 * to any student.

   Print your Name here: _romaric nkola_________

*/
import java.util.ArrayList;
import java.util.List;

public class CryptoManagerTestStudent {

//The Caesar Cipher
public static String shiftAlphabet(int shift) {
       int start = 0;
       if (shift < 0) {
           start = (int) 'Z' + shift + 1;
       } else {
           start = 'A' + shift;
       }
       String result = "";
       char currChar = (char) start;
       for(; currChar <= 'Z'; ++currChar) {
           result = result + currChar;
       }
       if(result.length() < 26) {
           for(currChar = 'A'; result.length() < 26; ++currChar) {
               result = result + currChar;
           }
       }
       return result;
   }

public static String encryptCaesar(String message, int shift) {
       String shiftedAlphabet = shiftAlphabet(shift);
       String encryptedMessage = "";
       for(int i = 0; i < message.length(); i++) {
           int charIndex = message.charAt(i) - 'A';
           if(charIndex >= 0 && charIndex <= 25) {
               encryptedMessage += shiftedAlphabet.charAt(charIndex);
           } else {
               encryptedMessage += message.charAt(i);
           }
       }
       return encryptedMessage;
   }

public static String decryptCaesar(String message, int shift) {
       String shiftedAlphabet = shiftAlphabet(shift);
       String decryptedMessage = "";
       for(int i = 0; i < message.length(); i++) {
           int charIndex = shiftedAlphabet.indexOf(message.charAt(i));
           if(charIndex >= 0 && charIndex <= 25) {
               decryptedMessage += (char)(charIndex + 'A');
           } else {
               decryptedMessage += message.charAt(i);
           }
       }
       return decryptedMessage;
   }

//The Bellaso Cipher
public static String encryptBellaso(String message, String key) {
       String encryptedMessage = "";
       int keyIndex = 0;
       for(int i = 0; i < message.length(); i++) {
           int messageCharIndex = message.charAt(i) - 'A';
           int keyCharIndex = 0;
           if(keyIndex < key.length()) {
               keyCharIndex = key.charAt(keyIndex) - 'A';
           } else {
               keyCharIndex = key.charAt(keyIndex % key.length()) - 'A';
           }
           int encryptedCharIndex = (messageCharIndex + keyCharIndex) % 26;
           encryptedMessage += (char)(encryptedCharIndex + 'A');
           keyIndex++;
       }
       return encryptedMessage;
   }

public static String decryptBellaso(String message, String key) {
       String decryptedMessage = "";
       int keyIndex = 0;
       for(int i = 0; i < message.length(); i++) {
           int messageCharIndex = message.charAt(i) - 'A';
           int keyCharIndex = 0;
           if(keyIndex < key.length()) {
               keyCharIndex = key.charAt(keyIndex) - 'A';
           } else {
               keyCharIndex = key.charAt(keyIndex % key.length()) - 'A';
           }
           int decryptedCharIndex = (messageCharIndex - keyCharIndex) % 26;
           if(decryptedCharIndex < 0) {
               decryptedCharIndex += 26;
           }
           decryptedMessage += (char)(decryptedCharIndex + 'A');
           keyIndex++;
       }
       return decryptedMessage;
   }

public static void main(String[] args) {
 String message = "ABCDEFG";
 int shift = 10;
 String key = "CMSC";
       String encryptedCaesar = encryptCaesar(message, shift);
       System.out.println("Encrypted (Caesar): " + encryptedCaesar);
       String decryptedCaesar = decryptCaesar(encryptedCaesar, shift);
       System.out.println("Decrypted (Caesar): " + decryptedCaesar);
       String encryptedBellaso = encryptBellaso(message, key);
       System.out.println("Encrypted (Bellaso): " + encryptedBellaso);
       String decryptedBellaso = decryptBellaso(encryptedBellaso, key);
       System.out.println("Decrypted (Bellaso): " + decryptedBellaso);
   }
}