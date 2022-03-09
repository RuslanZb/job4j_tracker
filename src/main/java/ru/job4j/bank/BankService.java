package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс является простейшим банковским сервисом, который позволяет:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя.
 * 3. Добавлять пользователю банковский счёт.
 * 4. Переводить деньги с одного банковского счёта на другой счёт.
 *
 * @author RUSLAN ZUBAIROV
 * @version 2.0
 */

public class BankService {
    /**
     * Поле содержит всех пользователей {@link User} системы с привязанными
     * к ним счетами {@link Account}.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет его в список.
     *
     * @param user пользователь, который добавляется в список.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт пользователя и новый счёт,
     * который нужно добавить к пользователю.
     * Новый счёт будет добавлен, если в списке есть пользователь с данным паспортом
     * и если у пользователя отсутсвует этот счёт.
     *
     * @param passport номер паспорта пользователя, к которому добавляется счёт.
     * @param account  добавляемый счёт.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (!users.get(user).contains(account)) {
                users.get(user).add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта.
     * @return возвращает пользователя, если он есть в списке, иначе возвращает null.
     */
    public User findByPassport(String passport) {
        return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод позволяет найти счёт пользователя по номеру паспорта и реквизитам.
     * @param passport номер паспорта пользователя.
     * @param requisite реквизиты пользователя.
     * @return возвращает счёт пользователя, если он есть в списке, иначе возвращает null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user).stream()
                    .filter(s -> s.getRequisite().equals(requisite))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * @param srcPassport номер паспорта пользователя, со счёта которого будут перечислены деньги.
     * @param srcRequisite реквизиты счёта, с которого будут перечислены деньги.
     * @param destPassport номер паспорта пользователя, на счёта которого будут перечислены деньги.
     * @param destRequisite реквизиты счёта, на который будут перечислены деньги.
     * @param amount количество перечисляемых денег.
     * @return возвращает true, если операция выполнена успешано, false - если операция не выполнена.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null && dest != null && src.getBalance() >= 0) {
            dest.setBalance(dest.getBalance() + amount);
            src.setBalance(src.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}