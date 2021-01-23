package org.varnaa.S3;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

/**
 * @author swethavarnaa
 */

public class S3ClientFactory {
    private static final AmazonS3ClientBuilder builder = AmazonS3ClientBuilder
            .standard()
            .withRegion(Regions.AP_SOUTH_1)
            .withCredentials(new ProfileCredentialsProvider("default"));


    public static AmazonS3 createClient() {
        return builder.build();
    }
}
