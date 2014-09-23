package com.efimchick.jkblog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 * User: Jerome
 * Date: 12.10.13
 * Time: 13:13
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;


    public Role() {
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (name != null ? !name.equals(role.name) : role.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }


    public static Role empty() {
        return empty(0L);
    }

    public static Role empty(long id) {
        return new Role(id,
                "role");
    }
}
