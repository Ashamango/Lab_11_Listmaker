import java.util.ArrayList; // import java.util.ArrayList
import java.util.Scanner; // import java.util.Scanner
public class ListMaker { // class ListMaker
    static ArrayList<String> list = new ArrayList<>(); // the list array
    public static void main(String[] args) { // main
        Scanner console = new Scanner(System.in); // Scanner console = new Scanner(System.in)
        Scanner in = new Scanner(System.in); // Scanner in = new Scanner(System.in)

        final String menu = "A - Add D - Delete P - Print Q - Quit"; // menu choices of add delete print or quit
        boolean done = false; // boolean done = false repeats loop until break
        String item = ""; // String item = "" item needed to add
        String cmd = ""; // String cmd = "" prints out what menu choice the user chose
        boolean answer = false; // boolean answer = false y or n answer loops until y
        int deleteItem; // num deleteItem item to delete
        int deleteItem2; // num deleteItem2 subtract 1 to convert to index

        do { // do
            do { // do
                // display the list
                displayList(); // displayList();
                // display menu
                // get the menu choice
                cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]"); // cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]")
                cmd = cmd.toUpperCase(); // cmd = cmd.toUpperCase()

                // execute the menu choice
                switch (cmd) { // switch (cmd)
                    case "A": // if A is chosen
                        // prompt the user for item to add to list
                        item = SafeInput.getNonZeroLenString(in, "Add an item to the list"); // item to add item = SafeInput.getNonZeroLenString(in, "Add an item to the list")
                        // add item
                        list.add(item); // list.add(item) adds item
                        break; // break
                    case "D": // if d is chosen
                        // prompt the user for the number of item to delete
                        deleteItem = SafeInput.getRangedInt(in, "Enter which number of the item to delete", 1, list.size()); // deleteItem = SafeInput.getRangedInt(in, "Enter which number of the item to delete", 1, list.size())
                        // translate item to index by subtracting one
                        deleteItem2 = deleteItem - 1; // deleteItem2 = deleteItem - 1 translates to index
                        // remove item from list
                        list.set(deleteItem2, ""); // list.set(deleteItem2, "") replaces item with nothing; removes
                        break; // break
                    case "P": // if p is chosen
                        System.out.println("This is your current list: ");
                        break; // break, any ways shows the display
                    case "Q": // if q is chosen
                        answer = SafeInput.getYNConfirm(in, "Are you sure you want to quit?"); // answer = SafeInput.getYNConfirm(in, "Are you sure you want to quit?")
                        if (!answer) // if !answer then
                            System.exit(0); // exit the whole loop
                        break; // break
                } // end of switch
                System.out.println("The cmd is " + cmd); // output "The cmd is " + cmd
            } while(answer); // while answer is true repeat

        } while(!done); // while done is false repeat
    } // return

    private static void displayList() // displayList Method
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"); // output ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ top border
        if(list.size() != 0) // if list size is not equal to zero then
        {
            for (int i = 0; i < list.size(); i++) // for (int i = 0; i < list.size(); i++) makes space in the center for the list
            {
                System.out.printf("%3d%35s", i + 1,  list.get(i)); // output "%3d%35s", i + 1,  list.get(i)
                System.out.println("\n"); // output new line
            } // end for

        }
        else // else
        {
            System.out.println("+++                        List is empty                       +++"); // output +++                        List is empty                       +++
        }
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++"); // ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ bottom border

    }
} // end class