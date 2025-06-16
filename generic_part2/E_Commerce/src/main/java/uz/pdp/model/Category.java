package uz.pdp.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "Category")
public class Category extends BaseModel{
    private String name;
    private UUID parentId;
}

/**
 *
 * category a texnika
 * texnika
 * null
 * category b phone
 * phone
 * texnikaId
 *
 *
 *
 */
