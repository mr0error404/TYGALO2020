package com.ygback.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DataModel {
    private UserAccountModel userInformation;
    private boolean otpSent;
    private boolean isDeviceNew;
    private boolean isNewUser;
    private String token;
}
