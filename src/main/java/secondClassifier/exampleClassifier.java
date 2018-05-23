package secondClassifier;

import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class exampleClassifier{
    public static void main(String[] args) throws IOException {
        Classifier<String, String> bayes = new BayesClassifier<String, String>();
        String[] personQuestions;
        String[] descriptionQuestions;
        String[] reasonQuestions;
        String[] timeQuestions;
        String[] quantityQuestions;

        /*
           learning in home
         */

        String path = "/Users/gokul-pt1831/Downloads/intern recognition/person1.txt";
        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {

            personQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("person", Arrays.asList(personQuestions));
        }
        path = "/Users/gokul-pt1831/Downloads/intern recognition/description1.txt";
        file = new File(path);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {
            descriptionQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("Description", Arrays.asList(descriptionQuestions));
        }

        path = "/Users/gokul-pt1831/Downloads/intern recognition/reason1.txt";
        file = new File(path);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {
            reasonQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("reason", Arrays.asList(reasonQuestions));
        }

        path = "/Users/gokul-pt1831/Downloads/intern recognition/time1.txt";
        file = new File(path);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {
            timeQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("time", Arrays.asList(timeQuestions));
        }

        path = "/Users/gokul-pt1831/Downloads/intern recognition/quantity1.txt";
        file = new File(path);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {
            quantityQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("quantity", Arrays.asList(quantityQuestions));
        }
        path = "/Users/gokul-pt1831/Downloads/intern recognition/thing1.txt";
        file = new File(path);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {
            quantityQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("thing", Arrays.asList(quantityQuestions));
        }
        path = "/Users/gokul-pt1831/Downloads/intern recognition/place1.txt";
        file = new File(path);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {
            quantityQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("place", Arrays.asList(quantityQuestions));
        }

        while(true) {
            Scanner sc = new Scanner(System.in);
            String unknown1 = sc.nextLine();
            String[] unknownText1 = unknown1.split("\\s");
            File log;
            FileWriter fileWriter;
            BufferedWriter bufferedWriter;
            System.out.println(bayes.classify(Arrays.asList(unknownText1)).getCategory());
            System.out.println("if prediction is wrong give the correct answer 1.person 2.description 3.reason 4.time 5.quantity 6.thing 7.place 8.no change");
            int a = sc.nextInt();

            /*
                learning in class
            */
            if (a == 1) {
                bayes.learn("binary", Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/person1.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n "+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
                break;
            }


            else if(a == 2){
                bayes.learn("Description",Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/description1.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n "+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
                break;
            }
            else if(a == 3){
                bayes.learn("reason",Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/reason1.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n "+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
                break;
            }
            else if(a == 4){
                bayes.learn("time",Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/time1.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n "+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
                break;
            }
            else if(a == 5){
                bayes.learn("quantity",Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/quantity1.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n "+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
                break;
            }
            else if(a == 6){
                bayes.learn("thing",Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/thing1.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n "+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
                break;
            }
            else if(a == 7){
                bayes.learn("place",Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/place1.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n "+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
                break;
            }
            else if(a==8){
                System.out.println("Done");
                break;
            }

            ((BayesClassifier<String, String>) bayes).classifyDetailed(
                    Arrays.asList(unknownText1));
            bayes.setMemoryCapacity(1000);
        }
    }
}