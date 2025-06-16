package model;

import java.util.UUID;

public class BaseModel {
    protected UUID id;
    protected boolean active;

    public BaseModel() {
        this.id = UUID.randomUUID();
        this.active = true;
    }

    public UUID getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
