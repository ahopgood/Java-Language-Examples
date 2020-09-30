package crypto;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.ChaCha20ParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.InvalidParameterException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChaCha20Test {

    private static final String CHACHA20_ALG = "ChaCha20";
    private static final String PLAINTEXT = "Hi Morty I'm some plaintext, I'm plaintext Rick!";

    private final Cipher encryptCipher = Cipher.getInstance(CHACHA20_ALG);
    private final Cipher decryptCipher = Cipher.getInstance(CHACHA20_ALG);

    private final byte[] nonce = new byte[12];
    private final int counter = 900;

    private KeyGenerator keyGenerator = KeyGenerator.getInstance(CHACHA20_ALG);
    private SecretKey key = keyGenerator.generateKey();


    public ChaCha20Test() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }
    // ChaCha20 requires
    // 256-bit secret key (32 bytes)
    // 96-bit nonce (12 bytes)
    // 32-bit initial count (4 bytes)

    @Test
    public void testChaCha20_givenNullNonce_throwsException() {
        assertThrows(NullPointerException.class,
                () -> new ChaCha20ParameterSpec(null, counter));
    }

    @Test
    public void testChaCha20_givenNonceGreaterThan96bit_throwsException() throws InvalidAlgorithmParameterException, InvalidKeyException {
        byte[] nonce = new byte[16];
        assertThrows(IllegalArgumentException.class,
                () -> new ChaCha20ParameterSpec(nonce, counter));
    }

    @Test
    public void testChaCha20_givenKeySizeGreaterThan256bit_throwsException() {
        byte[] largeKey = new byte[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36};
        ChaCha20ParameterSpec parameterSpec = new ChaCha20ParameterSpec(nonce, counter);
        SecretKeySpec keySpec = new SecretKeySpec(largeKey, CHACHA20_ALG);

        assertThrows(InvalidKeyException.class,
                () -> encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec, parameterSpec));
    }
    @Test
    public void testKeyGenerator_givenKeySizeGreaterThan256bit_throwsException() {
        assertThrows(InvalidParameterException.class,
                () -> keyGenerator.init(512));
    }

        @Test
    public void testChaCha20() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        ChaCha20ParameterSpec parameterSpec = new ChaCha20ParameterSpec(nonce, counter);
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), CHACHA20_ALG);

        //Initialise cipher with our keyspec and paramspec
        encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec, parameterSpec);

        byte[] cipherText = encryptCipher.doFinal(PLAINTEXT.getBytes());
        System.out.println("Encrypted Text : " + Base64.getEncoder().encodeToString(cipherText));

        decryptCipher.init(Cipher.DECRYPT_MODE, keySpec, parameterSpec);
        String decrypted = new String(decryptCipher.doFinal(cipherText));
        assertThat(decrypted).isEqualTo(PLAINTEXT);
    }
}
