import java.time.LocalDate;

public class Reservation {
  private LocalDate checkin;
  private LocalDate checkout;
  private int totalPrice;

  public Reservation(LocalDate checkin, LocalDate checkout, int totalPrice) {
    this.checkin = checkin;
    this.checkout = checkout;
    this.totalPrice = totalPrice;
  }

  public LocalDate getCheckinDate() {
    return checkin;
  }

  public LocalDate getCheckoutDate() {
    return checkout;
  }

  public int getTotalPrice() {
    return totalPrice;
  }
}
