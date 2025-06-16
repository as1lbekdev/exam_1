package service;

import model.Debt;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DebtService {
    private List<Debt> debts=new ArrayList<>();


    public void addDebt(UUID userId, UUID id, double amount) {
        for (Debt debt : debts) {
            if (debt != null) {
                if (debt.getUserId().equals(userId)) {
                    debt.setAmount(debt.getAmount() + amount);
                    return;
                }
            }
        }
        Debt debt = new Debt(userId, amount);
        debts.add(debt);
    }

    public Debt[] currentUserDebts(UUID userId) {
        List<Debt> userDebts = new ArrayList<>();

        for (Debt debt : debts) {
            if (debt.getUserId().equals(userId)) {
                userDebts.add(debt);
            }
        }

        return userDebts.toArray(new Debt[0]);
    }
}
