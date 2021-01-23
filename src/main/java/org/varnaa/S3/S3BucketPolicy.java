package org.varnaa.S3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author swethavarnaa
 */
public class S3BucketPolicy {

    private static final String bucketName = "arara-23-s3";
    private static final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
    private static final String BUCKET_POLICY_FILE_PATH = "S3_BucketPolicy.json";


    public static void main(String[] args) {
        String policyText = readBucketPolicyFile();
        setBucketPolicy(policyText);
    }

    private static String readBucketPolicyFile() {
        StringBuilder policy = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("S3_BucketPolicy.json"));

            while (reader.ready()) {
                policy.append(reader.readLine());
            }

            reader.close();
        } catch (IOException var2) {
            var2.printStackTrace();
        }

        return policy.toString();
    }

    private static void setBucketPolicy(String policyText) {
        s3Client.setBucketPolicy("arara-23-s3", policyText);
        System.out.println("updated bucket policy.");
    }


}
