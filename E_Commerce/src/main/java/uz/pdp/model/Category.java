package uz.pdp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Category")
public class Category extends BaseModel{
    private String name;
    private UUID createdById;
    private UUID updatedById;
    private UUID parentId;

    @JsonIgnore
    @JacksonXmlElementWrapper(localName = "categories")
    @JacksonXmlProperty(localName = "category")
    private List<Category> childCategories = new ArrayList<>();

    @JsonIgnore
    @JacksonXmlElementWrapper(localName = "products")
    @JacksonXmlProperty(localName = "product")
    private List<Product> childProducts = new ArrayList<>();

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\n' +
                "id=" + id + '\'' +
                '}';
    }
}
