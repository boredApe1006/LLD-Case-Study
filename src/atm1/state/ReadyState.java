package atm1.state;

import atm1.ATM.ATM;
import atm1.db.DBAccessor;
import atmmachine.card.CardDetails;

public class ReadyState implements State{

// we need atm in this class because state variable change krna hai mujhe atm ka
    // jb s1 -- init() -- s2 toh state change krne ke lie atm ka reference hona chahie
    private final ATM atm;

    public ReadyState(ATM atm) {

        this.atm = atm;
    }

    @Override
    public int init() {

        int transId = 0;
        transId = DBAccessor.createNewTransaction(this.atm.getMachineId());
        if(transId == 0)
            return new RuntimeException("Unable to start the transaction");

        this.atm.changeState(new CardReadingState(this.atm));
        return transId;
    }

    @Override
    public boolean cancel(int transId) {
        throw new IllegalStateException("No transaction in progress");
    }

    @Override
    public boolean readCard(CardDetails cardDetails) {
        throw new IllegalStateException("Currently I'm in ready state, can't read card");
    }

    @Override
    public boolean readWithdrawalDetails(CardDetails cardDetails, float amount, int transId) {
        throw new IllegalStateException("Currently I'm in ready state, can't read withdrawal details");
    }

    @Override
    public float dispenseCash(int transId) {
        throw new IllegalStateException("Currently I'm in ready state, can't dispense cash");
    }

    @Override
    public void ejectCard() {
        throw new IllegalStateException("Currently I'm in ready state, can't eject card");
    }

    @Override
    public ATMState getStateName() {
        return ATMState.READY;
    }
}
