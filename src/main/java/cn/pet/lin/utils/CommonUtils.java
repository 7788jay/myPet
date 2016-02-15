package cn.pet.lin.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * Created by Administrator on 2016/1/14.
 */
public class CommonUtils {

    /**
     * 根据appCode 生成应用appSecret
     * @param appCode
     * @return
     */
    public static String genAppSecret(String appCode){
        String MD5 = "MD5";
        String UTF8 = "UTF-8";
        MessageDigest messageDigest = null;
        try {
            messageDigest =MessageDigest.getInstance(MD5);
            messageDigest.update(new StringBuffer(appCode).toString().getBytes());
            return new BigInteger(1,messageDigest.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String makeUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static void main(String[] args){
        System.out.println(genAppSecret("dasd"));
    }

}
