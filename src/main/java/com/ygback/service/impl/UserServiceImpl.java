package com.ygback.service.impl;

import com.ygback.domain.UserAccount;
import com.ygback.model.RequestModel;
import com.ygback.model.UserAccountModel;
import com.ygback.repositories.UserAccountRepository;
import com.ygback.service.MessageService;
import com.ygback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserAccountRepository userAccountRepository;
    private final MessageService messageService;
    @Override
    public RequestModel login(RequestModel requestModel) {
        UserAccount userAccount = userAccountRepository.findUserAccountByPhoneNumber(requestModel.getData().getUserInformation().getPhoneNumber());
        if(userAccount == null)
        {
            userAccount = userAccountRepository.save(requestModel.getData().getUserInformation().assemble());
            userAccount.setExternalId(messageService.sendMessage(userAccount.getPhoneNumber(), userAccount.getPinCode()));
            requestModel.getData().setNewUser(true);
            requestModel.getData().setDeviceNew(true);
            requestModel.getData().setOtpSent(true);
            requestModel.setSuccess(true);
            requestModel.setMessage(userAccount.getExternalId());
        }
        else if (requestModel.getData().getUserInformation().assemble().getFcmToken() != null && !requestModel.getData().getUserInformation().assemble().getFcmToken().equalsIgnoreCase(userAccount.getFcmToken()) )
        {
            userAccount.setExternalId(messageService.sendMessage(userAccount.getPhoneNumber(), userAccount.getPinCode()));
            userAccount.setFcmToken(requestModel.getData().getUserInformation().assemble().getFcmToken());
            userAccount.setDeviceId(requestModel.getData().getUserInformation().assemble().getDeviceId());
            userAccount.setGender(userAccount.getGender());
            requestModel.getData().setDeviceNew(true);
            requestModel.getData().setNewUser(false);
            requestModel.setSuccess(true);
            requestModel.getData().setOtpSent(true);
            requestModel.setMessage(userAccount.getExternalId());
        }
        userAccountRepository.save(userAccount);
        return requestModel;
    }
}
