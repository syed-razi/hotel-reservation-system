import java.time.LocalDate;
import java.util.*;

public class Room {
  private int number;
  private Type type;
  private int price;
  private List<Reservation> reservations = new ArrayList<>();
  private List<Offer> offers = new ArrayList<>();

  public Room(int number, Type type, int price) {
    this.number = number;
    this.type = type;
    this.price = price;
  }

  public boolean isAvailable(LocalDate date) {
    for (Reservation reservation : reservations) {
      if ((date.isAfter(reservation.getCheckinDate()) || date.isEqual(reservation.getCheckinDate())) 
        && (date.isBefore(reservation.getCheckoutDate()) || date.isEqual(reservation.getCheckoutDate()))) {
          return false;
      }
    }
    return true;
  }

  public boolean isAvailable(LocalDate checkin, LocalDate checkout) {
    for (Reservation reservation : reservations) {
      if (reservation.getCheckoutDate().isBefore(checkin) || reservation.getCheckinDate().isAfter(checkout)) {
        return true;
      }
    }
    return false;
  }

  public void createReservation(LocalDate checkin, LocalDate checkout) {
    int totalPrice = calculateTotal(checkin, checkout);
    Reservation reservation = new Reservation(checkin, checkout, totalPrice);
    reservations.add(reservation);
  }

  public void updatePrice(int newPrice) {
    price = newPrice;
  }

  public void applyOffer(int offerPrice, LocalDate startDate, LocalDate endDate) {
    Offer offer = new Offer(offerPrice, startDate, endDate);
    offers.add(offer);
  }

  public int getRoomNumber() {
    return number;
  }

  public Type getRoomType() {
    return type;
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
