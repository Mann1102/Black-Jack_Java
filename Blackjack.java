import java.util.Scanner;

public class Blackjack {

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();
        int card1=drawRandomCard();
        int card2=drawRandomCard();
        System.out.println("\n You get a \n"+cardString(card1)+"\n and a \n"+cardString(card2));
        int playerTotal= Math.min(card1,10)+Math.min(card2,10);
        System.out.println("Your total is: "+playerTotal);
        
        int card3=drawRandomCard();
        int card4=drawRandomCard();
        int dealerTotal=Math.min(card3,10)+Math.min(card4,10);
        System.out.println("The dealer shows \n"+cardString(card3)+"\nand has a card facing down \n"+faceDown());
        System.out.println("\nThe dealer's total is hidden");
        while(true){
            String response= hitOrStay();
            if(response.equalsIgnoreCase("stay")){
                break;
            }
            int newCard=drawRandomCard();
            playerTotal+=Math.min(newCard,10);
            System.out.println("\nYou get a\n"+cardString(newCard));
            System.out.println("Your new total is: "+playerTotal);
            if(playerTotal>21){
                System.out.println("Bust! Player losses.");
                System.exit(0);
            }
        }
        System.out.println("\nDealer's Turn.");
        System.out.println("\nThe dealer's cards are \n"+cardString(card3)+"\nand a \n"+cardString(card4));
        while(dealerTotal<17){
            int newCard2=drawRandomCard();
            dealerTotal+=Math.min(newCard2, 10);
            System.out.println("\nDealer gets a\n"+cardString(newCard2));
            System.out.println("Dealer's total is "+dealerTotal);
        }
        if(dealerTotal>21){
            System.out.println("Bust! Dealer losses.");
                System.exit(0);
        }
        if(playerTotal>dealerTotal){
            System.out.println("Player Wins!");
        }
        else if(playerTotal==21 && dealerTotal==21){
            System.out.println("Player Wins!");
        }
        else{
            System.out.println("Dealer Wins!");
        }
         scan.close();

    }
    public static int drawRandomCard(){
        double randomDigit=Math.random()*13;
        randomDigit++;
        int digit=(int)randomDigit;
        return digit;

    }

    public static String hitOrStay(){
        System.out.println("\nWould You like to Hit of Stay ?\n");
        String option=scan.nextLine();
        while(!(option.equalsIgnoreCase("Hit")||option.equalsIgnoreCase("Stay"))){
            System.out.println("Please enter 'Hit' or 'Stay'.");
        }
        return option;    
    }
    public static String cardString(int cardNumber){
        switch(cardNumber){
            case 1:
                 
                return  "   _____\n"+
                        "  |A    |\n"+ 
                        "  |     |\n"+
                        "  | ACE |\n"+
                        "  |     |\n"+
                        "  |____V|\n";
       
            case 2:
                return  "   _____\n"+              
                        "  |2    |\n"+ 
                        "  |  o  |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____Z|\n";
               
           case 3:
                return  "   _____\n" +
                        "  |3    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  |  o  |\n"+
                        "  |____E|\n";
    
            case 4:
                return  "   _____\n" +
                        "  |4    |\n"+
                        "  | o o |\n"+
                        "  |     |\n"+
                        "  | o o |\n"+
                        "  |____h|\n";
    
            case 5:
                return  "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";
    
            case 6:
                return  "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";
    
            case 7:
                return  "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";
       
            case 8:
                return  "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";
          
            case 9:
                return  "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";
    
            case 10:
                return  "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";
         
            case 11:
                return  "   _____\n" +
                        "  |J    |\n"+ 
                        "  |     |\n"+ 
                        "  |JOKER|\n"+ 
                        "  |     |\n"+ 
                        "  |____J|\n";
         
            case 12:
                return  "   _____\n" +
                        "  |Q    |\n"+ 
                        "  |     |\n"+ 
                        "  |QUEEN|\n"+ 
                        "  |     |\n"+ 
                        "  |____Q|\n";
           
            case 13: 
                return  "   _____\n" +
                        "  |K     |\n"+ 
                        "  |      |\n"+ 
                        "  | KING |\n"+ 
                        "  |      |\n"+ 
                        "  |_____K|\n";

            default: return "Not possible";}
                
    }

    
    public static String faceDown() {
        return
        "   _____\n"+
        "  |     |\n"+ 
        "  |  J  |\n"+
        "  | JJJ |\n"+
        "  |  J  |\n"+
        "  |_____|\n";
    }
    
    
    }

