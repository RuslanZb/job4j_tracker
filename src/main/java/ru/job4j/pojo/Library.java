package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 564);
        Book harryPotter = new Book("Harry Potter", 433);
        Book capital = new Book("Capital", 786);
        Book ball = new Book("Ball", 22);
        Book[] books = new Book[]{cleanCode, harryPotter, capital, ball};
        for (Book num : books) {
            System.out.println(num.getName() + " - " + num.getPages() + "p.");
        }
        System.out.println(" ");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book num : books) {
            System.out.println(num.getName() + " - " + num.getPages() + "p.");
        }
        System.out.println(" ");
        for (Book num : books) {
            if ("Clean code".equals(num.getName())) {
                System.out.println(num.getName() + " - " + num.getPages() + "p.");
            }
        }
    }
}
