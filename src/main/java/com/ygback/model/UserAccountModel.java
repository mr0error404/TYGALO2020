package com.ygback.model;

import com.ygback.domain.UserAccount;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class UserAccountModel {
  private String phoneNumber;
  private String firstName;
  private String lastName;
  private UserAccount.UserAccountStatus status;
  private Integer pinCode;
  private String gender;

   private String fcmToken;
   private String deviceId;
   private String externalId;

  public UserAccountModel(UserAccount userAccount)
  {
    this.pinCode = userAccount.getPinCode();
    this.phoneNumber = userAccount.getPhoneNumber();
    this.firstName = userAccount.getFirstName();
    this.lastName = userAccount.getLastName();
    this.gender = userAccount.getGender();
    this.fcmToken = userAccount.getFcmToken();
    this.deviceId= userAccount.getDeviceId();
    this.externalId = userAccount.getExternalId();
    this.status = userAccount.getStatus();
  }


  public UserAccount assemble()
  {
    UserAccount userAccount = new UserAccount();
    userAccount.setPhoneNumber( this.getPhoneNumber());
    userAccount.setStatus(this.getStatus());
    userAccount.setFirstName(this.getFirstName());
    userAccount.setLastName(this.getLastName());
    userAccount.setPinCode(this.getPinCode());
    userAccount.setFcmToken(this.getFcmToken());
    userAccount.setGender(this.getGender());
    userAccount.setDeviceId(this.getDeviceId());

    return userAccount;
  }
}
