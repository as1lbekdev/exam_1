import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Generic {

    public <T> T readObjectToFile(T t, Class<T> clazz) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = new ObjectMapper().writeValueAsString(t);
        return objectMapper.readValue(s, clazz);
    }
}
