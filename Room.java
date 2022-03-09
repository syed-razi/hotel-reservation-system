import java.time.LocalDate;
import java.util.*;

public class Room {
  private int number;
  private Type type;
  private int price;
  private HashMap<String, Reservation> reservations = new HashMap<>();
  private List<Offer> offers = new ArrayList<>();

  public Room(int number, Type type, int price) {
    this.number = number;
    this.type = type;
    this.price = price;
  }

  public boolean isAvailable(LocalDate date) {
    for (String reservationId : reservations.keySet()) {
      Reservation reservation = reservations.get(reservationId);
      if (reservation.getCheckoutDate().isBefore(date) || reservation.getCheckinDate().isAfter(checkout)) {
        return true;
      }
    }
    return false;
  }

  public boolean isAvailable(LocalDate checkin, LocalDate checkout) {
    for (String reservationId : reservations.keySet()) {
      Reservation reservation = reservations.get(reservationId);
      if (reservation.getCheckoutDate().isBefore(checkin) || reservation.getCheckinDate().isAfter(checkout)) {
        return true;
      }
    }
    return false;
  }

  public void createReservation(LocalDate checkin, LocalDate checkout) {
    String reservationId = Integer.toString(number) + checkin.toString() + checkout.toString();
    int totalPrice = calculateTotal(checkin, checkout);
    Reservation reservation = new Reservation(checkin, checkout, totalPrice);
    reservations.put(reservationId, reservation);
  }

  public void updatePrice(int newPrice) {
    price = newPrice;
  }

  public void applyOffer(int offerPrice, LocalDate startDate, LocalDate endDate) {
    Offer offer = new Offer(offerPrice, startDate, endDate);
    offers.add(offer);
  }

  private int calculateTotal(LocalDate checkin, LocalDate checkout) {
    int total = 0;
    for (LocalDate date = checkin; date.isEqual(checkout); date = date.plusDays(1)) {
      int offerPrice = getOfferPrice(date);
      total += offerPrice;
    }

    return total;
  }

  private int getOfferPrice(LocalDate date) {
    for (Offer offer : offers) {
      LocalDate offerStart = offer.getStartDate();
      LocalDate offerEnd = offer.getEndDate();
      if ((date.isAfter(offerStart) || date.isEqual(offerStart))
          && (date.isBefore(offerEnd) || date.isEqual(offerEnd))) {
            return offer.getOfferPrice();
      }
    }
    return price;
  }
}
