import de.daslaboratorium.machinelearning.classifier.Classifier;
import de.daslaboratorium.machinelearning.classifier.bayes.BayesClassifier;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class bayesClassifier{
    public static void main(String[] args) throws IOException {
        Classifier<String, String> bayes = new BayesClassifier<String, String>();
        String[] binaryQuestions;
        String[] specialQuestions;
        String[] tagQuestions;
        String path = "/Users/gokul-pt1831/Downloads/intern recognition/binaryDataset.txt";
        File file = new File(path);
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {

            binaryQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("binary", Arrays.asList(binaryQuestions));
        }
        path = "/Users/gokul-pt1831/Downloads/intern recognition/whDateset.txt";
        file = new File(path);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {
            specialQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("wh questions", Arrays.asList(specialQuestions));
        }

        path = "/Users/gokul-pt1831/Downloads/intern recognition/YORN.txt";
        file = new File(path);
        reader = new FileReader(file);
        buffer = new BufferedReader(reader);
        while (buffer.read() != -1) {
            tagQuestions = (buffer.readLine().toLowerCase().split("\\s"));
            bayes.learn("OR questions", Arrays.asList(tagQuestions));
        }


        while(true) {
            Scanner sc = new Scanner(System.in);
            String unknown1 = sc.nextLine();
            String[] unknownText1 = unknown1.split("\\s");
            File log;
            FileWriter fileWriter;
            BufferedWriter bufferedWriter;
            System.out.println(bayes.classify(Arrays.asList(unknownText1)).getCategory());
            System.out.println("if prediction is wrong give the correct answer 1.binary 2.wh question 3.or question 4.no change");
            int a = sc.nextInt();
            if (a == 1) {
                bayes.learn("binary", Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/binaryDataset.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n"+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
            }


            else if(a == 2){
                bayes.learn("wh questions",Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/whDateset.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n "+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
            }
            else if(a == 3){
                bayes.learn("OR questions",Arrays.asList(unknownText1));
                log = new File("/Users/gokul-pt1831/Downloads/intern recognition/YORN.txt");
                fileWriter = new FileWriter(log, true);
                bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write("\n"+unknown1);
                bufferedWriter.close();
                System.out.println("Done");
            }
            else if(a==4){
                System.out.println("Done");
            }

            ((BayesClassifier<String, String>) bayes).classifyDetailed(
                    Arrays.asList(unknownText1));
            bayes.setMemoryCapacity(1000);
        }
    }
}