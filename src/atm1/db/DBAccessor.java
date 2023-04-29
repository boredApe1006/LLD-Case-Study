package atm1.db;


import atm1.state.ATMState;
import atmmachine.card.CardDetails;
import atmmachine.card.TransactionStatus;

public class DBAccessor {

    private DBAccessor() {}

    public static ATMState getATMState(String machineId) {
        // dummy code
        return ATMState.READY;
    }

    public static int createNewTransaction(String machineId) {
        return 1;
    }

    public static void updateATMState(String machineId, ATMState state) {

    }

    public static void persistCardDetails(CardDetails cardDetails, String machineId) {

    }

    public static void disapproveTransaction(String machineId) {

    }

    public static void cancelTransaction(int transId) {

    }

    public static void persistWithDetails(int transId, float amount, TransactionStatus transactionStatus) {

    }

    public static float markAsExec(int transId) {

    }
}
