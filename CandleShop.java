/**
* @author  Anurag Dasari // 
* ITSC1212 - 001, Mazumder
* @version 1.0 // add .1 for each update
* @since   2021-02-22 // date last updated
* Project 3
* This application is a Calculator for calculating and displaying the number of candles, total burn time, cost per minute, total price and total discounted price
  with histogram that displays the quantity of each candles to help shopkeepers buy candle stock.
*/
import java.util.Scanner;
public class CandleShop {
    public static void main(String[] args){
        // ***************
        // Project 3
        // ***************
        Scanner scnr = new Scanner(System.in);                                        // new scanner for user input
        Candle[] candles = new Candle [3];                                            // Array for candles that includes 3 types
        System.out.println("Welcome! Please enter the required information to buy candles: "); //Print statement for welcoming the user
        for (int type = 1; type <= 3; type++) {                                       //For loop to get the information for each type from user
            //To get the name of the candle
            System.out.println("Please enter the name of the candle " + type + ": "); //Print statement for the user to  enter candle name
            String name = scnr.nextLine();                                            //Scanner to obtain candle name from user
            //To get the price of the candle
            System.out.println("Please enter the price of each candle: ");            //Print statement for the user to enter the price of each candle
            double price = scnr.nextDouble();                                          //Scanner to obtain candle price from user
            scnr.nextLine();
            //To get the burn time of the candle
            System.out.println("Please enter the burn time of the candle(hours): ");  //Print statement for the user to enter the burn time in hours
            int burnTime = scnr.nextInt();                                            //Scanner to obtain candle burn time from user
            scnr.nextLine();
            candles[type - 1] = new Candle (name, type, price, burnTime);              //Assign candle information for each type in array
        }

        System.out.println("How many candles you like to purchase of type1: ");       //Print statement for the user to enter the number of type1 candles to purchase
        int purchase1 = scnr.nextInt();                                               //Scanner to obtain the number from user entry
        System.out.println("How many candles you like to purchase of type2: ");       //Print statement for the user to enter the number of type2 candles to purchase
        int purchase2 = scnr.nextInt();                                               //Scanner to obtain the number from user entry
        System.out.println("How many candles you like to purchase of type3: ");       //Print statement for the user to enter the number of type3 candles to purchase
        int purchase3 = scnr.nextInt();                                               //Scanner to obtain the number from user entry

        //To calculate total price of candles
        double totalPrice = candles[0].getCost() * purchase1 + candles[1].getCost()* purchase2 + candles[2].getCost()*purchase3; //Sum of the total cost obtained from user

        //To calculate discounts
        double discount = 0;                                                        //Assign double
        if (totalPrice > 20 && totalPrice < 35)                                       //If statement for discounting 5% for price greater that 20 and less that 35
            discount = 5;                                                           //discount of 5%
            else if (totalPrice > 35 && totalPrice < 55)                              //else if statement for discounting 7% for price greater that 35 and less that 55
                discount = 7;                                                       //discount of 7%
            else if (totalPrice > 55 && totalPrice < 100)                             //else if statement for discounting 10% for price greater that 55 and less that 100
                discount = 10;                                                      //discount of 10%
            else if (totalPrice > 100)                                               //else if statement for discounting 20% for price greater that 100
                discount = 20;                                                      //discount of 20%
        double discountPrice = totalPrice - (totalPrice * (discount/100));             //Calculate total discounted price
        
        //To calculate the total burn time
        int burnTime = candles[0].getTime()*purchase1 + candles[1].getTime()*purchase2 + candles[2].getTime()*purchase3; //sum of all the candles time obtained from user
        //To calculate total cost-per-minute
        double costMinute = totalPrice/(burnTime*60);                                         //Total cost Per minute
        
        for (int i = 1; i <= 3; i++) {                                                       //For loop for repeating for all the candles

        }

        System.out.println(" ");                                                             //Print statement for space 
        System.out.println("Total price: $" + totalPrice);                                    //Print statement for displaying total cost
        System.out.println("Total price after discount: $" + discountPrice);                  //Print statement for displaying Discounted price
        System.out.println("Total burn time of all the candles in hours: " + burnTime);      //Print statement for displaying total burn time
        System.out.println("Cost Per Minute: $" + costMinute);                               //Print statement for displaying total cost per minute
        System.out.println(" ");                                                             //Print statement for space

        System.out.println("Histogram for number of candles of each type: ");                //Print statement for histogram heading

        System.out.println("Type 1: ");                                                      //Print statement for displaying type 1
        for( int x = 0; x < purchase1; x++){                                                 //For loop to print number of # for number of purchases for purchase 1
            System.out.print("#");                                                           //Print statement to display symbol #
        }System.out.println("");                                                             //Print statement for space
        System.out.println("Type 2: ");                                                      //Print statement for displaying type 2
        for( int x = 0; x < purchase2; x++){                                                 //For loop to print number of @ for number of purchases for purchase 2
            System.out.print("@");                                                           //Print statement to display symbol @
        } System.out.println("");                                                            //Print statement for space
        System.out.println("Type 3: ");                                                      //Print statement for displaying type 3
        for( int x = 0; x < purchase3; x++){                                                 //For loop to print number of + for number of purchases for purchase 4
            System.out.print("+");                                                           //Print statement to display symbol +
        }
        scnr.close();                                                                        //Closed scanner
}
}
