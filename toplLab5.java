import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class toplLab5 {// ノリエル・アチェロ (Noriel Achero) | 3 BSCS 1 | Theory of Programming Languages

    static ArrayList<String> output = new ArrayList<String>();
    static ArrayList<String> syntaxList = new ArrayList<String>();
    static boolean error = false;
    static Scanner scan = new Scanner(System.in);
    static String syntaxFormat = "";

    public static void main (String args[]){// Integrated Simple Lexical, Syntax, and Semantic Analyzer in this program

        while(true){
            System.out.print("Enter Expression: ");
            String expression = scan.nextLine();

            List<String> splitted = splitString(expression);

            boolean lexValid = true;
            boolean syntaxValid = true;
            


            lexValid = lexical(splitted);

            if(lexValid == true){
                syntaxValid = syntax(output);
            }
            
            if(syntaxValid == true){
                semantic(syntaxList);
            }

            System.out.print("\nDo you wish to input more? (Enter 1 if yes, enter any key if no) ");
            String enter = scan.nextLine();

            if(enter.equals("1")){
                System.out.println();
                output.clear();
                syntaxList.clear();
                System.out.println("-----------------------------------------------------------------------------\n");
                continue;
            }
            else{
                System.out.println("\n-----------------------------------------------------------------------------\n");
                System.out.println("                End Program -  ありがとう ございます");
                break;
            }
        
        }

    }

    public static boolean semantic(List<String> syntaxList){

        if(syntaxFormat == "assignment"){

            if(syntaxList.get(0).equals("int") && syntaxList.get(3).matches("-?\\d+")){
                System.out.println("[[Semantically Correct!]]");
                return true;
            }
            else if(syntaxList.get(0).equals("String") && syntaxList.get(3).matches("\"[^\"]*\"")){
                System.out.println("[[Semantically Correct!]]");
                return true;                                
            }
            else if(syntaxList.get(0).equals("char") && syntaxList.get(3).matches("'.'")){
                System.out.println("[[Semantically Correct!]]");
                return true;  
            }
            else if(syntaxList.get(0).equals("double") && syntaxList.get(3).matches("-?\\d+(\\.\\d+)?")){//Note: Double can still accept whole numbers like "10"
                System.out.println("[[Semantically Correct!]]");
                return true;    
            }
            else{
                System.out.println("[[ X X Semantically Incorrect! X X ]]");
            }
        }
        else if (syntaxFormat == "declaration"){
            System.out.println("[[Semantically correct since there is no value included in the expression]]");
        }

        return false;

        
    }

    public static boolean syntax(List<String> output){

        if(output.get(0) == "<data_type>" && output.get(1) == "<identifier>" && output.get(2) == "<assignment_operator>" && output.get(3) == "<value>" && output.get(4) == "<delimiter>")
        {
            syntaxFormat = "assignment";

            return true;
        }
        else if(output.get(0) == "<data_type>" && output.get(1) == "<identifier>" && output.get(2) == "<delimiter>"){
            syntaxFormat = "declaration";

             return true;
        }
        else{
            System.out.println("[[ X X Syntactically Incorrect! X X ]]");
            return false;
        }
    }
    

    public static boolean lexical(List<String> splited){// Forged the lab activity 4 Lexial Analyzer Program
        for (String out : splited) {

            if(out.equals(";")){
                tokenizer(out);
            }
            else if(out.endsWith(";")){
                String noSemiColon = out.substring(0, out.length() - 1);
                tokenizer(noSemiColon);

                String semiColon = ";";
                tokenizer(semiColon);
            }
            else{
                tokenizer(out);
            }
        }

        System.out.println();

        if(error == true){
            System.out.println("[[ X X Lexical Error! X X ]]");
            return false;
        }
        else{
            return true;
        }
    }

    public static void tokenizer(String out){
        if(out.equals("int") || out.equals("double") || out.equals("char") || out.equals("String")){
            syntaxList.add(out);
            output.add("<data_type>");
        }
        else if(out.equals("=")){
            syntaxList.add(out);
            output.add("<assignment_operator>");
        }
        else if(out.equals(";")){
            syntaxList.add(out);
            output.add("<delimiter>");
        }
        else if(out.matches("-?\\d+") || out.matches("\"[^\"]*\"") || out.matches("'.'") || out.matches("-?\\d+(\\.\\d+)?")){
            syntaxList.add(out);
            output.add("<value>");
        }
        else if(!out.contains("\"")){
            syntaxList.add(out);
            output.add("<identifier>");
        }
        else{
            error = true;
        }
    }

    public static List<String> splitString(String input) {

        List<String> split = new ArrayList<>();
        Pattern pattern = Pattern.compile("\"([^\"]*)\"|\\S+");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String strSplit = matcher.group();
            split.add(strSplit);
        }

        return split;
    }
}
