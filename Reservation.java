import java.time.LocalDate;

public class Reservation {
  private LocalDate checkin;
  private LocalDate checkout;

  public Reservation(String reservationId, LocalDate checkin, LocalDate checkout) {
    this.checkin = checkin;
    this.checkout = checkout;
  }

  public LocalDate getCheckinDate() {
    return checkin;
  }

  public LocalDate getCheckoutDate() {
    return checkout;
  }
}
