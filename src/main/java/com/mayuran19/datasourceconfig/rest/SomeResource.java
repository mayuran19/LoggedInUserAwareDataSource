package com.mayuran19.datasourceconfig.rest;

import com.mayuran19.datasourceconfig.datasource.ThreadLocalStorage;
import com.mayuran19.datasourceconfig.service.SomeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/wallets")
@Slf4j
public class SomeResource {
    private final SomeService someService;

    public SomeResource(SomeService someService) {
        this.someService = someService;
    }

    @GetMapping
    public void getWallets(){
        ThreadLocalStorage.setCurrentLoggedInUser("user1_principal");
        someService.testWallet();
    }
}
