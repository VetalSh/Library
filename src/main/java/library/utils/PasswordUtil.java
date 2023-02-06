package library.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * Used for obtain password hash, that we write to the dataBase
 */
public class PasswordUtil {
    private final static String ALGORITHM = "MD5";

    private PasswordUtil() {}

    public static String genHash(String pass) throws InvalidKeySpecException, NoSuchAlgorithmException {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(ALGORITHM);
            byte[] bytes = pass.getBytes();
            byte[] digested = messageDigest.digest(bytes);
            for (byte b : digested) {
                sb.append(Integer.toHexString(0xff & b));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
