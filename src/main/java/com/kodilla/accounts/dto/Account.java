package com.kodilla.accounts.dto;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long iddto;

    @Column(name = "nrb")
    private String nrb;

    @Column(name = "currency")
    private String currency;

    @Column(name = "available_funds")
    private double availableFunds;

    @Column(name = "customer_id")
    private Long idCustomer;

}