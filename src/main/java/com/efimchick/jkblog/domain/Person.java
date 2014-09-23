package com.efimchick.jkblog.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Jerome
 * Date: 28.09.13
 * Time: 14:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQueries({
        @NamedQuery( name = "Person.findAll", query = "from Person p left join fetch p.role r")
})
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String name;
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    public Person() {
    }

    public Person(Long id, String email, String name, String password, Role role) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public static Person empty(){
        return empty(0L, "loremipsum");
    }
    public static Person empty(long id, String name) {
        return new Person(
                id,
                "lorem@ipsum.dolor",
                name,
                "Lorem Ipsum",
                Role.empty()
        );

    }

}
