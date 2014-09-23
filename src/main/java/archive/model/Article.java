package archive.model;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

/**
 * Created by Jerome on 09.04.14.
 */
public class Article {
    Long id;

    Person author;

    String title;
    String content;

    LocalDateTime created;
    LocalDateTime updated;

    List<Tag> tags;

    public Article() {
    }

    public Article(Long id) {
        this.id = id;
    }

    public Article(Long id, Person author, String title, String content, LocalDateTime created, LocalDateTime updated, List<Tag> tags) {
        this.id = id;
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

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
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

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;

        Article article = (Article) o;

        if (id != null ? !id.equals(article.id) : article.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }


    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                ", tags=" + tags +
                '}';
    }

    public static Article empty() {
        return empty(0L);
    }

    public static Article empty(long id) {
        return new Article(
                id,
                Person.empty(),
                "Lorem ipsum",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus iaculis massa neque, at dapibus arcu laoreet id. Pellentesque massa lacus, blandit eget imperdiet ac, suscipit a nisl. Integer cursus enim ut luctus blandit. Curabitur suscipit turpis elementum velit pulvinar, tristique consectetur lectus fringilla. Maecenas vitae dui posuere, semper ipsum faucibus, eleifend arcu. Nullam in urna bibendum, sollicitudin nunc sed, venenatis mi. Duis at nunc eleifend, malesuada ipsum sit amet, bibendum nibh. Vivamus eu laoreet enim, vel tempus quam. Donec ipsum sapien, consequat ut tortor ut, tincidunt mollis lorem.\n" +
                        "\n" +
                        "Pellentesque commodo sodales risus, ut consequat dolor luctus id. Curabitur vitae eros eget sem sodales imperdiet sed aliquet lectus. Ut adipiscing erat ac est suscipit lobortis. Curabitur ac iaculis massa. Cras ac est in libero ultricies aliquet. Nulla id sagittis urna. Vivamus facilisis, erat a tempus aliquet, dui eros vulputate quam, sed vulputate velit elit nec lacus. Cras et scelerisque felis, a convallis felis. Praesent non molestie turpis. Sed vitae neque dui. In sagittis pellentesque dapibus. Pellentesque varius neque laoreet, iaculis dui a, aliquet arcu. Fusce mauris odio, sodales quis justo id, molestie laoreet tortor. Sed ultricies lobortis dolor, in ultricies massa consectetur eu.\n" +
                        "\n" +
                        "Vivamus ut consectetur nisi, non dictum urna. Sed in sem ut sapien tincidunt lacinia. In hac habitasse platea dictumst. Integer adipiscing ut ipsum non hendrerit. Donec malesuada rhoncus augue. Aliquam erat volutpat. Aliquam varius neque et tristique imperdiet. Suspendisse ut bibendum tortor, vel tincidunt ligula. Sed in adipiscing mauris. Vivamus eget lectus eros. Quisque tincidunt in tortor et interdum. Donec gravida quam mauris, sit amet accumsan massa aliquet ut.\n" +
                        "\n" +
                        "Morbi sagittis felis accumsan, rutrum lorem eget, lobortis diam. Nullam sit amet arcu quis magna laoreet condimentum vitae at dui. Aenean eget nulla iaculis, lobortis arcu id, commodo velit. Donec sagittis, neque a tincidunt rhoncus, dui dolor lobortis lectus, vestibulum cursus neque ipsum et nisi. Nam imperdiet velit ipsum, et molestie felis eleifend at. Morbi nisi tortor, scelerisque a dictum dapibus, interdum vel justo. Nulla sit amet arcu sed magna hendrerit fringilla egestas at sem. Nunc bibendum ultrices erat sed ornare. Ut consequat a lorem et faucibus.\n" +
                        "\n" +
                        "Mauris at elit non nunc semper placerat. Suspendisse congue, purus ac luctus pulvinar, lectus ante interdum leo, ac mollis sapien quam in leo. Vestibulum semper et arcu sit amet eleifend. Sed eu tortor laoreet, imperdiet dolor quis, aliquet nunc. Vivamus sit amet faucibus dui. Integer id felis eget dui eleifend consequat in et nulla. Etiam tincidunt mattis luctus. Mauris facilisis semper dui, sed adipiscing lorem ullamcorper id. Nunc pulvinar erat sit amet elit laoreet, in lacinia eros aliquam.",
                LocalDateTime.now(),
                LocalDateTime.now(),
                Collections.<Tag>emptyList()
        );
    }
}
