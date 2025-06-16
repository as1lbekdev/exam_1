package uz.pdp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public abstract class BaseModel {
    private final UUID id;
    @Setter
    private boolean active;

    public BaseModel() {
        this.id = UUID.randomUUID();
        this.active = true;
    }
}
