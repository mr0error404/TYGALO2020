package com.ygback.service.impl;

import com.ygback.domain.UserAccount;
import com.ygback.model.UserAccountModel;
import com.ygback.repositories.UserAccountRepository;
import com.ygback.service.MessageService;
import com.ygback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserAccountRepository userAccountRepository;
    private final MessageService messageService;
    @Override
    public UserAccountModel login(UserAccountModel userAccountModel) {
        UserAccount userAccount = userAccountRepository.findUserAccountByPhoneNumber(userAccountModel.getPhoneNumber());
        if(userAccount == null)
        {
            userAccount = userAccountRepository.save(userAccountModel.assemble());
            userAccount.setExternalId(messageService.sendMessage(userAccount.getPhoneNumber(), userAccount.getPinCode()));
        }
        else if (userAccountModel.getFcmToken() != null && !userAccountModel.getFcmToken().equalsIgnoreCase(userAccount.getFcmToken()) )
        {
            userAccount.setExternalId(messageService.sendMessage(userAccount.getPhoneNumber(), userAccount.getPinCode()));
            userAccount.setFcmToken(userAccountModel.getFcmToken());
            userAccount.setDeviceId(userAccountModel.getDeviceId());
            userAccount.setGender(userAccount.getGender());
        }


        userAccountRepository.save(userAccount);
        return new UserAccountModel(userAccount);
    }
}
