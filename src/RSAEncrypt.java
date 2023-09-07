import java.math.BigInteger;
import java.util.Random;

public class RSAEncrypt {
    // Initialize variables
    private BigInteger p, q, n, e, d;
    int SIZE = 512;

    public RSAEncrypt() {
        // 1. Calculate prime numbers for public and private keys
        this.p = BigInteger.probablePrime(SIZE, new Random());
        this.q = BigInteger.probablePrime(SIZE, new Random());
        // Compute n
        n = p.multiply(q);

        // 2. Calc phi and find a value which works for e: GCD(e, (p-1)(q-1)) = 1
        BigInteger p_subtracted = p.subtract(BigInteger.ONE);
        BigInteger q_subtracted = q.subtract(BigInteger.ONE);
        BigInteger phi = p_subtracted.multiply(q_subtracted);
        e = BigInteger.probablePrime(phi.bitLength(), new Random());
        while (e.gcd(phi).compareTo(BigInteger.ONE) != 0) {
            e = BigInteger.probablePrime(phi.bitLength(), new Random());
        };

        // 3. Calc d
        d = e.modInverse(phi);
    }


    public BigInteger encrypt(BigInteger msg) {
            BigInteger encrypted = msg.modPow(e, n);
        return encrypted;
    }

    public BigInteger decrypt(BigInteger encryptedMsg) {
        BigInteger cipher_msg = encryptedMsg.modPow(d, n);
        return cipher_msg;
    }
}
