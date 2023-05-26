package bookmyshow.data;

public class ShowSeat {

    public final Show show;
    public final Seat seat;

    public final ShowSeatState showSeatState;

    public ShowSeat(Show show, Seat seat, ShowSeatState showSeatState) {
        this.show = show;
        this.seat = seat;
        this.showSeatState = showSeatState;
    }
}
