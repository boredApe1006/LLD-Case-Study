package atm1.state;

import atmmachine.card.CardDetails;

public interface State {

    public int init();

    public boolean cancel(int transId);

    public boolean readCard(CardDetails cardDetails);

    public boolean readWithdrawalDetails(CardDetails cardDetails,
                                         float amount, int transId);

    public float dispenseCash(int transId);

    public void ejectCard();

    public ATMState getStateName();

}
