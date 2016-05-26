package com.deemsys.project.common;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.*;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class AWSFileUpload {
	
	@Resource(name="appProperties")
	private Properties appProperties;

	public void uploadFileToAWSS3(MultipartFile file,String folderName, String fileName)
			throws IOException {

		try {
			// credentials object identifying user for authentication
			// user must have AWSConnector and AmazonS3FullAccess
			AWSCredentials credentials = new BasicAWSCredentials(
					appProperties.getProperty("accessKey"),
					appProperties.getProperty("secretKey"));
			String bucketName = appProperties.getProperty("bucketName");
			// create a client connection based on credentials
			AmazonS3 s3client = new AmazonS3Client(credentials);
			System.out.println("Create Connection..........................");

			// Upload file to folder and set it to public
			s3client.putObject(new PutObjectRequest(bucketName, folderName
					+ fileName, file.getInputStream(), null)
					.withCannedAcl(CannedAccessControlList.PublicRead));
			System.out.println("File uploaded..........................");
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which "
					+ "means your request made it "
					+ "to Amazon S3, but was rejected with an error response"
					+ " for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which "
					+ "means the client encountered "
					+ "an internal error while trying to "
					+ "communicate with S3, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}
	
	public void deleteFileFromAWSS3(String fileName)
			throws IOException {

		try {
			// credentials object identifying user for authentication
			// user must have AWSConnector and AmazonS3FullAccess
			AWSCredentials credentials = new BasicAWSCredentials(
					appProperties.getProperty("accessKey"),
					appProperties.getProperty("secretKey"));
			String bucketName = appProperties.getProperty("bucketName");
			String folderName = appProperties.getProperty("folderName");
			// create a client connection based on credentials
			AmazonS3 s3client = new AmazonS3Client(credentials);
			System.out.println("Create Connection..........................");

			// Upload file to folder and set it to public
			s3client.deleteObject(bucketName, folderName+fileName);
			System.out.println("File Deleted..........................");
		} catch (AmazonServiceException ase) {
			System.out.println("Caught an AmazonServiceException, which "
					+ "means your request made it "
					+ "to Amazon S3, but was rejected with an error response"
					+ " for some reason.");
			System.out.println("Error Message:    " + ase.getMessage());
			System.out.println("HTTP Status Code: " + ase.getStatusCode());
			System.out.println("AWS Error Code:   " + ase.getErrorCode());
			System.out.println("Error Type:       " + ase.getErrorType());
			System.out.println("Request ID:       " + ase.getRequestId());
		} catch (AmazonClientException ace) {
			System.out.println("Caught an AmazonClientException, which "
					+ "means the client encountered "
					+ "an internal error while trying to "
					+ "communicate with S3, "
					+ "such as not being able to access the network.");
			System.out.println("Error Message: " + ace.getMessage());
		}
	}
	
}
