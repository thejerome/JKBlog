package com.efimchick.jkblog.dao;

import com.efimchick.jkblog.domain.Tag;

import java.util.List;

/**
 * Created by Jerome on 16.04.2014.
 */
public interface TagDao extends Dao<Tag> {
    Tag findByName(String name);
    List<Tag> findAllByParent(Tag parent);
}
