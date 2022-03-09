import java.time.LocalDate;

public class Offer {
  private int offerPrice;
  private LocalDate startDate;
  private LocalDate endDate;

  public Offer(int offerPrice, LocalDate startDate, LocalDate endDate) {
    this.offerPrice = offerPrice;
    this.startDate = startDate;
    this.endDate = endDate;
  }
  
  public int getOfferPrice() {
    return offerPrice;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

}
