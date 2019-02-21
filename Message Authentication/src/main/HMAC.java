package main;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class HMAC {
    public static final String HMAC_ALGORITHM = "HmacSha1";

    SecretKeySpec signingKey;

    public HMAC(String key){
        signingKey = new SecretKeySpec(key.getBytes(), HMAC_ALGORITHM);
    }

    public String generateMACString(String message) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance(HMAC_ALGORITHM);
        mac.init(signingKey);
        byte[] macBytes = mac.doFinal(message.getBytes());
        return new String(Base64.getEncoder().encode(macBytes));
    }
}
