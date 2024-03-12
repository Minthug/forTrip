package account.controller;

import account.dto.PostAccountDto;
import account.service.AccountService;
import global.common.dto.SingleResDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

//    @PostMapping
//    public ResponseEntity<SingleResDto<String>> accountAdd(@Valid @ModelAttribute PostAccountDto createAccountDto) {
//        createAccountDto.setPassword();
//    }


}
