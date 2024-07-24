import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * BlowFishCipher class that encrypts and decrypts using Blowfish algorithm
 * Algorithm from a collection of ciphers
*/
public class BlowFishCipher {
    private static final String TRANSFORMATION = "Blowfish/ECB/PKCS5Padding";

    private SecretKey secretKey;

    /**
     * constructor that generates a secret key
     * @throws NoSuchAlgorithmException
     */
    public BlowFishCipher() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        secretKey = keyGenerator.generateKey();
    }

    /**
     * encrypt a string using the secret key
     * @param String - input
     * @return String - encrypted text
     * @throws exceptions
     */
    public String encrypt(String input) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);     
        byte[] reverseInput = new byte[inputBytes.length];
        int j = inputBytes.length;
        for (int i = 0; i < inputBytes.length; i++) {
            reverseInput[j - 1] = inputBytes[i];
            j = j - 1;
        }

        byte[] encryptedBytes = cipher.doFinal(reverseInput);
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    /**
     * decrypt a string using the secret key
     * @param String - input
     * @return String - decrypted text
     * @throws exceptions
     */
    public String decrypt(String encryptedInput) throws NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
     
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedInput);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        byte[] unreverseInput = new byte[decryptedBytes.length];
        int j = decryptedBytes.length;
        for (int i = 0; i < decryptedBytes.length; i++) {
            unreverseInput[j - 1] = decryptedBytes[i];
            j = j - 1;
        }
        return new String(unreverseInput, StandardCharsets.UTF_8);
    }
    

}

    

