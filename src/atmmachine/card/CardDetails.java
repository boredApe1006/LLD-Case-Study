package atmmachine.card;

public class CardDetails {

    private final CardType cardType;
    private final long cardNum;
    private final int pin;
    private final String name;

    public CardDetails(CardType cardType, long cardNum, int pin, String name) {
        this.cardType = cardType;
        this.cardNum = cardNum;
        this.pin = pin;
        this.name = name;
    }

    public CardType getCardType() {
        return cardType;
    }

    public long getCardNum() {
        return cardNum;
    }

    public int getPin() {
        return pin;
    }

    public String getName() {
        return name;
    }
}
