import java.time.LocalDate;
import java.util.*;

public class Hotel {
  private Room[] rooms = new Room[12];

  public Hotel() {
    Type type = Type.SINGLE;
    for (int i = 0; i < 12; i++) {
      if (i >= 3 && i < 6) {
        type = Type.DOUBLE;
      } else if (i >= 6 && i < 9) {
        type = Type.QUEEN;
      } else if (i >= 9 && i < 12) {
        type = Type.KING;
      }
      Room room = new Room(i, type);
      rooms[i] = room;
    }
  }

  public void createReservation(Type type, LocalDate checkin, LocalDate checkout) {
    switch (type) {
      case SINGLE:
        for (int i = 0; i < 3; i++) {
          Room room = rooms[i];
          if (room.isAvailable(checkin, checkout)) {
            room.createReservation(checkin, checkout);
            break;
          }
        }
        System.out.println("No single rooms available.");
        break;
      case DOUBLE:
        for (int i = 3; i < 6; i++) {
          Room room = rooms[i];
          if (room.isAvailable(checkin, checkout)) {
            room.createReservation(checkin, checkout);
            break;
          }
        }
        System.out.println("No double rooms available.");
        break;
      case QUEEN:
        for (int i = 6; i < 9; i++) {
          Room room = rooms[i];
          if (room.isAvailable(checkin, checkout)) {
            room.createReservation(checkin, checkout);
            break;
          }
        }
        System.out.println("No queen rooms available.");
        break;
      case KING:
        for (int i = 9; i < 12; i++) {
          Room room = rooms[i];
          if (room.isAvailable(checkin, checkout)) {
            room.createReservation(checkin, checkout);
            break;
          }
        }
        System.out.println("No king rooms available.");
        break;
    }
  }

  public boolean isRoomTypeAvailable(Type type, LocalDate date) {
    switch (type) {
      case SINGLE:
        for (int i = 0; i < 3; i++) {
          Room room = rooms[i];
          if (room.isAvailable(date)) {
            return true;
          }
        }
        System.out.println("No single rooms available on " + date.toString());
        return false;
      case DOUBLE:
        for (int i = 3; i < 6; i++) {
          Room room = rooms[i];
          if (room.isAvailable(date)) {
            return true;
          }
        }
        System.out.println("No double rooms available on " + date.toString());
        return false;
      case QUEEN:
        for (int i = 6; i < 9; i++) {
          Room room = rooms[i];
          if (room.isAvailable(date)) {
            return true;
          }
        }
        System.out.println("No queen rooms available on " + date.toString());
        return false;
      case KING:
        for (int i = 9; i < 12; i++) {
          Room room = rooms[i];
          if (room.isAvailable(date)) {
            return true;
          }
        }
        System.out.println("No king rooms available on " + date.toString());
        return false;
      default:
        return false;
    }
  }
}