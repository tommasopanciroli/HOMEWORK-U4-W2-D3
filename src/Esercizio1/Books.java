package Esercizio1;

import java.awt.print.Book;
import java.util.*;




public class Books {
    public static void main(String[] args) {
        String[] titles = {"After", "Il signore degli anelli", "Diario di una schiappa", "Moby Dick", "Goal"};

        Book[] books = Arrays.stream(titles)
                .map(titolo -> new Book())
                .toArray(Book[]::new);

        for (Book book : books) {
            System.out.println(book);
        }
    }
}
