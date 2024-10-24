package com.alexander.java.examples;

import org.junit.jupiter.api.Test;

import javax.crypto.KEM;
import javax.crypto.SecretKey;
import java.security.KeyPairGenerator;
import java.security.Provider;
import java.security.Security;

import static org.assertj.core.api.Assertions.assertThat;

public class KeyEncapsulationMechanismTest {

    @Test
    void generateKey() throws Exception {

        KeyPairGenerator keyGenerator = KeyPairGenerator.getInstance("EC");
        var keyPair = keyGenerator.generateKeyPair();

        KEM kem = KEM.getInstance("DHKEM");

        // Create an encapsulator from the receiver's public key
        var encapsulator = kem.newEncapsulator(keyPair.getPublic());

        // Generate an encapsulation
        KEM.Encapsulated encapsulated = encapsulator.encapsulate();
        SecretKey encKey = encapsulated.key();

        // This is the encapsulation message that will be sent to the receiver
        byte[] message = encapsulated.encapsulation();

        // Create a decapsulator from the receiver's private key
        var decapsulator = kem.newDecapsulator(keyPair.getPrivate());
        SecretKey decKey = decapsulator.decapsulate(message);

        // Verify that the encKey and decKey are the same
        assertThat(encKey).isEqualTo(decKey);
    }

    @Test
    void printSecurityProviders() {
        for (Provider provider: Security.getProviders()) {
            System.out.println(provider.getName());
            for (String key: provider.stringPropertyNames())
                System.out.println("\t" + key + "\t" + provider.getProperty(key));
        }
    }
}
