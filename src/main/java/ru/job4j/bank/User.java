package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью пользователя банка
 * Используется в классе {@link BankService}
 *
 * @author RUSLAN ZUBAIROV
 * @version 1.0
 */
public class User {
    /**
     * Модель бпользователя банка содержит поля паспорт и имя пользователя
     */
    private String passport;
    private String username;

    /**
     * Констурктор для инициализации полей
     *
     * @param passport - паспорт
     * @param username - имя пользователя
     */
    public User(String passport, String username) {
        this.passport = passport;
        this.username = username;
    }

    /**
     * Геттер
     *
     * @return возвращает паспорт
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Сеттер
     *
     * @param passport запись паспорта
     */
    public void setPassport(String passport) {
        this.passport = passport;
    }

    /**
     * Геттер
     *
     * @return возвращает имя пользователя
     */
    public String getUsername() {
        return username;
    }

    /**
     * Сеттер
     *
     * @param username запись имени пользователя
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Переопределение метода equals
     *
     * @param o
     * @return возвращает true, если номера паспорта пользователей равны,
     * false - не равны.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(passport, user.passport);
    }

    /**
     * Переопределение метода hashCode
     *
     * @return возвращает хэш-код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(passport);
    }
}
