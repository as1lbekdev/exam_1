package uz.pdp.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter @Getter
@AllArgsConstructor @NoArgsConstructor
public class BaseCategory extends BaseModel {
    private String name;
    private UUID createdById;
    private UUID updatedById;
}