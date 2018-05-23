package secondClassifier;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class firstLayerClassifier {

    public static void main(String[] args) throws IOException {


        while (true) {
            int flag = 0;
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            str = str.toLowerCase();
            //if(str.contains(" and ")){
              str =  str.replace(" and ",", ");
            System.out.println(str);

            Pattern re = Pattern.compile("[^.,!?\\s][^.,!?]*(?:[.,!?](?!['\"]?\\s|$)[^.,!?]*)*[.,!?]?['\"]?(?=\\s|$)", Pattern.MULTILINE | Pattern.COMMENTS);
            Matcher reMatcher = re.matcher(str);
            ArrayList<String> array = new ArrayList<String>();
            while (reMatcher.find()) {
                //System.out.println(reMatcher.group());
                array.add(reMatcher.group());
            }
            for (int counter = 0; counter < array.size(); counter++) {
                flag = 0;
                String temp = array.get(counter);
                System.out.println(temp);
                if(temp.contains("!") && !temp.contains("?")){
                    System.out.println("exclamation sentence");
                    flag = 1;

                }


                String[] split = temp.split(" ");
                Pattern re1 = Pattern.compile("( or )");
                Matcher matcher = re1.matcher(temp);
                if (matcher.find() && flag == 0) {

                    System.out.println("or questions");
                    bayes2Classifier.classifier(temp);
                    flag = 1;

                }
                re1 = Pattern.compile("^('twon't|ain't|amn't|an't|aren't|bean't|beant|bettern't|cann't|can't|cou'dn't|couldn't|daredn't|daren't|dasn't|dassn't|didn't|doesn't|don't|dursn't|hadn't|hasn't|haven't|he'sn't|I'dn't've|isn't|I'ven't|mayn't|mightn't|mustn't|needn't|oughtn't|shalln't|sha'n't|shan't|she'sn't|shou'dn't|shouldn't|'tisn't|'twasn't|'tweren't|'twou'dn't|'twouldn't|wasn't|weren't|we'ven't|whyn't|willn't|wo'n't|won't|worn't|wou'dn't|wouldn't|twont|aint|amnt|ant|arent|beant|beant|betternt|cannt|cant|coudnt|couldnt|darednt|darent|dasnt|dassnt|didnt|doesnt|dont|dursnt|hadnt|hasnt|havent|hesnt|Idntve|isnt|Ivent|maynt|mightnt|mustnt|neednt|oughtnt|shallnt|shant|shant|shesnt|shoudnt|shouldnt|tisnt|twasnt|twerent|twoudnt|twouldnt|wasnt|werent|wevent|whynt|willnt|wont|wont|wornt|woudnt|wouldnt)");
                matcher = re1.matcher(split[0]);
                if (matcher.find() && flag == 0) {
                    System.out.println("negation sentence");
                    System.out.println("reason");
                    //bayes2Classifier.classifier(temp);
                    flag = 1;
                }
                re1 = Pattern.compile("^(is|are|did|do|does|am|was|were|have|has|had|will|would|shall|should|can|could|may|might|must|ought|any)");
                matcher = re1.matcher(split[0]);
                if (matcher.find() && flag == 0) {
                    System.out.println("Binary question");
                    System.out.println("reason");
                    //bayes2Classifier.classifier(temp);
                    flag = 1;
                }
                re1 = Pattern.compile("^(what|where|who|why|when|how|how many|which|whats|what's|wat|wat's)");
                matcher = re1.matcher(temp);
                if (matcher.find() && flag == 0) {
                    System.out.println("wh questions");
                    bayes2Classifier.classifier(temp);
                    /*if (temp.contains("what")) {
                        System.out.println("description or facts related question");
                    } else if (temp.contains("who")||temp.contains("whom")||temp.contains("whose")) {
                        System.out.println("person related question");
                    } else if (temp.contains("when")) {
                        System.out.println("time related question");
                    } else if (temp.contains("where")) {
                        System.out.println("place or spots related question");
                    }else if(temp.contains("how many")||temp.contains("how much")||temp.contains("how more")){
                        System.out.println("quantity related questions");
                    }
                    else if (temp.contains("why")||temp.contains("how")) {
                        System.out.println("reasoning type of questions");
                    }
                    else if (temp.contains("which")&& temp.contains("people") || temp.contains("person")|| temp.contains("guy")){
                        System.out.println("person");
                    }
                    else if(temp.contains("which"))
                    {
                        System.out.println("thing");
                    }

                    */
                    flag = 1;

                }
                if(flag == 0 ){
                    bayes2Classifier.classifier(temp);
                    flag = 1;
                }




            }
        }
    }
}
