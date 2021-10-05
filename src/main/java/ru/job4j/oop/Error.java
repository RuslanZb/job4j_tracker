package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Активность: " + active);
        System.out.println("Статус: " + status);
        System.out.println("Сообщение: " + message);
    }

    public static void main(String[] args) {
        Error errorDefault = new Error();
        errorDefault.printInfo();
        System.out.println(" ");
        Error error9999 = new Error(true, 9999, "Неизвестная ошибка");
        error9999.printInfo();
        System.out.println(" ");
        Error error1212 = new Error(false, 1212, "Нет связи");
        error1212.printInfo();
    }
}
