package crypto;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class EdDSATest {

    private static final String EdDSA_ALG = "EdDSA";
    private static final String PLAINTEXT = "I'm a super secret message";

    private final Cipher encryptCipher = Cipher.getInstance(EdDSA_ALG);
    private final Cipher decryptCipher = Cipher.getInstance(EdDSA_ALG);

    private final byte[] nonce = new byte[12];
    private final int counter = 900;

    private KeyGenerator keyGenerator = KeyGenerator.getInstance(EdDSA_ALG);
    private SecretKey key = keyGenerator.generateKey();

    public EdDSATest() throws NoSuchPaddingException, NoSuchAlgorithmException {
    }
    //EdDSA required:


}
