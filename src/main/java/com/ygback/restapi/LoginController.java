
package com.ygback.restapi;

import com.ygback.model.UserAccountModel;
import com.ygback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@ResponseBody
public class LoginController {

  private final UserService userService;


  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserAccountModel> get(@RequestBody UserAccountModel userAccountModel)
  {
    return  ResponseEntity.ok(userService.login(userAccountModel));
  }
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserAccountModel> login(@RequestBody UserAccountModel userAccountModel)
  {
    return  ResponseEntity.ok(userService.login(userAccountModel));
  }
}

