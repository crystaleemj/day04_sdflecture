package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        // System.out.println( "Hello World!" );

        String dirPath = args[0];
        String fileName = args[1];
        String dirPathFileName = dirPath + File.separator + fileName;

        File newDir = new File(dirPath);
        if (newDir.exists()){
            System.out.println(newDir + " directory already exists");
        } else {
            newDir.mkdir();
        }

        File newFile = new File(dirPathFileName);
        if (!newFile.exists()){
            System.out.println(dirPathFileName + " file already exists");
            System.exit(0);
        }

        //1. use FileReader and BufferedReader to read file
        //a type of decorator pattern

        FileReader fr = new FileReader(new File(dirPathFileName));
        BufferedReader br = new BufferedReader(fr);

        //stringBuilder has function to append instead of + when using String
        StringBuilder sbFileContent = new StringBuilder();
        String lineInput = "";
        //2. while loop to read file into a string variable
        while ((lineInput = br.readLine()) != null){
            sbFileContent.append(lineInput);

        }

        //3. close the readers
        br.close();
        fr.close();

        //print out the StringBuilder object sbFileContent
        //just make sure we read all the content from the file

        System.out.println(sbFileContent);

        //convert the string in sbFilecontent to all upper case 
        //print to screen
        System.out.println(sbFileContent.toString().toUpperCase());

        //convert StringBuilder to string
        //so that I can use String functions to perform other tasks
        String fileContent = sbFileContent.toString();
        fileContent = fileContent.replace(',', ' ');
        fileContent = fileContent.replace('.', ' ');
        fileContent = fileContent.replace('(', ' ');
        fileContent = fileContent.replace(')', ' ');
        fileContent = fileContent.replace('[', ' ');
        fileContent = fileContent.replace(']', ' ');
        fileContent = fileContent.replace('"', ' ');
        fileContent = fileContent.replace('?', ' ');
        fileContent = fileContent.replace('!', ' ');

        String [] fileContentArray = fileContent.split(" ");

        //store all the unique words read
        List<String> words = new ArrayList<>();

        for (String word: fileContentArray){

            Integer wordExists = words.get(word);

            if(wordExists == null){
                //new word found
                words.put(word, 1);

            } else {
                //the word exists in the Map/HashMap collection
                words.put(word, wordExists + 1);
            }
        }

        System.out.println(words);

        


        }
    }
