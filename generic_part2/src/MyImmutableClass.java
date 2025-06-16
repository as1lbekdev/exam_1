import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.Objects;

public final class MyImmutableClass<T> {
    private final T age;
    private final String name;
    private final User user;

    public MyImmutableClass(T age, String name, User user) {
        this.age = age;
        this.name = name;
        this.user = user;
    }

    public T getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public User getUser() throws JsonProcessingException {
        return new Generic().readObjectToFile(user, User.class);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MyImmutableClass that = (MyImmutableClass) o;
        return age == that.age && Objects.equals(name, that.name) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, user);
    }
}
