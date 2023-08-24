package amazon.sqs.sqs.example.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SenderService {

    @Autowired
    public AmazonSQS amazonSQS;

    public void sendMessage(String url,
                            String message){

        SendMessageRequest sendMessageRequest = new SendMessageRequest()
                .withQueueUrl(url)
                .withMessageBody(message);

        amazonSQS.sendMessage(sendMessageRequest);

        System.out.println("Message sent : " + message);
    }
}
