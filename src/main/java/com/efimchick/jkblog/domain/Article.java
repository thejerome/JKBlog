package com.efimchick.jkblog.domain;

import com.google.common.collect.Lists;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jerome
 * Date: 28.09.13
 * Time: 14:19
 * To change this template use File | Settings | File Templates.
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "Article.findAll", query = "from Article order by created desc "),
        @NamedQuery(name = "Article.findAllByTags", query = "from Article a left join fetch a.author p left join fetch a.tags t where t.id in :ids order by a.created desc"),
        @NamedQuery(name = "Article.findByAuthor", query = "from Article a left join fetch a.author p left join fetch a.tags t where p.id = :id order by a.created desc")
})
public class Article implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person author;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable( name = "Article_Tag", joinColumns = @JoinColumn(name = "article_id"), inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    public Article() {
    }

    public Article(Person author, String title, String content, Date created, Date updated, List<Tag> tags) {
        this.author = author;
        this.title = title;
        this.content = content;
        this.created = created;
        this.updated = updated;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void addTag(Tag tag) {
        if (tags.contains(tag))
            return ;
        tags.add(tag);
    }

    public void removeTag(Tag tag) {
        if (!tags.contains(tag))
            return ;
        tags.remove(tag);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", author=" + author +
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;

        Article article = (Article) o;

        if (title != null ? !title.equals(article.title) : article.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }

    public static Article empty() {
        return empty("Lorem ipsum");
    }

    public static Article empty(String title) {
        return new Article(
                Person.empty(),
                title,
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus iaculis massa neque, at dapibus arcu laoreet id. Pellentesque massa lacus, blandit eget imperdiet ac, suscipit a nisl. Integer cursus enim ut luctus blandit. Curabitur suscipit turpis elementum velit pulvinar, tristique consectetur lectus fringilla. Maecenas vitae dui posuere, semper ipsum faucibus, eleifend arcu. Nullam in urna bibendum, sollicitudin nunc sed, venenatis mi. Duis at nunc eleifend, malesuada ipsum sit amet, bibendum nibh. Vivamus eu laoreet enim, vel tempus quam. Donec ipsum sapien, consequat ut tortor ut, tincidunt mollis lorem.\n" +
                        "\n" +
                        "Pellentesque commodo sodales risus, ut consequat dolor luctus id. Curabitur vitae eros eget sem sodales imperdiet sed aliquet lectus. Ut adipiscing erat ac est suscipit lobortis. Curabitur ac iaculis massa. Cras ac est in libero ultricies aliquet. Nulla id sagittis urna. Vivamus facilisis, erat a tempus aliquet, dui eros vulputate quam, sed vulputate velit elit nec lacus. Cras et scelerisque felis, a convallis felis. Praesent non molestie turpis. Sed vitae neque dui. In sagittis pellentesque dapibus. Pellentesque varius neque laoreet, iaculis dui a, aliquet arcu. Fusce mauris odio, sodales quis justo id, molestie laoreet tortor. Sed ultricies lobortis dolor, in ultricies massa consectetur eu.\n" +
                        "\n" +
                        "Vivamus ut consectetur nisi, non dictum urna. Sed in sem ut sapien tincidunt lacinia. In hac habitasse platea dictumst. Integer adipiscing ut ipsum non hendrerit. Donec malesuada rhoncus augue. Aliquam erat volutpat. Aliquam varius neque et tristique imperdiet. Suspendisse ut bibendum tortor, vel tincidunt ligula. Sed in adipiscing mauris. Vivamus eget lectus eros. Quisque tincidunt in tortor et interdum. Donec gravida quam mauris, sit amet accumsan massa aliquet ut.\n" +
                        "\n" +
                        "Morbi sagittis felis accumsan, rutrum lorem eget, lobortis diam. Nullam sit amet arcu quis magna laoreet condimentum vitae at dui. Aenean eget nulla iaculis, lobortis arcu id, commodo velit. Donec sagittis, neque a tincidunt rhoncus, dui dolor lobortis lectus, vestibulum cursus neque ipsum et nisi. Nam imperdiet velit ipsum, et molestie felis eleifend at. Morbi nisi tortor, scelerisque a dictum dapibus, interdum vel justo. Nulla sit amet arcu sed magna hendrerit fringilla egestas at sem. Nunc bibendum ultrices erat sed ornare. Ut consequat a lorem et faucibus.\n" +
                        "\n" +
                        "Mauris at elit non nunc semper placerat. Suspendisse congue, purus ac luctus pulvinar, lectus ante interdum leo, ac mollis sapien quam in leo. Vestibulum semper et arcu sit amet eleifend. Sed eu tortor laoreet, imperdiet dolor quis, aliquet nunc. Vivamus sit amet faucibus dui. Integer id felis eget dui eleifend consequat in et nulla. Etiam tincidunt mattis luctus. Mauris facilisis semper dui, sed adipiscing lorem ullamcorper id. Nunc pulvinar erat sit amet elit laoreet, in lacinia eros aliquam.",
                Date.from(OffsetDateTime.now().toInstant()),
                Date.from(OffsetDateTime.now().toInstant()),
                Collections.<Tag>emptyList()
        );
    }

}
