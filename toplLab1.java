import java.util.*;

public class toplLab1 { // Noriel Achero | 3 BSCS 1 | Theory of Programming Languages

    public static boolean ctrl = true;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        while(ctrl){
            System.out.print("Enter word/phrase: ");
            String input = sc.nextLine();

            String removed = input.replaceAll("[^a-zA-Z0-9]", "");

            String rev = "";
            for(int i = removed.length() - 1; i >= 0 ; i--){
                rev = rev + removed.charAt(i);
            }

            if(removed.toLowerCase().equals(rev.toLowerCase())){
                System.out.println(input + " is a palindrome.");
            }
            else{
                System.out.println(input + " is NOT a palindrome.");
            }

            System.out.println();
            System.out.print("Do you want to enter another input? [Yes/No] ");
            String restart = sc.nextLine();
            System.out.println();
        
            if(restart.toLowerCase().equals("no")){
                        System.out.println("Noriel Achero | 3 BSCS 1");
						System.exit(0);
            }
        }
    }
}
