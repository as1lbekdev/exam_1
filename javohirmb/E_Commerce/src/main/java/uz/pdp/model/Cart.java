package uz.pdp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class Cart extends BaseModel {
    private UUID userId;
    private List<Product> products;
}
