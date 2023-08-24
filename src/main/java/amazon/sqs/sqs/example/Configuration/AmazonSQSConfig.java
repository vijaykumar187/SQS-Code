package amazon.sqs.sqs.example.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmazonSQSConfig {

    private static final String accessKey = "AKIA33LPEXQSWECBLCHI";

    private static final String secretKey = "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";

    private static final String region = "ap-south-1";

    @Bean
    public AmazonSQS amazonSQS() {
        BasicAWSCredentials awsCredentials = new BasicAWSCredentials(accessKey, secretKey);

        return AmazonSQSClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCredentials))
                .withRegion(region)
                .build();
    }
}
