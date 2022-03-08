import java.util.HashMap;

public class Room {
  private int number;
  private Type type;
  private int price;
  private HashMap<Integer, Reservation> reservations;

  public Room(int number, Type type) {
    this.number = number;
    this.type = type;
  }
}
