import java.time.LocalDate;
import java.util.*;

public class Room {
  private int number;
  private Type type;
  private int price;
  private HashMap<String, Reservation> reservations = new HashMap<>();

  public Room(int number, Type type) {
    this.number = number;
    this.type = type;
  }

  public boolean isAvailable(LocalDate date) {
    for(String reservationId : reservations.keySet()) {
      Reservation reservation = reservations.get(reservationId);
      if(reservation.getCheckoutDate().isBefore(date) || reservation.getCheckinDate().isAfter(checkout)) {
        return true;
      }
    }
    return false;
  }

  public boolean isAvailable(LocalDate checkin, LocalDate checkout) {
    for(String reservationId : reservations.keySet()) {
      Reservation reservation = reservations.get(reservationId);
      if(reservation.getCheckoutDate().isBefore(checkin) || reservation.getCheckinDate().isAfter(checkout)) {
        return true;
      }
    }
    return false;
  }

  public void createReservation(LocalDate checkin, LocalDate checkout) {
    String reservationId = Integer.toString(number) + checkin.toString() + checkout.toString();
    Reservation reservation = new Reservation(reservationId, checkin, checkout);
    reservations.put(reservationId, reservation);
  }
}
