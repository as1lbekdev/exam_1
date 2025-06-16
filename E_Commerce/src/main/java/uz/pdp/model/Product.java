package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Product extends BaseModel {
    private UUID categoryId;
    private String productName;
    private double price;
}
