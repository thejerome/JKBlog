package com.efimchick.jkblog.dao.mock;

import com.efimchick.jkblog.dao.TagDao;
import com.efimchick.jkblog.domain.Tag;


import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Jerome on 16.04.2014.
 */
public class TagDaoMock implements TagDao {
    @Override
    public Tag findById(Long id) {
        return getTag(t -> t.getId().equals(id));
    }

    @Override
    public Tag findByName(String name) {
        return getTag(tag -> tag.getName().equals(name));
    }

    @Override
    public List<Tag> findAllByParent(Tag parent) {
        return null;
    }

    @Override
    public Tag save(Tag tag) {
        synchronized (MockModel.instance.tags) {
            delete(tag);
            MockModel.instance.tags.add(tag);
        }
        return tag;
    }

    @Override
    public void delete(Tag tag) {
        MockModel.instance.tags.remove(findById(tag.getId()));
    }

    @Override
    public List<Tag> findAll(int pageNumber, int perPage) {
        return MockModel.instance.tags.stream().collect(Collectors.toList());
    }

    private Tag getTag(Predicate<Tag> predicate) {
        return MockModel.instance.tags.stream().filter(predicate).findFirst().orElse(null);
    }


}
