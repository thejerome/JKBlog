package com.efimchick.jkblog.domain;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Jerome
 * Date: 28.09.13
 * Time: 14:26
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQueries({
        @NamedQuery( name = "Tag.findAll", query = "from Tag t left join fetch t.parent"),
        @NamedQuery( name = "Tag.findAllByParent", query = "from Tag t left join fetch t.parent p where p.id = :id"),
        @NamedQuery( name = "Tag.findByName", query = "from Tag t left join fetch t.parent where lower(t.name) like lower('%' || :name || '%')")
})
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    private Tag parent;

    public Tag() {
    }

    public Tag(String name) {
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

    public Tag getParent() {
        return parent;
    }

    public void setParent(Tag parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parent=" + parent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tag)) return false;

        Tag tag = (Tag) o;

        if (name != null ? !name.equals(tag.name) : tag.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
