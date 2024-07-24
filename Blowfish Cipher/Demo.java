import java.util.*;
import java.io.*;
public class Demo
{
    // instance variables - replace the example below with your own
    
    private Scanner scan;

    /**
     * Constructor for objects of class Demo
     */
    public Demo() throws javax.crypto.IllegalBlockSizeException,javax.crypto.BadPaddingException,java.security.InvalidKeyException,java.security.NoSuchAlgorithmException,javax.crypto.NoSuchPaddingException,FileNotFoundException 
    {
        BlowFishCipher b = new BlowFishCipher();
        ArrayList<String> passwords = new ArrayList<String>();
        scan = new Scanner(new File("passwords.txt"));
        while (scan.hasNextLine()){
            passwords.add(scan.nextLine());
        }
        for (int i = 0; i<passwords.size() ; i++){
            System.out.println("Original Password: " + passwords.get(i));
            System.out.println("Encrypted Password: " + b.encrypt(passwords.get(i)));
            System.out.println("Decrypted Password: " + b.decrypt(b.encrypt(passwords.get(i))));
            System.out.println("   ");
        }

    }

    public static void main(String[] args) throws javax.crypto.IllegalBlockSizeException,javax.crypto.BadPaddingException,java.security.InvalidKeyException,java.security.NoSuchAlgorithmException,javax.crypto.NoSuchPaddingException,FileNotFoundException 
    {
        Demo d = new Demo();
    }
    
}

