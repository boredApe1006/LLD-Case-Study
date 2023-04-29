package atm1.state;

import atm1.ATM.ATM;
import atm1.db.DBAccessor;
import atmmachine.card.CardDetails;
import atmmachine.card.CardManagerFactory;
import atmmachine.card.CardType;

public class CashDispensingState implements State{
    private final ATM atm;

    public CashDispensingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int init() {
        return 0;
    }

    @Override
    public boolean cancel(int transId) {
        DBAccessor.cancelTransaction(transId);
        this.atm.changeState(new CardEjectingState(this.atm));
        return true;
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        return false;
    }

    @Override
    public boolean readWithdrawalDetails(CardDetails cardDetails, float amount, int transId) {
        return false;
    }

    @Override
    public float dispenseCash(int transId) {
        // we will write a logic in db to figure out cardDetails type from transId
        CardType cardType = null;
        CardManagerFactory.getCardManager(cardType).
                executeWithdrawal(transId);
        this.atm.changeState(new CardEjectingState(this.atm));
        return DBAccessor.markAsExec(transId);

    }

    @Override
    public void ejectCard() {

    }

    @Override
    public ATMState getStateName() {
        return null;
    }
}
