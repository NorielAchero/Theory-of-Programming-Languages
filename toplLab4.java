import java.util.*;
import java.util.regex.*;

public class toplLab4 {//Noriel Achero | 3 BSCS 1
    
    
    static ArrayList<String> output = new ArrayList<String>();
    static boolean error = false;

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        while(true){
        

            System.out.print("Enter Source Language: ");
            String source = scan.nextLine();

            List<String> splited = splitString(source);

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
                System.out.println("Lexical Error!");
            }
            else{
                System.out.print("Output is: ");
                for (String print : output) {
                    System.out.print(print + " ");
                }
            }

            error = false;

            System.out.print("\n\nDo you wish to input more? (Enter 1 if yes, enter any key if no) ");
            String enter = scan.nextLine();

            if(enter.equals("1")){
                System.out.println();
                output.clear();
                System.out.println("-----------------------------------------------------------------------------\n");
                continue;
            }
            else{
                System.out.println("-----------------------------------------------------------------------------\n");
                System.out.println("                                 End Program ");
                break;
            }
        }

    }

    public static void tokenizer(String out){
        if(out.equals("int") || out.equals("double") || out.equals("char") || out.equals("String")){
            output.add("<data_type>");
        }
        else if(out.equals("=")){
            output.add("<assignment_operator>");
        }
        else if(out.equals(";")){
            output.add("<delimiter>");
        }
        else if(out.matches("\\d+") || out.matches("\"[^\"]*\"") || out.matches("'.'") || out.matches("\\d+\\.\\d+")){
            output.add("<value>");
        }
        else if(!out.contains("\"")){
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
