import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

public class Main {
    public static void main(String[] args) throws IOException {
        RSAEncrypt rsa = new RSAEncrypt();

        System.out.println("Enter a message to be encrypted: ");
        String input_text = (new BufferedReader(new InputStreamReader(System.in))).readLine();

        BigInteger ciphertext = rsa.encrypt(new BigInteger(input_text.getBytes()));
        System.out.println("\nEncrypted text: " + ciphertext);

        String text_decrypted = new String(rsa.decrypt(ciphertext).toByteArray());
        System.out.println("Decrypted text: " + text_decrypted);
    }

}