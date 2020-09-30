package crypto;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

import static org.assertj.core.api.Assertions.assertThat;

public class Poly1305Test {

    private static final String POLY1305_ALG = "ChaCha20-Poly1305/None/NoPadding";
    private static final String CHACHA20_ALG = "ChaCha20";
    private static final String PLAINTEXT = "Hi Morty I'm some plaintext, I'm plaintext Rick!";

    private final Cipher encryptCipher = Cipher.getInstance(POLY1305_ALG);
    private final Cipher decryptCipher = Cipher.getInstance(POLY1305_ALG);

    private KeyGenerator keyGenerator = KeyGenerator.getInstance(CHACHA20_ALG);
    private SecretKey key = keyGenerator.generateKey();

    private final byte[] nonce = new byte[12];

    public Poly1305Test() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }

    @Test
    void testPoly1305() throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        AlgorithmParameterSpec ivParameterSpec = new IvParameterSpec(nonce);
        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), CHACHA20_ALG);

        encryptCipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
        byte[] cipher = encryptCipher.doFinal(PLAINTEXT.getBytes());

        String cipherText = Base64.getEncoder().encodeToString(cipher);
        System.out.println(cipherText);

        decryptCipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);
        byte[] decrypted = decryptCipher.doFinal(cipher);

        assertThat(new String(decrypted)).isEqualTo(PLAINTEXT);
    }
}
