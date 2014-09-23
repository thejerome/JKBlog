package archive.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by Jerome on 09.04.14.
 */
public class Role {
    Long id;
    String name;
    List<Right> rights;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name, List<Right> rights) {
        this.id = id;
        this.name = name;
        this.rights = rights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Right> getRights() {
        return rights;
    }

    public void setRights(List<Right> rights) {
        this.rights = rights;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rights=" + rights +
                '}';
    }

    public static Role empty() {
        return empty(0L);
    }

    public static Role empty(long id) {
        return new Role(id,
                "role",
                Collections.<Right>emptyList());
    }
}
