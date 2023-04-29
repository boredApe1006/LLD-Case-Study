package atm1.state;

import atm1.ATM.ATM;

public class StateFactory {

    private StateFactory() {}

    public static State getState(ATMState atmState, ATM atm) {
        State state = null;
        if(atmState.equals(ATMState.READY)) {
            state = new ReadyState(atm);
        } else if(atmState.equals(ATMState.CARD_READING)) {
            state = new CardReadingState(atm);
        } else if(atmState.equals(ATMState.WITHDRAWAL_DETAILS_READING)) {
            state = new WithdrawalDetailsReadingState(atm);
        } /// baki states
        return state;
    }
}
