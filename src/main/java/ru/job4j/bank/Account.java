package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс является моделью банковского счёта
 * Используется в классе {@link BankService}
 *
 * @author RUSLAN ZUBAIROV
 * @version 1.0
 */

public class Account {
    /**
     * Модель банковсого счёта содержит поля реквизиты и баланс
     */
    private String requisite;
    private double balance;

    /**
     * Конструктор для инициализации полей
     *
     * @param requisite - реквизиты
     * @param balance   - баланс
     */
    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Геттер
     *
     * @return возвращает реквизиты
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Сеттер
     *
     * @param requisite запись реквизитов
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Геттер
     *
     * @return возвращает баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Сеттер
     *
     * @param balance запись баланса
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Переопределение метода equals
     *
     * @param o 
     * @return возвращает true, если счёта равны, false - не равны.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Переопределение метода hashCode
     *
     * @return возвращает хэш-код.
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}