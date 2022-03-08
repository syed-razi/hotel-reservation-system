import java.util.*;

public class Hotel {
  HashMap<Integer, Room> rooms = new HashMap<>();
  
  public Hotel() {
    Type type = Type.SINGLE;
    for(int i = 0; i < 12; i++) {
      if(i >= 3 && i < 6) {
        type = Type.DOUBLE;
      } else if(i >= 6 && i < 9) {
        type = Type.QUEEN;
      } else if(i >= 9 && i < 12) {
        type = Type.KING;
      }
      Room room = new Room(i, type);
      rooms.put(i, room);
    }
  }
}