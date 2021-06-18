package com.kodilla.accounts.dto;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AccountDto {

    private Long id;
    private String nrb;
    private String currency;
    private double availableFunds;

}