package ru.job4j.bank;

import java.util.*;

/**
 * Класс является простейшим банковским сервисом, который позволяет:
 * 1. Регистрировать пользователя.
 * 2. Удалять пользователя.
 * 3. Добавлять пользователю банковский счёт.
 * 4. Переводить деньги с одного банковского счёта на другой счёт.
 *
 * @author RUSLAN ZUBAIROV
 * @version 3.0
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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            if (!users.get(user.get()).contains(account)) {
                users.get(user.get()).add(account);
            }
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта.
     * @param passport номер паспорта.
     * @return возвращает пользователя, если он есть в списке, иначе возвращает пустой Optional-объект.
     */
    public Optional<User> findByPassport(String passport) {
        return users.keySet().stream()
                .filter(s -> s.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * Метод позволяет найти счёт пользователя по номеру паспорта и реквизитам.
     * @param passport номер паспорта пользователя.
     * @param requisite реквизиты пользователя.
     * @return возвращает счёт пользователя, если он есть в списке, иначе возвращает пустой Optional-объект.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        return user.flatMap(u -> users.get(u).stream()
                .filter(s -> s.getRequisite().equals(requisite))
                .findFirst());
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
        Optional<Account> src = findByRequisite(srcPassport, srcRequisite);
        Optional<Account> dest = findByRequisite(destPassport, destRequisite);
        if (src.isPresent() && dest.isPresent() && src.get().getBalance() >= 0) {
            dest.get().setBalance(dest.get().getBalance() + amount);
            src.get().setBalance(src.get().getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}