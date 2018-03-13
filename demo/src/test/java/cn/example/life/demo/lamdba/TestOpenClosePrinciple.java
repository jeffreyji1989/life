package cn.example.life.demo.lamdba;

import com.sun.media.jfxmedia.logging.Logger;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by Junhuiji on 2018/2/11 11:00.
 */
@Slf4j
public class TestOpenClosePrinciple {
    public static void main(String[] args) {
        IBook book = new NovelBook("大主宰", 23.4d, "天蚕土豆");
        log.info(book.toString());
        book = new OffNovelBook("大主宰", 23.4d, "天蚕土豆");
        log.info("打折后:{}",book);
    }
}

interface IBook {
    double getPrice();

    String getName();

    default String getAuthor() {
        return "jeffry";
    }
}

@Slf4j
@ToString
class NovelBook implements IBook {
    private String name;
    private double price;
    private String author;

    public NovelBook() {
    }

    public NovelBook(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }
}

class OffNovelBook extends NovelBook{

    public OffNovelBook() {
    }

    public OffNovelBook(String name, double price, String author) {
        super(name, price, author);
    }

    @Override
    public double getPrice() {
        return super.getPrice() *50 /100.0;
    }
}
