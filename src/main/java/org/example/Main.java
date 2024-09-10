package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<String> books = new ArrayList<>();
        books.add("Война и мир");
        books.add("Улисс");
        books.add("Лолита");
        books.add("Звук и ярость");
        books.add("Человек-невидимка");
        books.add("На маяк");
        books.add("Гордость и предубеждение");
        books.add("Божественная комедия");
        books.add("Мидлмарч");
        books.add("Путешествия Гулливера");
        books.add("Распад");

        List<ArrayList<String>> ret = getShelvesOfBooks(books);

        ret.forEach(System.out::println);
}

private static List<ArrayList<String>> getShelvesOfBooks (List<String> books) {

    books = books.stream()
            .sorted()
            .collect(Collectors.toList());

    List<ArrayList<String>> shelves = new ArrayList<>();

    for (int i = 0; i < 5; i++) {
        ArrayList<String> shelf = new ArrayList<>();
        shelves.add(shelf);
    }

    int ind = 0;
    int shelfInd = 0;

    while (ind < books.size()) {
        int perShelf = getBooksPerShelf(books.size() - ind, shelves.size() - shelfInd);
        for (int i = 0; i < perShelf; i++) {
            shelves.get(shelfInd).add(books.get(ind));
            ind++;
        }
        shelfInd++;
    }
    return shelves;
}

    private static int getBooksPerShelf(int books, int shelves) {
        int perShelf = books / shelves;
        if (perShelf * shelves < books)
            perShelf++;
        return perShelf;
    }

}