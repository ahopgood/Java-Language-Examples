package crypto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HmacSha3Test {

    private static final String HMAC_SHA3_224 = "HmacSHA3-224";
    private static final String HMAC_SHA3_256 = "HmacSHA3-256";
    private static final String HMAC_SHA3_384 = "HmacSHA3-384";
    private static final String HMAC_SHA3_512 = "HmacSHA3-512";

    private static final String SECRET_KEY = "1234";


    @ValueSource(strings = {HMAC_SHA3_224, HMAC_SHA3_256, HMAC_SHA3_384, HMAC_SHA3_512})
    @ParameterizedTest
    void macTest(String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(algorithm);

        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), algorithm);
        mac.init(keySpec);
        byte[] sha3Hmac = mac.doFinal("My message".getBytes(StandardCharsets.UTF_8));

        System.out.println(String.format("Hex: %032x", new BigInteger(1, sha3Hmac)));

        String base64HmacSha256 = Base64.getEncoder().encodeToString(sha3Hmac);
        System.out.println("Base64: " + base64HmacSha256);
        System.out.println("Byte length: " + sha3Hmac.length);
    }

    @ValueSource(strings = {HMAC_SHA3_224, HMAC_SHA3_256, HMAC_SHA3_384, HMAC_SHA3_512})
    @ParameterizedTest
    void macTest_withGeneratedKey(String algorithm) throws NoSuchAlgorithmException, InvalidKeyException {
        KeyGenerator generator = KeyGenerator.getInstance(algorithm);
        Mac mac = Mac.getInstance(algorithm);


        SecretKeySpec keySpec = new SecretKeySpec(generator.generateKey().getEncoded(), algorithm);
        mac.init(keySpec);
        byte[] sha3Hmac = mac.doFinal("My message".getBytes(StandardCharsets.UTF_8));

        System.out.println(String.format("Hex: %032x", new BigInteger(1, sha3Hmac)));

        String base64HmacSha256 = Base64.getEncoder().encodeToString(sha3Hmac);
        System.out.println("Base64: " + base64HmacSha256);
        System.out.println("Byte length: " + sha3Hmac.length);
    }

}
