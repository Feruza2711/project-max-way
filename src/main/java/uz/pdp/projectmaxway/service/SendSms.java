package uz.pdp.projectmaxway.service;


import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class SendSms {
    public static final String ACCOUNT_SID ="ACa0c5aeaa3a316b4ddf1f1efe88506ebc";
    public static final String AUTH_TOKEN = "afd61e8f82f867b75e6e61b4e59e486c";

    public  String SendSmsPhoneNumber(String phoneNumber){
        Random random = new Random();
        int num = random.nextInt(100000);
        String smsBody = String.format("%05d", num);
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message= Message.creator(
               new PhoneNumber(phoneNumber),
                new PhoneNumber("+17707625377"),
                "Your code :"+
                smsBody
        ).create();
        return smsBody;
    }
}
