package com.example.sqch13ex1.controllers;

import com.example.sqch13ex1.entities.Account;
import com.example.sqch13ex1.entities.TranferRequest;
import com.example.sqch13ex1.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("transfer")
    public void transferMoney(@RequestBody TranferRequest request){
        transferService.transferMoney(
                request.getSenderAccountId(),
                request.getReceiverAccountId(),
                request.getAmount()
        );
    }

    @GetMapping("/accounts")
    public List<Account> getAccounts(){
        return transferService.getAllAccounts();
    }

}
