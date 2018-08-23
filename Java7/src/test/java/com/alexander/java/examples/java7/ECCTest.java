package com.alexander.java.examples.java7;

import org.junit.Test;

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

import static org.junit.Assert.assertEquals;

public class ECCTest {

    @Test
    public void testECCKeyGeneration() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("EC");
        KeyPair keypair =  generator.generateKeyPair();
        PrivateKey eccPrivateKey = keypair.getPrivate();
        assertEquals(true, (eccPrivateKey instanceof ECPrivateKey));
        PublicKey eccPublicKey = keypair.getPublic();
        assertEquals(true, (eccPrivateKey instanceof ECPublicKey));
    }
}
