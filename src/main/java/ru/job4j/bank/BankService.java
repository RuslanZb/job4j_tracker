package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            if (users.get(user).isEmpty()) {
                users.get(user).add(account);
            } else {
                for (Account value : users.get(user)) {
                    if (!value.getRequisite().contains((account.getRequisite()))) {
                        users.get(user).add(account);
                        break;
                    }
                }
            }
        }
    }


    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (passport.equals(user.getPassport())) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if ((account.getRequisite()).contains(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account src = findByRequisite(srcPassport, srcRequisite);
        Account dest = findByRequisite(destPassport, destRequisite);
        if (src != null || dest != null) {
            findByRequisite(destPassport, destRequisite).setBalance(dest.getBalance() + amount);
            findByRequisite(srcPassport, srcRequisite).setBalance(src.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }
}