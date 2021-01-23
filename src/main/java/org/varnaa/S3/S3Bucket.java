package org.varnaa.S3;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.SdkClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.Bucket;

import java.util.List;

/**
 * @author swethavarnaa
 */
/*

CLI Commands:

S3 - aws s3 mb s3://bucket_name

S3Api - aws s3api create-bucket --bucket bucket_name --region region_name --create-bucket-configuration

 */
public class S3Bucket {

    /*
    Other way of setting up client connection:
    private static final AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
     */
    private static final AmazonS3 s3Client = S3ClientFactory.createClient();

    public static void main(String[] args) {
        listBuckets();
        s3Client.shutdown();
    }

    public static void createS3Bucket(String bucketName) {
        try {
            if (!s3Client.doesBucketExistV2(bucketName)) {
                Bucket newBucket = s3Client.createBucket(bucketName);
                System.out.println("Name: " + newBucket.getName() + " Owner: " + newBucket.getOwner());
            } else {
                System.out.println("Bucket Name already exists");
            }
        } catch (SdkClientException e) {
            e.printStackTrace();
        }
    }


    public static void listBuckets() {
        List<Bucket> bucketList = s3Client.listBuckets();
        for (Bucket bucket : bucketList) {
            System.out.println("Name: " + bucket.getName());
        }
    }


    public static void deleteBucket(String bucketName) {
        try {
            s3Client.deleteBucket(bucketName);
            System.out.println("Bucket Deleted Successfully");
        } catch (AmazonServiceException e) {
            e.printStackTrace();
        }
    }
}
