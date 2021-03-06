import java.time.LocalDate;

public class Hotel {
  private Room[] rooms = new Room[12];

  public Hotel() {
    Type type = Type.SINGLE;
    int price = 100;
    for (int i = 0; i < 12; i++) {
      if (i >= 3 && i < 6) {
        type = Type.DOUBLE;
        price = 200;
      } else if (i >= 6 && i < 9) {
        type = Type.QUEEN;
        price = 300;
      } else if (i >= 9 && i < 12) {
        type = Type.KING;
        price = 400;
      }
      Room room = new Room(i, type, price);
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
        break;
      case DOUBLE:
        for (int i = 3; i < 6; i++) {
          Room room = rooms[i];
          if (room.isAvailable(checkin, checkout)) {
            room.createReservation(checkin, checkout);
            break;
          }
        }
        break;
      case QUEEN:
        for (int i = 6; i < 9; i++) {
          Room room = rooms[i];
          if (room.isAvailable(checkin, checkout)) {
            room.createReservation(checkin, checkout);
            break;
          }
        }
        break;
      case KING:
        for (int i = 9; i < 12; i++) {
          Room room = rooms[i];
          if (room.isAvailable(checkin, checkout)) {
            room.createReservation(checkin, checkout);
            break;
          }
        }
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
        return false;
      case DOUBLE:
        for (int i = 3; i < 6; i++) {
          Room room = rooms[i];
          if (room.isAvailable(date)) {
            return true;
          }
        }
        return false;
      case QUEEN:
        for (int i = 6; i < 9; i++) {
          Room room = rooms[i];
          if (room.isAvailable(date)) {
            return true;
          }
        }
        return false;
      case KING:
        for (int i = 9; i < 12; i++) {
          Room room = rooms[i];
          if (room.isAvailable(date)) {
            return true;
          }
        }
        return false;
      default:
        return false;
    }
  }

  public boolean isRoomTypeAvailable(Type type, LocalDate startDate, LocalDate endDate) {
    switch (type) {
      case SINGLE:
        for (int i = 0; i < 3; i++) {
          Room room = rooms[i];
          if (room.isAvailable(startDate, endDate)) {
            return true;
          }
        }
        return false;
      case DOUBLE:
        for (int i = 3; i < 6; i++) {
          Room room = rooms[i];
          if (room.isAvailable(startDate, endDate)) {
            return true;
          }
        }
        return false;
      case QUEEN:
        for (int i = 6; i < 9; i++) {
          Room room = rooms[i];
          if (room.isAvailable(startDate, endDate)) {
            return true;
          }
        }
        return false;
      case KING:
        for (int i = 9; i < 12; i++) {
          Room room = rooms[i];
          if (room.isAvailable(startDate, endDate)) {
            return true;
          }
        }
        return false;
      default:
        return false;
    }
  }

  public void changePriceOfRooms(int newPrice, int roomStart, int roomEnd) {
    for(int i = roomStart; i <= roomEnd; i++) {
      rooms[i].updatePrice(newPrice);
    }
  }

  public void applyOfferToRooms(int offerPrice, int roomStart, int roomEnd, LocalDate startDate, LocalDate endDate) {
    for(int i = roomStart; i <= roomEnd; i++) {
      rooms[i].applyOffer(offerPrice, startDate, endDate);
    }
  }

  public Room[] getRooms() {
    return rooms;
  }
}