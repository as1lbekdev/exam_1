package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
@AllArgsConstructor
public class Debt {
    private UUID userId;
    private UUID marketId;
    private double amount;


    public Debt(UUID userId, double amount) {

    }
}


