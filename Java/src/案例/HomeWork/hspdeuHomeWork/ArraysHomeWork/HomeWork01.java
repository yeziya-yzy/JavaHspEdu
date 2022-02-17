package 案例.HomeWork.hspdeuHomeWork.ArraysHomeWork;

import java.util.Arrays;
import java.util.Comparator;

/**
 * coding: utf-8
 *
 * @version 1.0
 */
public class HomeWork01 {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦",100);
        books[1] = new Book("金瓶梅",90);
        books[2] = new Book("青年文摘",5);
        books[3] = new Book("java从入门到放弃",300);

        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                return book1.getPrice() - book2.getPrice();
            }
        });
        System.out.println(Arrays.toString(books));
    }
}
class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}