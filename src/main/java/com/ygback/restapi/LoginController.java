
package com.ygback.restapi;

import com.ygback.model.RequestModel;
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
  public ResponseEntity<RequestModel> get(@RequestBody RequestModel requestModel)
  {
    return  ResponseEntity.ok(userService.login(requestModel));
  }
  @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<RequestModel> login(@RequestBody RequestModel requestModel)
  {
    return  ResponseEntity.ok(userService.login(requestModel));
  }
}

