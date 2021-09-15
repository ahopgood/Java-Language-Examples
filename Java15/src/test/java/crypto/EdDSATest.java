package crypto;

import org.junit.jupiter.api.Test;

import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EdDSATest {

    private static final String ED_DSA_ALG = "EdDSA";
    private static final String ED_DSA_PARAM_SPEC_25519 = "Ed25519";
    private static final String ED_DSA_PARAM_SPEC_448 = "Ed448";
    private static final String PLAINTEXT = "I'm a super secret message";

    @Test
    void testEdDSA_signing() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ED_DSA_PARAM_SPEC_25519);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        Signature sig = Signature.getInstance(ED_DSA_PARAM_SPEC_25519);
        sig.initSign(keyPair.getPrivate());
        sig.update(PLAINTEXT.getBytes());

        byte[] signedBytes = sig.sign();
        System.out.println("Signature Text : " + Base64.getEncoder().encodeToString(signedBytes));

        Signature verifier = Signature.getInstance(ED_DSA_PARAM_SPEC_25519);
        verifier.initVerify(keyPair.getPublic());
        verifier.update(PLAINTEXT.getBytes());
        assertTrue(verifier.verify(signedBytes));

    }
}
