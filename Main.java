import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Hotel hotel = new Hotel();

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d/yyyy");
    Scanner sc = new Scanner(System.in);
    boolean end = false;
    while (!end) {
      System.out.println("Select input: 1 -> Check room availability, 2 -> Change price of rooms, 3 -> Quit");
      int selection = sc.nextInt();

      switch(selection) {
        case 1:
          // get room type from user
          System.out.println("Select room type: 1 -> SINGLE, 2 -> DOUBLE, 3 -> QUEEN, 4 -> KING");
          int roomType = sc.nextInt();

          System.out.println("Select input: 1 -> Single date, 2 -> Range of dates");
          selection = sc.nextInt();
          sc.nextLine();
          switch(selection) {
            case 1:
              // get date from user
              System.out.println("Enter date in the format m/d/yyyy");
              String dateInput = sc.nextLine();
              LocalDate date = LocalDate.parse(dateInput, dtf);

              switch (roomType) {
                case 1:
                  if (hotel.isRoomTypeAvailable(Type.SINGLE, date)) {
                    System.out.println("A single room is available on " + date.toString());
                  } else {
                    System.out.println("There are no single rooms available for " + date.toString());
                  }
                  break;
                case 2:
                  if (hotel.isRoomTypeAvailable(Type.DOUBLE, date)) {
                    System.out.println("A double room is available on " + date.toString());
                  } else {
                    System.out.println("There are no double rooms available for " + date.toString());
                  }
                  break;
                case 3:
                  if (hotel.isRoomTypeAvailable(Type.QUEEN, date)) {
                    System.out.println("A queen room is available on " + date.toString());
                  } else {
                    System.out.println("There are no queen rooms available for " + date.toString());
                  }
                  break;
                case 4:
                  if (hotel.isRoomTypeAvailable(Type.KING, date)) {
                    System.out.println("A king room is available on " + date.toString());
                  } else {
                    System.out.println("There are no king rooms available for " + date.toString());
                  }
                  break;
              }
              break;
            case 2:
              // get start and end date from user
              System.out.println("Enter the start date in the format m/d/yyyy");
              String startDateInput = sc.nextLine();
              LocalDate startDate = LocalDate.parse(startDateInput, dtf);

              System.out.println("Enter the end date in the format m/d/yyyy");
              String endDateInput = sc.nextLine();
              LocalDate endDate = LocalDate.parse(endDateInput, dtf);

              switch (roomType) {
                case 1:
                  if (hotel.isRoomTypeAvailable(Type.SINGLE, startDate, endDate)) {
                    System.out.println("A single room is available between " + startDate.toString() + " and " + endDate.toString());
                  } else {
                    System.out.println("There are no single rooms available between " + startDate.toString() + " and " + endDate.toString());
                  }
                  break;
                case 2:
                  if (hotel.isRoomTypeAvailable(Type.DOUBLE, startDate, endDate)) {
                    System.out.println("A double room is available between " + startDate.toString() + " and " + endDate.toString());
                  } else {
                    System.out.println("There are no double rooms available between " + startDate.toString() + " and " + endDate.toString());
                  }
                  break;
                case 3:
                  if (hotel.isRoomTypeAvailable(Type.QUEEN, startDate, endDate)) {
                    System.out.println("A queen room is available between " + startDate.toString() + " and " + endDate.toString());
                  } else {
                    System.out.println("There are no queen rooms available between " + startDate.toString() + " and " + endDate.toString());
                  }
                  break;
                case 4:
                  if (hotel.isRoomTypeAvailable(Type.KING, startDate, endDate)) {
                    System.out.println("A king room is available between " + startDate.toString() + " and " + endDate.toString());
                  } else {
                    System.out.println("There are no king rooms available between " + startDate.toString() + " and " + endDate.toString());
                  }
                  break;
              }
              break;
          }
          break;
        case 2:
          System.out.println("Enter start room number between 0 - 11");
          int roomStart = sc.nextInt();
          System.out.println("Enter end room number between 0 - 11 and after start number");
          int roomEnd = sc.nextInt();
          System.out.println("Enter new price");
          int newPrice = sc.nextInt();
          System.out.println("Is this a special offer or permanent price change? 1 -> offer, 2 -> permanent");
          selection = sc.nextInt();
          switch(selection) {
            case 1:
              System.out.println("Enter the start date of the offer in the format m/d/yyyy");
              String startDateInput = sc.nextLine();
              LocalDate startDate = LocalDate.parse(startDateInput, dtf);

              System.out.println("Enter the end date of the offer in the format m/d/yyyy");
              String endDateInput = sc.nextLine();
              LocalDate endDate = LocalDate.parse(endDateInput, dtf);

              hotel.applyOfferToRooms(newPrice, roomStart, roomEnd, startDate, endDate);
              System.out.println("Offer applied to rooms " + roomStart + " to " + roomEnd + " from " + startDateInput + " to " + endDateInput);
              break;
            case 2:
              hotel.changePriceOfRooms(newPrice, roomStart, roomEnd);
              System.out.println("Price changed for rooms " + roomStart + " to " + roomEnd + " to " + newPrice);
              break;
          }
          break;
        case 3:
          end = true;
          sc.close();
          break;
      }
      System.out.println("Select input: Main menu -> 1, Quit -> 2");
      selection = sc.nextInt();
      if(selection == 1) {
        continue;
      } else {
        break;
      }
    }
  }

}