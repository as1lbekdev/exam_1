package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;
@Getter
@Setter
@ToString
public class User {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String password;
    private int type; // 0 -> CASHIER, 1 -> CLIENT, 2 -> SUPER_ADMIN
    private UUID marketId;

    public User() {
        this.id = UUID.randomUUID();
    }


}
