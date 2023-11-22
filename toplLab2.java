import java.util.*;


public class toplLab2{//Noriel Achero | 3 BSCS 1

    public static Scanner scan = new Scanner(System.in);
    public static boolean ctrl = true;
    public static void main(String[] args){

        while(ctrl){

            System.out.print("Enter sentence: ");
            String sentence = scan.nextLine();

            System.out.println();
            System.out.print("Enter letter: ");
            char checker = scan.next().charAt(0);

            scan.nextLine();
            char orig = checker;

            checker = Character.toLowerCase(checker);
            
            sentence = sentence.toLowerCase();

            int counter = 0;
            
            for(int i = 0; i < sentence.length(); i++){
                
                if(checker == sentence.charAt(i)){
                    counter++;
                }
            }

            System.out.println();
            System.out.print("The letter '" + orig + "' occured " + counter + " time/s");

            System.out.println();
            System.out.print("Do you want to enter another input? [Yes/No] ");
            String restart = scan.nextLine();
            System.out.println();
        
            if(restart.toLowerCase().equals("no")){
                        System.out.println("Noriel Achero | 3 BSCS 1");
						System.exit(0);
            }
        }
    }
    
}
