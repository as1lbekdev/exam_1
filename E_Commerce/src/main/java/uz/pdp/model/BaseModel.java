package uz.pdp.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
public abstract class BaseModel {
    protected final UUID id;
    @Setter
    protected boolean active;

    public BaseModel() {
        this.id = UUID.randomUUID();
        this.active = true;
    }
}
