/**
 * 
 */
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
/**
 * @author nkola
 *
 */
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
 	 * @param plainText a string to be encrypted 
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		for(int i = 0; i < plainText.length(); i++){
			if(plainText.charAt(i) < LOWER_BOUND || plainText.charAt(i) > UPPER_BOUND){
				// if any character is outside the bounds return false
				return false;
			}
		}
		// all characters are within the allowable bounds, return true
		return true;
	}

	/**
	 * This method encrypts a string according to the Caesar Cipher. 
	 * @param plainText an uppercase string to be encrypted.
	 * @param shift an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncrypt (String plainText, int shift) {
		StringBuilder encryptedText = new StringBuilder();
		int plainTextCharCode, encryptedTextCharCode;
		
		for(int i = 0; i < plainText.length(); i++) { 
			plainTextCharCode = plainText.charAt(i) + shift;
			encryptedTextCharCode = plainTextCharCode;
			
			// wrap around if shift is greater than the range of characters 
			if(plainTextCharCode > UPPER_BOUND) {
				encryptedTextCharCode -= RANGE;
			}
			// add encrypted character to encryptedText
			encryptedText.append((char) encryptedTextCharCode);
		}
		
		return encryptedText.toString();
	}
	
	/**
	 * This method decrypts a string according to the Caesar Cipher.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param shift an integer that specifies the offset of each character
	 * @return the decrypted string
	 */
	public static String caesarDecrypt (String encryptedText, int shift) {
		StringBuilder decryptedText = new StringBuilder();
		int encryptedTextCharCode, decryptedTextCharCode;
		
		for(int i = 0; i < encryptedText.length(); i++) {
			encryptedTextCharCode = encryptedText.charAt(i) - shift;
			decryptedTextCharCode = encryptedTextCharCode;
			
			// wrap around if shift is greater than the range of characters 
			if(encryptedTextCharCode < LOWER_BOUND) {
				decryptedTextCharCode += RANGE;
			}
			// add decrypted character to decryptedText
			decryptedText.append((char) decryptedTextCharCode);
		}
		
		return decryptedText.toString();
	}
	
	/**
	 * This method encrypts a string according to the Bellaso Cipher. 
	 * @param plainText a string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String bellasoEncrypt(String plainText, String bellasoStr) {
		StringBuilder encryptedText = new StringBuilder();
		int plainTextCharCode, bellasoCharCode, encryptedTextCharCode;
		
		for(int i = 0; i < plainText.length(); i++) {
			plainTextCharCode = plainText.charAt(i);
			bellasoCharCode = bellasoStr.charAt(i % bellasoStr.length());
			encryptedTextCharCode = plainTextCharCode + bellasoCharCode;
			
			// wrap around if shift is greater than the range of characters 
			if(encryptedTextCharCode > UPPER_BOUND) {
				encryptedTextCharCode -= RANGE;
			}
			// add encrypted character to encryptedText
			encryptedText.append((char) encryptedTextCharCode);
		}
		
		return encryptedText.toString();
	}
	
	/**
	 * This method decrypts a string according to the Bellaso Cipher.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offset of each character
	 * @return the decrypted string
	 */
	public static String bellasoDecrypt(String encryptedText, String bellasoStr) {
		StringBuilder decryptedText = new StringBuilder();
		int encryptedTextCharCode, bellasoCharCode, decryptedTextCharCode;
		
		for(int i = 0; i < encryptedText.length(); i++) {
			encryptedTextCharCode = encryptedText.charAt(i);
			bellasoCharCode = bellasoStr.charAt(i % bellasoStr.length());
			decryptedTextCharCode = encryptedTextCharCode - bellasoCharCode;
			
			// wrap around if shift is greater than the range of characters 
			if(decryptedTextCharCode < LOWER_BOUND) {
				decryptedTextCharCode += RANGE;
			}
			// add decrypted character to decryptedText
			decryptedText.append((char) decryptedTextCharCode);
		}
		
		return decryptedText.toString();
	}

}