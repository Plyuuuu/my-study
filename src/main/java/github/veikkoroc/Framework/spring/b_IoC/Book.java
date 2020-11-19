package github.veikkoroc.Framework.spring.b_IoC;

/**
 * @author Veikko Roc
 * @version 1.0
 * @date 2020/9/25 12:32
 */
public class Book {
    private String bname;
    private String bauthor;
    /**
     * 依赖Person
     */
    private Person author;

    public Book() {
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBauthor() {
        return bauthor;
    }

    public void setBauthor(String bauthor) {
        this.bauthor = bauthor;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", bauthor='" + bauthor + '\'' +
                ", author=" + author +
                '}';
    }
}
