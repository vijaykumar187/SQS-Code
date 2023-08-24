package amazon.sqs.sqs.example.Service;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceiverService {

    @Autowired
    public AmazonSQS amazonSQS;

    public void receiveMessage(String url){

        List<Message> messageList = amazonSQS.receiveMessage(url).getMessages();

        for(Message message: messageList){

            System.out.println("Message Received : " + message);

            amazonSQS.deleteMessage(url, message.getReceiptHandle());
            System.out.println("Message deleted : " + message.getBody());
        }
    }
}
