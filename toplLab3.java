import java.util.*;

public class toplLab3{//Noriel Achero | 3 BSCS 1 | Theory of Programming Languages

    public static Scanner sc = new Scanner(System.in);
    public static void main (String[] args){
        
        printHeader();

        System.out.print("Enter String to test: ");
        String testString = sc.nextLine();

        System.out.println();

        String currentState = "q0";

        for(int i = 0; i < testString.length(); i++){
            if(currentState.equals("q0") && testString.charAt(i) == '0'){
                System.out.println("q0 -> q1");
                currentState = "q1";
            }
            else if(currentState.equals("q0") && testString.charAt(i) == '1'){
                System.out.println("q0 -> q0");
                currentState = "q0";
            }
            else if(currentState.equals("q1") && testString.charAt(i) == '0'){
                System.out.println("q1 -> q1");
                currentState = "q1";
            }
            else if(currentState.equals("q1") && testString.charAt(i) == '1'){
                System.out.println("q1 -> q2");
                currentState = "q2";
            }
            else if(currentState.equals("q2") && testString.charAt(i) == '0'){
                System.out.println("q2 -> q1");
                currentState = "q1";
            }
            else if(currentState.equals("q2") && testString.charAt(i) == '1'){
                System.out.println("q2 -> q0");
                currentState = "q0";
            }
            else{
                System.out.println("Invalid input.. Terminating Automaton");
                break;
            }
        }

        if(currentState.equals("q2")){
            System.out.println("\nString " + testString + " is accepted");
        }
        else{
            System.out.println("\nString " + testString + " is not accepted");
        }

    }

    static void printHeader(){
        System.out.println("DFA accepting string ending with '01' over input alphabet \u03A3 = {0, 1}");
        System.out.println();
        System.out.println("Transition Function");
        System.out.println();
        System.out.println("(q0,0) = q1");
        System.out.println("(q0,1) = q0");
        System.out.println("(q1,0) = q1");
        System.out.println("(q1,1) = q2");
        System.out.println("(q2,0) = q1");
        System.out.println("(q2,1) = q0");
        System.out.println();
        System.out.println("Initial State: q0");
        System.out.println("Final State: q2\n");
    }

}