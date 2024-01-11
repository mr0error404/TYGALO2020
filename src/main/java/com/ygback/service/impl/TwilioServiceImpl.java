package com.ygback.service.impl;

import com.twilio.Twilio;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.api.v2010.Account;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import com.ygback.domain.UserAccount;
import com.ygback.model.UserAccountModel;
import com.ygback.repositories.UserAccountRepository;
import com.ygback.service.MessageService;
import com.ygback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TwilioServiceImpl implements MessageService {

    @Value("${spring.twilio.SID}")
    private String sId;

    @Value("${spring.twilio.Token}")
    private String token;

    @Value("${spring.twilio.from}")
    private String from;

    @Override
    public String sendMessage(String phoneNumber, Integer pinCode) {
        Twilio.init(sId, token);

       /* Message message = Message.creator(
                        new com.twilio.type.PhoneNumber(phoneNumber),
                        new com.twilio.type.PhoneNumber(from),
                        pinCode.toString())
                .create();
*/
        return "Message has been sent successfully";
    }
}
