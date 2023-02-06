package library.utils;

import org.junit.Assert;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import static org.junit.Assert.*;

public class PasswordUtilTest {
    @Test
    public void testGenHashIsTheSameOnSamePass() throws InvalidKeySpecException, NoSuchAlgorithmException {
        final String pass = "123";
        String hash1 = PasswordUtil.genHash(pass);
        String hash2 = PasswordUtil.genHash(pass);
        Assert.assertEquals(hash1, hash2);
    }
}