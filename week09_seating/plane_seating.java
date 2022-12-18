import java.util.Scanner;

public class AirlineTickets {

    static class Passenger
    {
        int row, col;
        String seatingChoice;
        char taken;

        public Passenger()
        {
            taken = 'O';
        }
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        Passenger[][] seats = new Passenger[18][6];
        int passengers, choice;
        for(int i = 0; i < seats.length; i++)
            for(int j = 0; j < seats[i].length; j++)
                seats[i][j] = new Passenger();

        while(true)
        {
            showPlane(seats);
            System.out.println("Welcome, how many will be flying today (0 to exit): ");
            passengers = input.nextInt();
            if(passengers == 0)
            {
                System.out.println("Goodbye");
                break;
            }
            for(int i = 0; i < passengers; i++)
            {
                System.out.println("Passenger " + (i+1) + ": Here are your options:");
                System.out.println("1. Choose your seat");
                System.out.println("2. Give a preference");
                System.out.println("3. No choice/no preference");
                System.out.print("Choice: ");
                choice = input.nextInt();
                if(choice == 1){
                    if(!exactSeat(seats, input))
                        i = i-1;
                }
                else if(choice == 2){
                    if(!preferredSeat(seats, input))
                        i = i -1;
                }
                else if(choice == 3){
                    if(!noPreference(seats))
                        i = i-1;
                }
                else
                {
                    System.out.println("Sorry. Wrong choice. Returning to the menu");
                    i= i-1;
                    continue;
                }   
            }
        }
    }

    public static boolean exactSeat(Passenger[][] seats, Scanner input)
    {
        System.out.print("Give a row (between 1 and 18): ");
        int choice = input.nextInt();
        int x,y;
        if(choice > 0  && choice < 19)
            y = choice-1;
        else
        {
            System.out.println("Out of bounds, returning to menu");
            return false;
        }
        System.out.print("Give a column (between 1 and 6): ");
        choice = input.nextInt();
        if(choice > 0  && choice < 7)
            x = choice-1;
        else {
            System.out.println("Out of bounds, returning to menu");
            return false;
        }
        if(seats[y][x].taken == 'O')
        {
            seats[y][x].taken = 'X';
            seats[y][x].row = y;
            seats[y][x].col = x;
            seats[y][x].seatingChoice = "None";
        }
        else
        {
            System.out.println("Sorry. That seat is not available. Going back to menu");
            return false;
        }
        return true;
    }

    public static boolean preferredSeat(Passenger[][] seats, Scanner input)
    {
        System.out.print("Please choose (window, aisle, middle), followed by a section number (1-3): ");
        String seatingPreference = input.next();
        int section = input.nextInt();
        if(section < 1 || section > 3)
        {
            System.out.println("That section is not available. Going back to menu");
            return false;
        }
        if(seatingPreference.toLowerCase().compareTo("window") == 0)
        {
            if(section == 1)
                for(int j = 0; j < 7; j++){
                    if(seats[j][0].taken == 'O'){
                        seats[j][0].taken = 'X';
                        seats[j][0].row = j;
                        seats[j][0].col = 0;
                        seats[j][0].seatingChoice = "Window";
                        break;
                    }
                    else if(seats[j][5].taken == 'O'){
                        seats[j][5].taken = 'X';
                        seats[j][5].row = j;
                        seats[j][5].col = 5;
                        seats[j][5].seatingChoice = "Window";
                        break;
                    }
                }
            else if(section == 2)
                for(int j = 7; j < 12; j++){
                    if(seats[j][0].taken == 'O'){
                        seats[j][0].taken = 'X';
                        seats[j][0].row = j;
                        seats[j][0].col = 0;
                        seats[j][0].seatingChoice = "Window";
                        break;
                    }
                    else if(seats[j][5].taken == 'O'){
                        seats[j][5].taken = 'X';
                        seats[j][5].row = j;
                        seats[j][5].col = 5;
                        seats[j][5].seatingChoice = "Window";
                        break;
                    }
                }
            else if(section == 3)
                for(int j = 12; j < 18; j++){
                    if(seats[j][0].taken == 'O'){
                        seats[j][0].taken = 'X';
                        seats[j][0].row = j;
                        seats[j][0].col = 0;
                        seats[j][0].seatingChoice = "Window";
                        break;
                    }
                    else if(seats[j][5].taken == 'O'){
                        seats[j][5].taken = 'X';
                        seats[j][5].row = j;
                        seats[j][5].col = 5;
                        seats[j][5].seatingChoice = "Window";
                        break;
                    }
                }
        }
        else if(seatingPreference.toLowerCase().compareTo("aisle") == 0)
        {
            if(section == 1)
                for(int j = 0; j < 7; j++){
                    if(seats[j][2].taken == 'O'){
                        seats[j][2].taken = 'X';
                        seats[j][2].row = j;
                        seats[j][2].col = 0;
                        seats[j][2].seatingChoice = "Aisle";
                        break;
                    }
                    else if(seats[j][3].taken == 'O'){
                        seats[j][3].taken = 'X';
                        seats[j][3].row = j;
                        seats[j][3].col = 5;
                        seats[j][3].seatingChoice = "Aisle";
                        break;
                    }
                }
            else if(section == 2)
                for(int j = 7; j < 12; j++){
                    if(seats[j][2].taken == 'O'){
                        seats[j][2].taken = 'X';
                        seats[j][2].row = j;
                        seats[j][2].col = 0;
                        seats[j][2].seatingChoice = "Aisle";
                        break;
                    }
                    else if(seats[j][3].taken == 'O'){
                        seats[j][3].taken = 'X';
                        seats[j][3].row = j;
                        seats[j][3].col = 5;
                        seats[j][3].seatingChoice = "Aisle";
                        break;
                    }
                }
            else if(section == 3)
                for(int j = 12; j < 18; j++){
                    if(seats[j][2].taken == 'O'){
                        seats[j][2].taken = 'X';
                        seats[j][2].row = j;
                        seats[j][2].col = 0;
                        seats[j][2].seatingChoice = "Aisle";
                        break;
                    }
                    else if(seats[j][3].taken == 'O'){
                        seats[j][3].taken = 'X';
                        seats[j][3].row = j;
                        seats[j][3].col = 5;
                        seats[j][3].seatingChoice = "Aisle";
                        break;
                    }
                }
        }
        else if(seatingPreference.toLowerCase().compareTo("middle") == 0)
        {
            if(section == 1)
                for(int j = 0; j < 7; j++){
                    if(seats[j][1].taken == 'O'){
                        seats[j][1].taken = 'X';
                        seats[j][1].row = j;
                        seats[j][1].col = 0;
                        seats[j][1].seatingChoice = "Middle";
                        break;
                    }
                    else if(seats[j][4].taken == 'O'){
                        seats[j][4].taken = 'X';
                        seats[j][4].row = j;
                        seats[j][4].col = 5;
                        seats[j][4].seatingChoice = "Middle";
                        break;
                    }
                }
            else if(section == 2)
                for(int j = 7; j < 12; j++){
                    if(seats[j][1].taken == 'O'){
                        seats[j][1].taken = 'X';
                        seats[j][1].row = j;
                        seats[j][1].col = 0;
                        seats[j][1].seatingChoice = "Middle";
                        break;
                    }
                    else if(seats[j][4].taken == 'O'){
                        seats[j][4].taken = 'X';
                        seats[j][4].row = j;
                        seats[j][4].col = 5;
                        seats[j][4].seatingChoice = "Middle";
                        break;
                    }
                }
            else if(section == 3)
                for(int j = 12; j < 18; j++){
                    if(seats[j][1].taken == 'O'){
                        seats[j][1].taken = 'X';
                        seats[j][1].row = j;
                        seats[j][1].col = 0;
                        seats[j][1].seatingChoice = "Middle";
                        break;
                    }
                    else if(seats[j][4].taken == 'O'){
                        seats[j][4].taken = 'X';
                        seats[j][4].row = j;
                        seats[j][4].col = 5;
                        seats[j][4].seatingChoice = "Middle";
                        break;
                    }
                }
        }
        else
        {
            System.out.println("Not a seat type, going back to menu");
            return false;
        }
        return true;
    }

    public static boolean noPreference(Passenger[][] seats)
    {
        for(int j = 0; j < seats.length; j++)
            for(int k = 0; k < seats[j].length; k++){
                if(seats[j][k].taken == 'O')
                {
                    seats[j][k].taken = 'X';
                    seats[j][k].row = j;
                    seats[j][k].col = k;
                    seats[j][k].seatingChoice = "None";
                    return true;
                }
            }
        return false;
    }

    public static void showPlane(Passenger[][] seats)
    {
        System.out.println("     ------      ");
        System.out.println("/              \\");
        System.out.println("//             \\\\");
        for(int i = 0; i < seats.length; i++)
        {
            System.out.println("|" + seats[i][0].taken + seats[i][1].taken + seats[i][2].taken + "         " + seats[i][3].taken + seats[i][4].taken + seats[i][5].taken + "|");
            if(i == 6 || i == 11)
                System.out.println();
        }
    }
}
