package amazon.sqs.sqs.example.Controller;

import amazon.sqs.sqs.example.Service.ReceiverService;
import amazon.sqs.sqs.example.Service.SenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueueController {

    @Autowired
    public ReceiverService receiverService;

    @Autowired
    public SenderService senderService;

    public static final String URL = "https://sqs.ap-south-1.amazonaws.com/814666267685/SampleQueue";
    @PostMapping("/send")
    public void sendMessage(@RequestBody String message){
        senderService.sendMessage(URL, message);
    }

    @GetMapping("/receive")
    public void receiveMessage(){
        receiverService.receiveMessage(URL);
    }

}
