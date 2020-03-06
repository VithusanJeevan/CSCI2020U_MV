// Author: Malaviya Nerumalan and Vithusan Jeevartnam
// Date: March 5, 2020
// Purpose: To create a GUI that reads the file and displays a graph of the number of occurrences of each letter
//**********************************************************************************************************************
package sample;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//******************************************************************************************************************
// class ReadFile
// Fields:
//         map - stores the letter and its number of occurrences
//         fileName - the file given the input
// Methods:
//         constructor
//         countLetters - counts the number of occurrences of each letter and stores the values in the map
//*******************************************************************************************************************
public class ReadFile
{
    protected Map<String, Integer> map = new HashMap<String, Integer>();
    protected String fileName;

    // constructor
    public ReadFile(String n)
    {
        this.fileName = n;
    }

    //***************************************************************************************************************
    // Author: Malaviya Nerumalan and Vithusan Jeevartnam
    // Date: March 5, 2020
    // Purpose: To count the number of ocurrences of each letter in the file and put it in the map
    // Parameters: none
    // Return: the map containing the letters and the number occurrences in the file
    //****************************************************************************************************************
    public Map<String, Integer> countLetters() throws Exception
    {
        File textFileName = new File(this.fileName);
        Scanner readFile = new Scanner(textFileName);

        String line = "";
        String letter;

        while (readFile.hasNext())
        {
            line = readFile.next();
            for (int i = 0; i < line.length(); i++)
            {
                letter = Character.toString(line.charAt(i)).toLowerCase();
                if (this.map.containsKey(letter))
                    this.map.put(letter, map.get(letter) + 1);
                else
                    this.map.put(letter, 1);
            }
        }
        readFile.close();

        return map;
    }
}
