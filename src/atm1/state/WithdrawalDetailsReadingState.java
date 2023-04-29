package atm1.state;

import atm1.ATM.ATM;
import atm1.db.DBAccessor;
import atmmachine.card.CardDetails;
import atmmachine.card.CardManagerFactory;
import atmmachine.card.TransactionStatus;

public class WithdrawalDetailsReadingState implements State{

    private final ATM atm;

    public WithdrawalDetailsReadingState(ATM atm) {
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
        boolean res = CardManagerFactory.getCardManager(cardDetails.getCardType())
                .validateWithdrawal(amount,transId);
        if (res) {
            this.atm.changeState(new CashDispensingState(this.atm));
            DBAccessor.persistWithDetails(transId,amount, TransactionStatus.APPROVED);
        } else {
            this.atm.changeState(new CardEjectingState(this.atm));
            DBAccessor.persistWithDetails(transId,amount, TransactionStatus.NOT_APPROVED);
        }
        return false;
    }

    @Override
    public float dispenseCash(int transId) {
        return 0;
    }

    @Override
    public void ejectCard() {

    }

    @Override
    public ATMState getStateName() {
        return null;
    }
}
