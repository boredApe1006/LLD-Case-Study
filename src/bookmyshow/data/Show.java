package bookmyshow.data;

import java.util.List;

public class Show {

    public final int id;
    public final String movie;
    public final String startTime;

    public final List<ShowSeat> showSeats;

    public Show(int id, String movie, String startTime, List<ShowSeat> showSeats) {
        this.id = id;
        this.movie = movie;
        this.startTime = startTime;
        this.showSeats = showSeats;
    }

    public int getId() {
        return id;
    }

    public String getMovie() {
        return movie;
    }

    public String getStartTime() {
        return startTime;
    }

    public List<ShowSeat> getShowSeats() {
        return showSeats;
    }
}
