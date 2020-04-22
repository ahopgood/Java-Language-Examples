package com.alexander.java.example.java9;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HashTest {

    private static final String SHA3_224 = "SHA3-224";
    private static final String SHA3_256 = "SHA3-256";
    private static final String SHA3_384 = "SHA3-384";
    private static final String SHA3_512 = "SHA3-512";


    @ParameterizedTest
    @ValueSource( strings = {
            SHA3_224,
            SHA3_256,
            SHA3_384,
            SHA3_512
    })
    public void testSHA3(String alg) throws NoSuchAlgorithmException {
        MessageDigest sha3 = MessageDigest.getInstance(alg);
        assertThat(sha3.getProvider().getName()).isEqualTo("SUN");
        assertThat(sha3.getAlgorithm()).isEqualTo(alg);
    }



}
