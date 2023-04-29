package atm1.ATM;

import atm1.db.DBAccessor;
import atm1.state.State;
import atm1.state.StateFactory;

public class ATM {

    private final String machineId;
//    private ATMState state;
//    private final CardReadingState cardReadingState;

    private State state;


    public ATM(String machineId) {

        this.machineId = machineId;
     //   this.state = ATMState.READY;
     //   this.state = new ReadyState(this);
        this.state = StateFactory.getState(DBAccessor.getATMState(this.machineId) ,  this);
    }


    public int init() {
//        int transId = 0;
//        // logic to generate unique ID
//        if(state.equals(ATMState.CARD_READING))
//            throw new IllegalStateException("old txn in card reading, operation not allowed");
//        if(state.equals(ATMState.WITHDRAWAL_DETAILS_READING))
//            throw new IllegalStateException("old txn is reading with details, operation not allowed");
//        if(state.equals(ATMState.CASH_DISPENSING)) {
//            throw new IllegalStateException("old txn is dispensing cash, operation not allowed");
//        }
//        this.state = ATMState.CARD_READING;
//        int t = this.state.init();
//        this.state = new CardReadingState();
//        return t;
        return this.state.init();
    }
// s1 -- init() -- s2
// s2 -- init() -- s4 toh we should not write this.state = newCardReadingState() here bcz hme ni pta kha pe jana hai
    public boolean cancel(int transId) {
       return this.state.cancel(transId);
    }

    public boolean readCard(String cardType, long cardNum, int pin, String name) {
        return true;
    }

    public boolean readWithdrawalDetails(String cardType, long cardNum,
                                         int pin, String name,
                                         float amount, int transId) {
        return true;
    }

    public boolean dispenseCash(int transId) {}

    public void ejectCard() { }

    public void changeState(State newState) {
        this.state = newState;
        DBAccessor.updateATMState(this.getMachineId(), newState.getStateName());
    }

    public String getMachineId() {
        return machineId;
    }
}

