package com.saurabh.fx;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
public class Model {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String email;
    private String selectedBatch;
    private int totalFee;
    private boolean paymentDone;
}
