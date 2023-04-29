package atm1.state;

import atm1.ATM.ATM;
import atm1.db.DBAccessor;
import atmmachine.card.CardDetails;
import atmmachine.card.CardManagerFactory;

public class CardReadingState implements State{

    private final ATM atm;

    public CardReadingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public int init() {
        return 0;
    }

    @Override
    public boolean cancel(int transId) {

        DBAccessor.cancelTransaction(transId);
        this.atm.changeState(new ReadyState(this.atm));
        return true;
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
       boolean result = CardManagerFactory.getCardManager(cardDetails.getCardType()).
                validateCard(cardDetails);
        DBAccessor.persistCardDetails(cardDetails, this.atm.getMachineId());
        if(result) {
            this.atm.changeState(new WithdrawalDetailsReadingState(this.atm));
        } else {
            DBAccessor.disapproveTransaction(this.atm.getMachineId());
            this.atm.changeState(new ReadyState(this.atm));
        }
        return false;
    }

    @Override
    public boolean readWithdrawalDetails(CardDetails cardDetails, float amount, int transId) {
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
