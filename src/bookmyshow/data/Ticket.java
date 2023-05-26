package bookmyshow.data;

import java.util.List;

public class Ticket {

    int id;
    List<ShowSeat> showSeats;
    int price;
    TicketStatus ticketStatus;

    User createdBy;

}
